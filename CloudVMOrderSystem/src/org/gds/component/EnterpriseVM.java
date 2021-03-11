/**
 * 
 */
package org.gds.component;

/**
 * A Concrete Component of the Decorator Design Pattern
 */
public class EnterpriseVM extends VirtualMachine {

    public EnterpriseVM() {
        label = "Enterprise VM - Cores: 8, " + VMConstants.MEMORY_LABEL + ": 64, " + VMConstants.STORAGE_LABEL + ": 4, "
                + VMConstants.NETWORK_BANDWIDTH_LABEL + ": 500";
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.VirtualMachine#costPerMonth()
     */
    @Override
    public double costPerMonth() {
        return 1.0;
    }

}
