/**
 * 
 */
package org.gds.creator;

import org.gds.product.EnterpriseStandardVM;
import org.gds.product.StarterCustomVM;
import org.gds.product.StarterStandardVM;
import org.gds.product.VirtualMachine;

/**
 * A concrete Creator subclass of the Factory Method Design Pattern
 */
public class StarterVMCreator extends VirtualMachineCreator {

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.creator.VirtualMachineCreator#createVirtualMachine()
     */
    public VirtualMachine createVirtualMachine(String type) throws UnknownVMException {
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
