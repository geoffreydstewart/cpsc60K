package org.gds.state;

import org.gds.CloudVMControlImpl;

/**
 * A Concrete State in the State Design Pattern
 */
public class StartedState implements CloudVMState{
    private final CloudVMControlImpl cloudVMControl;

    public StartedState(CloudVMControlImpl cloudVMControl) {
        this.cloudVMControl = cloudVMControl;
    }

    @Override
    public void provision() {
        System.out.println("The VM: " + cloudVMControl.getVMName() + " is already provisioned.");
    }

    @Override
    public void shutdown() {
        System.out.println("Shutting down the VM: " + cloudVMControl.getVMName() + " ...");
        cloudVMControl.setState(cloudVMControl.getShutdownState());
    }

    @Override
    public void start() {
        System.out.println("The VM: " + cloudVMControl.getVMName() + " is already started");
    }

    @Override
    public void restart() {
        System.out.println("Restarting the VM: " + cloudVMControl.getVMName() + " ...");
        cloudVMControl.incrementRestarts();
    }

    @Override
    public void delete() {
        System.out.println("Deleting the VM: " + cloudVMControl.getVMName() + " ...");
        cloudVMControl.resetRestarts();
        cloudVMControl.setState(cloudVMControl.getDeletedState());
    }

    @Override
    public StateTypes getStateType() {
        return StateTypes.STARTED;
    }
}
