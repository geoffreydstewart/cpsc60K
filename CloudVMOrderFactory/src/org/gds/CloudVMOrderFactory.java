/**
 * 
 */
package org.gds;

import org.gds.creator.BusinessVMCreator;
import org.gds.creator.EnterpriseVMCreator;
import org.gds.creator.StarterVMCreator;
import org.gds.creator.UnknownVMException;
import org.gds.creator.VMTypes;

public class CloudVMOrderFactory {

    public static void main(String[] args) {
        // Instantiate the concrete creator classes
        StarterVMCreator starterVMCreator = new StarterVMCreator();
        BusinessVMCreator businessVMCreator = new BusinessVMCreator();
        EnterpriseVMCreator enterpriseVMCreator = new EnterpriseVMCreator();
        
        // order some VMs! One of each please.
        try {
            starterVMCreator.orderVirtualMachine(VMTypes.STANDARD.toString());
            starterVMCreator.orderVirtualMachine(VMTypes.CUSTOM.toString());
        
            businessVMCreator.orderVirtualMachine(VMTypes.STANDARD.toString());
            businessVMCreator.orderVirtualMachine(VMTypes.CUSTOM.toString());
            
            enterpriseVMCreator.orderVirtualMachine(VMTypes.STANDARD.toString());
            enterpriseVMCreator.orderVirtualMachine(VMTypes.CUSTOM.toString());
            
            // This will throw an exception 
            System.out.println("Demonstrate some exception handling ...");
            System.out.println();
            starterVMCreator.orderVirtualMachine(VMTypes.UNKNOWN.toString());
        }
        catch (UnknownVMException uve) {
            System.out.println("An (expected) error occured: " + uve.getMessage());
            System.out.println();
        }

    }

}
