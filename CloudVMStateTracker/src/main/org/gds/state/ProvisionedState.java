package org.gds.state;

import org.gds.CloudVMStateTracker;

/**
 * A Concrete State in the State Design Pattern
 */
public class ProvisionedState extends ShutdownState {

    public ProvisionedState(CloudVMStateTracker cloudVMStateTracker) {
        super(cloudVMStateTracker);
    }

    /**
     * The only difference between this class and the super class, is that when transitioning from
     * ProvisionedState to StartedState, it's not counted as a restart. Restarts are NOT incremented.
     */
    @Override
    public void start() {
        System.out.println("Starting the VM: " + cloudVMStateTracker.getVMName() + " ...");
        cloudVMStateTracker.setState(cloudVMStateTracker.getStartedState());
    }

    /**
     * The only difference between this class and the super class, is that when transitioning from
     * ProvisionedState to StartedState, even via a restart it's not counted as a restart. Restarts are NOT incremented.
     */
    @Override
    public void restart() {
        System.out.println("Restarting the VM: " + cloudVMStateTracker.getVMName() + " ...");
        cloudVMStateTracker.incrementRestarts();
        cloudVMStateTracker.setState(cloudVMStateTracker.getStartedState());
    }

    @Override
    public StateTypes getStateType() {
        return StateTypes.PROVISIONED;
    }

}
