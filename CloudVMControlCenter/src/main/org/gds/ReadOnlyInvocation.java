package org.gds;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This is an Invocation Handler in the Proxy Design Pattern
 */
public class ReadOnlyInvocation implements InvocationHandler {
    CloudVMControl cloudVMControl;

    public ReadOnlyInvocation(CloudVMControl cloudVMControl) {
        this.cloudVMControl = cloudVMControl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            switch (method.getName()) {
                case "getVMName":
                case "getRestarts":
                case "getState": return method.invoke(cloudVMControl, args);
                default: throw new IllegalAccessException("The ReadOnly user cant access method " + method.getName());
            }
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
