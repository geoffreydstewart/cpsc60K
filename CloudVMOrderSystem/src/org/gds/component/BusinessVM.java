/**
 * 
 */
package org.gds.component;

/**
 * A Concrete Component of the Decorator Design Pattern
 */
public class BusinessVM extends VirtualMachine {

    public BusinessVM() {
        label = "Business VM - Cores: 4, " + VMConstants.MEMORY_LABEL + ": 32, " + VMConstants.STORAGE_LABEL + ": 2, "
                + VMConstants.NETWORK_BANDWIDTH_LABEL + ": 200";
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.VirtualMachine#costPerMonth()
     */
    @Override
    public double costPerMonth() {
        return 0.50;
    }

}
