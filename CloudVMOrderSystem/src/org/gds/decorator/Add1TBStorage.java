/**
 * 
 */
package org.gds.decorator;

import org.gds.component.VMConstants;
import org.gds.component.VirtualMachine;

/**
 * A Concrete Decorator of the Decorator Design Pattern
 */
public class Add1TBStorage extends VMDecorator {

    VirtualMachine vm;

    public Add1TBStorage(VirtualMachine vm) {
        this.vm = vm;
    }

    public String getLabel() {
        return vm.getLabel() + "," + VMConstants.STORAGE_LABEL + ": 1";
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.VirtualMachine#costPerMonth()
     */
    @Override
    public double costPerMonth() {
        return 0.10 + vm.costPerMonth();
    }

}
