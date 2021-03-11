/**
 * 
 */
package org.gds.factory.creator;

import org.gds.factory.product.VirtualMachine;

/**
 * The Creator abstract super class of the Factory Method Design Pattern
 */
public abstract class VirtualMachineOrderCreator {

    // This is the factory method!
    abstract VirtualMachine defineVirtualMachine(String type) throws UnknownVMException;
    
    public VirtualMachine createVirtualMachineOrder(String type) throws UnknownVMException {
        VirtualMachine virtualMachine = defineVirtualMachine(type);
        //virtualMachine.printVMOrder();
        return virtualMachine;
    }
    
    
}
