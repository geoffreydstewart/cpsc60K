package org.gds;

import java.lang.reflect.Proxy;

/**
 * This class creates Proxy objects from the Proxy Design Pattern
 */
public class CloudVMProxyCreator {

    public static CloudVMControl getAdminUserProxy(CloudVMControl vmControl) {
        return (CloudVMControl) Proxy.newProxyInstance(
            vmControl.getClass().getClassLoader(),
            vmControl.getClass().getInterfaces(),
            new AdminInvocationHandler(vmControl));
    }

    public static CloudVMControl getReadOnlyUserProxy(CloudVMControl vmControl) {
        return (CloudVMControl) Proxy.newProxyInstance(
            vmControl.getClass().getClassLoader(),
            vmControl.getClass().getInterfaces(),
            new ReadOnlyInvocation(vmControl));
    }
}
