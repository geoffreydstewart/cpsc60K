package org.gds.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.gds.factory.creator.BusinessVMOrderCreator;
import org.gds.factory.creator.EnterpriseVMOrderCreator;
import org.gds.factory.creator.UnknownVMException;
import org.gds.factory.creator.VMTypes;
import org.gds.factory.product.VirtualMachine;

/**
 * This is a Concrete Aggregate in the Iterator Design Pattern
 */
public class QueueBasedOrders implements Orders {
    Queue<VirtualMachine> virtualMachineQueue = new LinkedList<>();

    // Instantiate the concrete creator classes
    BusinessVMOrderCreator businessVMOrderCreator = new BusinessVMOrderCreator();
    EnterpriseVMOrderCreator enterpriseVMOrderCreator = new EnterpriseVMOrderCreator();
    
    
    public QueueBasedOrders() {
        // create some VM orders and add them to the queue 
        try {
            virtualMachineQueue.add(businessVMOrderCreator.createVirtualMachineOrder(VMTypes.CUSTOM.toString()));
            virtualMachineQueue.add(businessVMOrderCreator.createVirtualMachineOrder(VMTypes.CUSTOM.toString()));
            virtualMachineQueue.add(enterpriseVMOrderCreator.createVirtualMachineOrder(VMTypes.STANDARD.toString()));
            virtualMachineQueue.add(enterpriseVMOrderCreator.createVirtualMachineOrder(VMTypes.STANDARD.toString()));
            virtualMachineQueue.add(enterpriseVMOrderCreator.createVirtualMachineOrder(VMTypes.CUSTOM.toString()));
            virtualMachineQueue.add(enterpriseVMOrderCreator.createVirtualMachineOrder(VMTypes.CUSTOM.toString()));
        }
        catch (UnknownVMException uve) {
            System.out.println("An unexpected error occured: " + uve.getMessage());
            System.out.println();
        }
    }
    
    /**
     * Returning an iterator to the client is easy when the underlying collection already has functionality to return
     * an Iterator
     */
    public Iterator<VirtualMachine> createIterator() {
        return virtualMachineQueue.iterator();
    }
    
}
