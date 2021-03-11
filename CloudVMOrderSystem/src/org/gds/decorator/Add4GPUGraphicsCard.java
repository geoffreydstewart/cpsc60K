/**
 * 
 */
package org.gds.decorator;

import org.gds.component.VirtualMachine;

/**
 * A Concrete Decorator of the Decorator Design Pattern
 */
public class Add4GPUGraphicsCard extends VMDecorator {

    VirtualMachine vm;

    public Add4GPUGraphicsCard(VirtualMachine vm) {
        this.vm = vm;
    }

    public String getLabel() {
        return vm.getLabel() + ", 4GPUGraphicsCard(s): 1";
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.VirtualMachine#costPerMonth()
     */
    @Override
    public double costPerMonth() {
        return 0.20 + vm.costPerMonth();
    }

}
