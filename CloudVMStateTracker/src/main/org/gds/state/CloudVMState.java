package org.gds.state;

/**
 * The State interface in the State Design Pattern
 */
public interface CloudVMState {
    void provision();

    void shutdown();

    void start();

    void restart();

    void delete();

    /**
     * In addition to the state transitions, provide a way to report the current state
     */
    StateTypes getStateType();

}
