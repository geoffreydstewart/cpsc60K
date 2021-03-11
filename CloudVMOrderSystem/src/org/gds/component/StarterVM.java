/**
 * 
 */
package org.gds.component;

/**
 * A Concrete Component of the Decorator Design Pattern
 */
public class StarterVM extends VirtualMachine {

    public StarterVM() {
        label = "Starter VM - Cores: 2, " + VMConstants.MEMORY_LABEL + ": 16, " + VMConstants.STORAGE_LABEL + " : 1, "
                + VMConstants.NETWORK_BANDWIDTH_LABEL + ": 100";
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.VirtualMachine#costPerMonth()
     */
    @Override
    public double costPerMonth() {
        return 0.25;
    }

}
