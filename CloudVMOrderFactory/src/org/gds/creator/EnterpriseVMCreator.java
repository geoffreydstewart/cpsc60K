/**
 * 
 */
package org.gds.creator;

import org.gds.product.BusinessStandardVM;
import org.gds.product.EnterpriseCustomVM;
import org.gds.product.EnterpriseStandardVM;
import org.gds.product.VirtualMachine;

/**
 * A concrete Creator subclass of the Factory Method Design Pattern
 */
public class EnterpriseVMCreator extends VirtualMachineCreator {

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.creator.VirtualMachineCreator#createVirtualMachine()
     */
    VirtualMachine createVirtualMachine(String type) throws UnknownVMException {
        if (type.equals(VMTypes.CUSTOM.toString())) {
            return new EnterpriseCustomVM();
        }
        else if (type.equals(VMTypes.STANDARD.toString())) {
            return new EnterpriseStandardVM();
        }
        else {
            throw new UnknownVMException("Unknown VM Type");
        }
    }
}
