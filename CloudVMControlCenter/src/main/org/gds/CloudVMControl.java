package org.gds;

import org.gds.state.CloudVMState;

/**
 * This is the Subject in the Proxy Design Pattern
 */
public interface CloudVMControl {
    //
    // These methods are accessible to the Admin user only
    //
    void provision() throws IllegalAccessException;

    void start() throws IllegalAccessException;

    void restart() throws IllegalAccessException;

    void shutdown() throws IllegalAccessException;

    void delete() throws IllegalAccessException;

    //
    // These methods should be available to both the Admin and ReadOnly users
    //
    String getVMName();

    int getRestarts();

    CloudVMState getState();
}
