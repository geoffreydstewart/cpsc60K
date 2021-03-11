package org.gds;

import org.gds.state.*;

/**
 * This is the Context in the State Design Pattern
 */
public class CloudVMStateTracker {

    private final DeletedState deletedState;
    private final ProvisionedState provisionedState;
    private final StartedState startedState;
    private final ShutdownState shutdownState;

    private CloudVMState state;

    private String vmName;
    private int restarts = 0;

    public CloudVMStateTracker(String vmName) {
        deletedState = new DeletedState(this);
        provisionedState = new ProvisionedState(this);
        startedState = new StartedState(this);
        shutdownState = new ShutdownState(this);

        this.vmName = vmName;
        state = deletedState;
    }

    public void provision() {
        // Delegate to the state to handle this
        state.provision();
    }

    public void start() {
        // Delegate to the state to handle this
        state.start();
    }

    public void restart() {
        // Delegate to the state to handle this
        state.restart();
    }

    public void shutdown() {
        // Delegate to the state to handle this
        state.shutdown();
    }

    public void delete() {
        // Delegate to the state to handle this
        state.delete();
    }

    public String getVMName() {
        return vmName;
    }

    public void incrementRestarts() {
        restarts++;
    }

    public void resetRestarts() {
        restarts = 0;
    }

    public int getRestarts() {
        return restarts;
    }

    public void setState(CloudVMState cloudVMState) {
        state = cloudVMState;
    }

    public CloudVMState getState() {
        return state;
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