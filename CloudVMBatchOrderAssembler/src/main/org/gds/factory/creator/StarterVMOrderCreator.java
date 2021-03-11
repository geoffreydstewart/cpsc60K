/**
 * 
 */
package org.gds.factory.creator;

import org.gds.factory.product.EnterpriseStandardVM;
import org.gds.factory.product.StarterCustomVM;
import org.gds.factory.product.StarterStandardVM;
import org.gds.factory.product.VirtualMachine;

/**
 * A concrete Creator subclass of the Factory Method Design Pattern
 */
public class StarterVMOrderCreator extends VirtualMachineOrderCreator {

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.creator.VirtualMachineCreator#createVirtualMachine()
     */
    public VirtualMachine defineVirtualMachine(String type) throws UnknownVMException {
        if (type.equals(VMTypes.CUSTOM.toString())) {
            return new StarterCustomVM();
        }
        else if (type.equals(VMTypes.STANDARD.toString())) {
            return new StarterStandardVM();
        }
        else {
            throw new UnknownVMException("Unknown VM Type");
        }
    }
}
