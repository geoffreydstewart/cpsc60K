/**
 * 
 */
package org.gds.decorator;

import org.gds.component.VMConstants;
import org.gds.component.VirtualMachine;

/**
 * A Concrete Decorator of the Decorator Design Pattern
 */
public class Add100GBNetworkBandwidth extends VMDecorator {

    VirtualMachine vm;

    public Add100GBNetworkBandwidth(VirtualMachine vm) {
        this.vm = vm;
    }

    public String getLabel() {
        return vm.getLabel() + ", " + VMConstants.NETWORK_BANDWIDTH_LABEL + ": 100";
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.VirtualMachine#costPerMonth()
     */
    @Override
    public double costPerMonth() {
        return 0.05 + vm.costPerMonth();
    }

}
