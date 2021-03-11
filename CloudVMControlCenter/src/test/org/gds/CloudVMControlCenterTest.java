package org.gds;

import org.gds.state.StateTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CloudVMControlCenterTest {

    private static final String VM1_NAME = "vm1";
    private static final String VM2_NAME = "vm2";
    private static final String VM3_NAME = "vm3";

    Map<String, CloudVMControl> allVMs = new HashMap<>();

    @BeforeEach
    void setupVMs() throws IllegalAccessException {
        CloudVMControl vmControl1 = new CloudVMControlImpl(VM1_NAME);
        vmControl1.provision();
        vmControl1.start();

        allVMs.put(VM1_NAME, vmControl1);

        CloudVMControl vmControl2 = new CloudVMControlImpl(VM2_NAME);
        vmControl2.provision();
        vmControl2.start();
        vmControl2.restart();
        vmControl2.shutdown();

        allVMs.put(VM2_NAME, vmControl2);

        CloudVMControl vmControl3 = new CloudVMControlImpl(VM3_NAME);
        vmControl3.provision();

        allVMs.put(VM3_NAME, vmControl3);

    }

    @Test
    void testAdminUserProxy() throws IllegalAccessException {
        // The AdminUser can perform operations on the VMs, inspect the state and
        // restart counts

        //Start with VM1
        CloudVMControl cloudVMControl = allVMs.get(VM1_NAME);
        assertEquals(VM1_NAME, cloudVMControl.getVMName());

        CloudVMControl adminUserProxy = CloudVMProxyCreator.getAdminUserProxy(cloudVMControl);
        assertEquals(StateTypes.STARTED, adminUserProxy.getState().getStateType());

        adminUserProxy.restart();
        assertEquals(StateTypes.STARTED, adminUserProxy.getState().getStateType());

        assertEquals(1, adminUserProxy.getRestarts());

        adminUserProxy.delete();
        assertEquals(StateTypes.DELETED, adminUserProxy.getState().getStateType());

        //Let's try VM3
        cloudVMControl = allVMs.get(VM3_NAME);
        assertEquals(VM3_NAME, cloudVMControl.getVMName());

        // get a NEW instance of the AdminUser Proxy for this VM
        adminUserProxy = CloudVMProxyCreator.getAdminUserProxy(cloudVMControl);
        assertEquals(StateTypes.PROVISIONED, adminUserProxy.getState().getStateType());

        adminUserProxy.start();
        assertEquals(StateTypes.STARTED, adminUserProxy.getState().getStateType());

        adminUserProxy.restart();
        assertEquals(StateTypes.STARTED, adminUserProxy.getState().getStateType());

        assertEquals(1, adminUserProxy.getRestarts());
    }

    @Test
    void testReadOnlyUserProxy() {
        // The ReadOnlyUser can NOT perform operations on the VMs, but is able to inspect the state and
        // restart counts

        // Start with VM1
        CloudVMControl cloudVMControl = allVMs.get(VM1_NAME);
        assertEquals(VM1_NAME, cloudVMControl.getVMName());

        CloudVMControl readOnlyUserProxy = CloudVMProxyCreator.getReadOnlyUserProxy(cloudVMControl);
        assertEquals(StateTypes.STARTED, readOnlyUserProxy.getState().getStateType());

        // The IllegalAccessException is thrown when the ReadOnlyUser tries to shutdown the VM
        IllegalAccessException thrown = assertThrows(IllegalAccessException.class, readOnlyUserProxy::shutdown);
        assertTrue(thrown.getMessage().contains("The ReadOnly user cant access method"));

        // The IllegalAccessException is thrown when the ReadOnlyUser tries to restart the VM
        thrown = assertThrows(IllegalAccessException.class, readOnlyUserProxy::restart);
        assertTrue(thrown.getMessage().contains("The ReadOnly user cant access method"));

        assertEquals(readOnlyUserProxy.getRestarts(), 0);

        // Let's try VM2
        cloudVMControl = allVMs.get(VM2_NAME);
        assertEquals(VM2_NAME, cloudVMControl.getVMName());

        // get a NEW instance of the ReadOnlyUser Proxy for this VM
        readOnlyUserProxy = CloudVMProxyCreator.getReadOnlyUserProxy(cloudVMControl);
        assertEquals(StateTypes.SHUTDOWN, readOnlyUserProxy.getState().getStateType());

        thrown = assertThrows(IllegalAccessException.class, readOnlyUserProxy::start);
        assertTrue(thrown.getMessage().contains("The ReadOnly user cant access method"));

        thrown = assertThrows(IllegalAccessException.class, readOnlyUserProxy::delete);
        assertTrue(thrown.getMessage().contains("The ReadOnly user cant access method"));

        assertEquals(readOnlyUserProxy.getRestarts(), 1);
    }

}


