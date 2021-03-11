package org.gds.state;

import org.gds.CloudVMStateTracker;

/**
 * A Concrete State in the State Design Pattern
 */
public class DeletedState implements CloudVMState{
    private final CloudVMStateTracker cloudVMStateTracker;

    public DeletedState(CloudVMStateTracker cloudVMStateTracker) {
        this.cloudVMStateTracker = cloudVMStateTracker;
    }

    @Override
    public void provision() {
        System.out.println("Provisioning the VM: " + cloudVMStateTracker.getVMName() + " ...");
        cloudVMStateTracker.setState(cloudVMStateTracker.getProvisionedState());
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
