package org.gds.iterator;

import java.util.Iterator;

import org.gds.factory.creator.BusinessVMOrderCreator;
import org.gds.factory.creator.StarterVMOrderCreator;
import org.gds.factory.creator.UnknownVMException;
import org.gds.factory.creator.VMTypes;
import org.gds.factory.product.VirtualMachine;

/**
 * This is a Concrete Aggregate in the Iterator Design Pattern
 */
public class ArrayBasedOrders implements Orders{
    static final int MAX_NUM_ORDERS_IN_BATCH = 6;
    int numOrders = 0;
    VirtualMachine[] virtualMachineOrders = new VirtualMachine[MAX_NUM_ORDERS_IN_BATCH];
    
    // Instantiate the concrete creator classes
    StarterVMOrderCreator starterVMOrderCreator = new StarterVMOrderCreator();
    BusinessVMOrderCreator businessVMOrderCreator = new BusinessVMOrderCreator();
    
    public ArrayBasedOrders() {
        // create some VM orders and add them to the array 
        try {
            addItem(starterVMOrderCreator.createVirtualMachineOrder(VMTypes.STANDARD.toString()));
            addItem(starterVMOrderCreator.createVirtualMachineOrder(VMTypes.STANDARD.toString()));
            addItem(starterVMOrderCreator.createVirtualMachineOrder(VMTypes.CUSTOM.toString()));
            addItem(starterVMOrderCreator.createVirtualMachineOrder(VMTypes.CUSTOM.toString()));        
            addItem(businessVMOrderCreator.createVirtualMachineOrder(VMTypes.STANDARD.toString()));
            addItem(businessVMOrderCreator.createVirtualMachineOrder(VMTypes.STANDARD.toString()));
        }
        catch (UnknownVMException uve) {
            System.out.println("An unexpected error occured: " + uve.getMessage());
            System.out.println();
        }
    }

    private void addItem(VirtualMachine vmOrder) {
        if (numOrders > MAX_NUM_ORDERS_IN_BATCH) {
            System.out.println("This order can't be included. The batch limit has been hit.");
        }
        else {
            virtualMachineOrders[numOrders] = vmOrder;
            numOrders++;
        }
    }
    
    /**
     * Returning an iterator to the client when the underlying collection is an array requires to instantiate a
     * a Concrete Iterator that we have implemented.
     */
    public Iterator<VirtualMachine> createIterator() {
        return new ArrayBasedOrdersIterator(virtualMachineOrders);
    }
    
}
