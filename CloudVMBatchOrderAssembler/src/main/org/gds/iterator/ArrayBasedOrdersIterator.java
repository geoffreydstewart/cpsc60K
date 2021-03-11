package org.gds.iterator;

import java.util.Iterator;

import org.gds.factory.product.VirtualMachine;

/**
 * This is a Concrete Iterator in the Iterator Design Pattern. 
 */
public class ArrayBasedOrdersIterator implements Iterator<VirtualMachine>{
    VirtualMachine[] virtualMachineOrders;
    int position = 0;
    
    public ArrayBasedOrdersIterator(VirtualMachine[] virtualMachineOrders) {
        this.virtualMachineOrders = virtualMachineOrders;
    }

    @Override
    public boolean hasNext() {
        if (position >= virtualMachineOrders.length || virtualMachineOrders[position] == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public VirtualMachine next() {
        VirtualMachine virtualMachineOrder = virtualMachineOrders[position];
        position++;
        return virtualMachineOrder;
    }
    
    /**
     * Note: the remove method does not need to be implemented. A default {@code remove} implementation
     * is provided in the interface.
     * {@link java.util.Iterator} 
     */


}
