package org.gds.state;

import org.gds.CloudVMControlImpl;

/**
 * A Concrete State in the State Design Pattern
 */
public class DeletedState implements CloudVMState{
    private final CloudVMControlImpl cloudVMControl;

    public DeletedState(CloudVMControlImpl cloudVMControl) {
        this.cloudVMControl = cloudVMControl;
    }

    @Override
    public void provision() {
        System.out.println("Provisioning the VM: " + cloudVMControl.getVMName() + " ...");
        cloudVMControl.setState(cloudVMControl.getProvisionedState());
    }

    @Override
    public void shutdown() {
        System.out.println("A non-existent VM can't be deleted.");
    }

    @Override
    public void start() {
        System.out.println("A non-existent VM can't be started.");
    }

    @Override
    public void restart() {
        System.out.println("A non-existent VM can't be restarted.");
    }

    @Override
    public void delete() {
        System.out.println("A non-existent VM can't be deleted.");
    }

    @Override
    public StateTypes getStateType() {
        return StateTypes.DELETED;
    }
}
