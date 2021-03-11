/**
 * 
 */
package org.gds.product;

/**
 * A concrete Product subclass of the Factory Method Design Pattern
 */
public class BusinessStandardVM extends VirtualMachine {

    public BusinessStandardVM() {
        vmName = "Standard Business VM";
        cores = 4;
        memoryGB = 32;
        storageTB = 2;
        networkBandwidthGBPerMonth = 200;
        costPerMonth = 0.50;
    }
}
