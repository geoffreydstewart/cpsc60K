package org.gds.state;

import org.gds.CloudVMStateTracker;

/**
 * A Concrete State in the State Design Pattern
 */
public class StartedState implements CloudVMState{
    private final CloudVMStateTracker cloudVMStateTracker;

    public StartedState(CloudVMStateTracker cloudVMStateTracker) {
        this.cloudVMStateTracker = cloudVMStateTracker;
    }

    @Override
    public void provision() {
        System.out.println("The VM: " + cloudVMStateTracker.getVMName() + " is already provisioned.");
    }

    @Override
    public void shutdown() {
        System.out.println("Shutting down the VM: " + cloudVMStateTracker.getVMName() + " ...");
        cloudVMStateTracker.setState(cloudVMStateTracker.getShutdownState());
    }

    @Override
    public void start() {
        System.out.println("The VM: " + cloudVMStateTracker.getVMName() + " is already started");
    }

    @Override
    public void restart() {
        System.out.println("Restarting the VM: " + cloudVMStateTracker.getVMName() + " ...");
        cloudVMStateTracker.incrementRestarts();
    }

    @Override
    public void delete() {
        System.out.println("Deleting the VM: " + cloudVMStateTracker.getVMName() + " ...");
        cloudVMStateTracker.resetRestarts();
        cloudVMStateTracker.setState(cloudVMStateTracker.getDeletedState());
    }

    @Override
    public StateTypes getStateType() {
        return StateTypes.STARTED;
    }
}
