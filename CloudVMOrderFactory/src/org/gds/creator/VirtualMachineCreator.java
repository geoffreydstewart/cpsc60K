/**
 * 
 */
package org.gds.creator;

import org.gds.product.VirtualMachine;

/**
 * The Creator abstract super class of the Factory Method Design Pattern
 */
public abstract class VirtualMachineCreator {

    // This is the factory method!
    abstract VirtualMachine createVirtualMachine(String type) throws UnknownVMException;
    
    public VirtualMachine orderVirtualMachine(String type) throws UnknownVMException {
        VirtualMachine virtualMachine = createVirtualMachine(type);
        if (null != virtualMachine) {
            System.out.println("*** Ordering a " + virtualMachine.getVMName() + " ***");
            System.out.println();
            virtualMachine.createVMBlueprint();
            virtualMachine.provision();
            virtualMachine.generateCredentials();
            virtualMachine.done();
        }
        return virtualMachine;
    }
    
    
}
