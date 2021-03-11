/**
 * 
 */
package org.gds.factory.product;

/**
 * A concrete Product subclass of the Factory Method Design Pattern
 */
public class BusinessCustomVM extends VirtualMachine {
    
    public BusinessCustomVM() {
        vmName = "Custom Business VM";
        cores = 4;
        memoryGB = 48;
        storageTB = 3;
        networkBandwidthGBPerMonth = 100;
        costPerMonth = 0.70;
    }

}
