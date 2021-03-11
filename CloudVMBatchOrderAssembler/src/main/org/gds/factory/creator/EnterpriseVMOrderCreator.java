/**
 * 
 */
package org.gds.factory.creator;

import org.gds.factory.product.BusinessStandardVM;
import org.gds.factory.product.EnterpriseCustomVM;
import org.gds.factory.product.EnterpriseStandardVM;
import org.gds.factory.product.VirtualMachine;

/**
 * A concrete Creator subclass of the Factory Method Design Pattern
 */
public class EnterpriseVMOrderCreator extends VirtualMachineOrderCreator {

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.creator.VirtualMachineCreator#createVirtualMachine()
     */
    VirtualMachine defineVirtualMachine(String type) throws UnknownVMException {
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
