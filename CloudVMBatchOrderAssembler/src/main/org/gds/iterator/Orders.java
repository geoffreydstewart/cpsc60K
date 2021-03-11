package org.gds.iterator;

import java.util.Iterator;
import org.gds.factory.product.VirtualMachine;

/**
 * This is the Aggregate in the Iterator Design Pattern, and will be implemented by Concrete Aggregates
 */
public interface Orders {
    
    public Iterator<VirtualMachine> createIterator();

}
