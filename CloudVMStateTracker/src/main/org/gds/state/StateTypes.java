package org.gds.state;

/**
 * This enum isn't essential to the implementation of the State pattern, but it really facilitates
 * unit testing!
 */
public enum StateTypes {
    DELETED,
    PROVISIONED,
    STARTED,
    SHUTDOWN;
}
