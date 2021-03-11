package org.gds;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This is an Invocation Handler in the Proxy Design Pattern
 */
public class AdminInvocationHandler implements InvocationHandler {
    CloudVMControl cloudVMControl;

    public AdminInvocationHandler(CloudVMControl cloudVMControl) {
        this.cloudVMControl = cloudVMControl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            switch (method.getName()) {
                case "provision":
                case "start":
                case "restart":
                case "shutdown":
                case "delete":
                case "getVMName":
                case "getRestarts":
                case "getState": return method.invoke(cloudVMControl, args);
                default: throw new IllegalAccessException("The method " + method.getName() + " is not valid.");
            }
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
