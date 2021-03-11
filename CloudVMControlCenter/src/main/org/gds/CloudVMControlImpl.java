package org.gds;

import org.gds.state.*;

/**
 * This is the Real Subject in the Proxy Design Pattern
 * It is also the Context in the State Design Pattern from last weeks assignment
 * but the class is renamed, and now it implements the CloudVMControl Interface
 */
public class CloudVMControlImpl implements CloudVMControl{

    private final DeletedState deletedState;
    private final ProvisionedState provisionedState;
    private final StartedState startedState;
    private final ShutdownState shutdownState;

    private CloudVMState state;

    private final String vmName;
    private int restarts = 0;

    public CloudVMControlImpl(String vmName) {
        deletedState = new DeletedState(this);
        provisionedState = new ProvisionedState(this);
        startedState = new StartedState(this);
        shutdownState = new ShutdownState(this);

        this.vmName = vmName;
        state = deletedState;
    }

    //
    // These methods are accessible to the Admin user only
    //
    public void provision() throws IllegalAccessException {
        // Delegate to the state to handle this
        state.provision();
    }

    public void start() throws IllegalAccessException {
        // Delegate to the state to handle this
        state.start();
    }

    public void restart() throws IllegalAccessException {
        // Delegate to the state to handle this
        state.restart();
    }

    public void shutdown() throws IllegalAccessException {
        // Delegate to the state to handle this
        state.shutdown();
    }

    public void delete() throws IllegalAccessException {
        // Delegate to the state to handle this
        state.delete();
    }

    //
    // These methods should be available to the Admin and ReadOnly user
    //
    public String getVMName() {
        return vmName;
    }

    public int getRestarts() {
        return restarts;
    }

    public CloudVMState getState() {
        return state;
    }

    //
    // These methods should not be accessible to neither Admin nor User
    // They are required for the correct functioning of the State Design pattern.
    //
    public void incrementRestarts() {
        restarts++;
    }

    public void resetRestarts() {
        restarts = 0;
    }

    public void setState(CloudVMState cloudVMState) {
        state = cloudVMState;
    }

    public DeletedState getDeletedState() {
        return deletedState;
    }

    public ProvisionedState getProvisionedState() {
        return provisionedState;
    }

    public StartedState getStartedState() {
        return startedState;
    }

    public ShutdownState getShutdownState() {
        return shutdownState;
    }
}