/**
 * 
 */
package org.gds.decorator;

import org.gds.component.VirtualMachine;

/**
 * A Concrete Decorator of the Decorator Design Pattern
 */
public class Add24By7OpsAndAppsSupport extends VMDecorator {
    VirtualMachine vm;

    public Add24By7OpsAndAppsSupport(VirtualMachine vm) {
        this.vm = vm;
    }

    public String getLabel() {
        return vm.getLabel() + ", 24By7OpsAndAppsSupport: 1";
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
