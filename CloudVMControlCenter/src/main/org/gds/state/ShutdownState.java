package org.gds.state;

import org.gds.CloudVMControlImpl;

/**
 * A Concrete State in the State Design Pattern
 */
public class ShutdownState implements CloudVMState {
    final CloudVMControlImpl cloudVMControl;

    public ShutdownState(CloudVMControlImpl cloudVMControl) {
        this.cloudVMControl = cloudVMControl;
    }

    @Override
    public void provision() {
        System.out.println("The VM: " + cloudVMControl.getVMName() + " is already provisioned.");
    }

    @Override
    public void shutdown() {
        System.out.println("The VM: " + cloudVMControl.getVMName() + " is already shutdown.");
    }

    @Override
    public void start() {
        System.out.println("Starting the VM: " + cloudVMControl.getVMName() + " ...");
        cloudVMControl.incrementRestarts();
        cloudVMControl.setState(cloudVMControl.getStartedState());
    }

    @Override
    public void restart() {
        System.out.println("Restarting the VM: " + cloudVMControl.getVMName() + " ...");
        cloudVMControl.incrementRestarts();
        cloudVMControl.setState(cloudVMControl.getStartedState());
    }

    @Override
    public void delete() {
        System.out.println("Deleting the VM: " + cloudVMControl.getVMName() + " ...");
        cloudVMControl.resetRestarts();
        cloudVMControl.setState(cloudVMControl.getDeletedState());
    }

    @Override
    public StateTypes getStateType() {
        return StateTypes.SHUTDOWN;
    }
}
