package org.gds;

import org.gds.state.StateTypes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloudVMStateTrackerTest {

    @Test
    void testBasicFlow() {
        CloudVMStateTracker cloudVMStateTracker = new CloudVMStateTracker("myFirstVM");
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.DELETED);

        cloudVMStateTracker.provision();
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.PROVISIONED);

        cloudVMStateTracker.start();
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.STARTED);

        cloudVMStateTracker.restart();
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.STARTED);
        assertEquals(cloudVMStateTracker.getRestarts(), 1);

        cloudVMStateTracker.shutdown();
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.SHUTDOWN);

        cloudVMStateTracker.delete();
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.DELETED);

        cloudVMStateTracker.provision();
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.PROVISIONED);
    }


    @Test
    void testInvalidTransitions() {
        CloudVMStateTracker cloudVMStateTracker = new CloudVMStateTracker("mySecondVM");
        cloudVMStateTracker.start();
        cloudVMStateTracker.restart();
        cloudVMStateTracker.shutdown();
        //Despite the above transitions, the VM remains in its original state, DELETED
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.DELETED);

        cloudVMStateTracker.provision();
        cloudVMStateTracker.shutdown();
        cloudVMStateTracker.provision();
        cloudVMStateTracker.shutdown();
        //After the first transition to PROVISIONED, the VM remains in this state
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.PROVISIONED);

        cloudVMStateTracker.start();
        cloudVMStateTracker.provision();
        cloudVMStateTracker.start();
        //The only invalid transition from START is provision. Start is a no-op
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.STARTED);

        cloudVMStateTracker.shutdown();
        cloudVMStateTracker.provision();
        cloudVMStateTracker.shutdown();
        //The only invalid transition from START is provision. Shutdown is a no-op
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.SHUTDOWN);

        cloudVMStateTracker.delete();
        cloudVMStateTracker.start();
        cloudVMStateTracker.restart();
        cloudVMStateTracker.shutdown();
        //After being deleted, the following transitions have no effect and the VM remains in DELETED state
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.DELETED);
    }

    @Test
    void testRestartCounts() {
        CloudVMStateTracker cloudVMStateTracker = new CloudVMStateTracker("myNextVM");
        cloudVMStateTracker.provision();
        assertEquals(cloudVMStateTracker.getRestarts(), 0);

        cloudVMStateTracker.start();
        // The first start, isn't counted as a restart
        assertEquals(cloudVMStateTracker.getRestarts(), 0);

        cloudVMStateTracker.restart();
        assertEquals(cloudVMStateTracker.getRestarts(), 1);

        cloudVMStateTracker.shutdown();
        cloudVMStateTracker.start();
        assertEquals(cloudVMStateTracker.getRestarts(), 2);

        cloudVMStateTracker.restart();
        cloudVMStateTracker.restart();
        assertEquals(cloudVMStateTracker.getRestarts(), 4);

        cloudVMStateTracker.delete();
        // When the VM is deleted, the restart counts should be reset
        assertEquals(cloudVMStateTracker.getRestarts(), 0);

        cloudVMStateTracker.provision();
        cloudVMStateTracker.start();
        cloudVMStateTracker.restart();
        assertEquals(cloudVMStateTracker.getRestarts(), 1);
    }

    @Test
    void testDeleteTransitions() {
        // We can transition to DELETED from any of the states, let's make sure!
        
        CloudVMStateTracker cloudVMStateTracker = new CloudVMStateTracker("myLastVM");
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.DELETED);

        cloudVMStateTracker.provision();
        cloudVMStateTracker.delete();
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.DELETED);

        cloudVMStateTracker.provision();
        cloudVMStateTracker.start();
        cloudVMStateTracker.delete();
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.DELETED);

        cloudVMStateTracker.provision();
        cloudVMStateTracker.start();
        cloudVMStateTracker.shutdown();
        cloudVMStateTracker.delete();
        assertEquals(cloudVMStateTracker.getState().getStateType(), StateTypes.DELETED);
    }

}


