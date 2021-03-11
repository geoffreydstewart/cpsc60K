package org.gds.state;

import org.gds.CloudVMControlImpl;

/**
 * A Concrete State in the State Design Pattern
 */
public class ProvisionedState extends ShutdownState {

    public ProvisionedState(CloudVMControlImpl cloudVMControl) {
        super(cloudVMControl);
    }

    /**
     * The only difference between this class and the super class, is that when transitioning from
     * ProvisionedState to StartedState, it's not counted as a restart. Restarts are NOT incremented.
     */
    @Override
    public void start() {
        System.out.println("Starting the VM: " + cloudVMControl.getVMName() + " ...");
        cloudVMControl.setState(cloudVMControl.getStartedState());
    }

    /**
     * The only difference between this class and the super class, is that when transitioning from
     * ProvisionedState to StartedState, even via a restart it's not counted as a restart. Restarts are NOT incremented.
     */
    @Override
    public void restart() {
        System.out.println("Restarting the VM: " + cloudVMControl.getVMName() + " ...");
        cloudVMControl.incrementRestarts();
        cloudVMControl.setState(cloudVMControl.getStartedState());
    }

    @Override
    public StateTypes getStateType() {
        return StateTypes.PROVISIONED;
    }

}
