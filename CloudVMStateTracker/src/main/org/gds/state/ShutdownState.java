package org.gds.state;

import org.gds.CloudVMStateTracker;

/**
 * A Concrete State in the State Design Pattern
 */
public class ShutdownState implements CloudVMState {
    final CloudVMStateTracker cloudVMStateTracker;

    public ShutdownState(CloudVMStateTracker cloudVMStateTracker) {
        this.cloudVMStateTracker = cloudVMStateTracker;
    }

    @Override
    public void provision() {
        System.out.println("The VM: " + cloudVMStateTracker.getVMName() + " is already provisioned.");
    }

    @Override
    public void shutdown() {
        System.out.println("The VM: " + cloudVMStateTracker.getVMName() + " is already shutdown.");
    }

    @Override
    public void start() {
        System.out.println("Starting the VM: " + cloudVMStateTracker.getVMName() + " ...");
        cloudVMStateTracker.incrementRestarts();
        cloudVMStateTracker.setState(cloudVMStateTracker.getStartedState());
    }

    @Override
    public void restart() {
        System.out.println("Restarting the VM: " + cloudVMStateTracker.getVMName() + " ...");
        cloudVMStateTracker.incrementRestarts();
        cloudVMStateTracker.setState(cloudVMStateTracker.getStartedState());
    }

    @Override
    public void delete() {
        System.out.println("Deleting the VM: " + cloudVMStateTracker.getVMName() + " ...");
        cloudVMStateTracker.resetRestarts();
        cloudVMStateTracker.setState(cloudVMStateTracker.getDeletedState());
    }

    @Override
    public StateTypes getStateType() {
        return StateTypes.SHUTDOWN;
    }
}
