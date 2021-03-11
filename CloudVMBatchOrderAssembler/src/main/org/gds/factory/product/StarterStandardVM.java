/**
 * 
 */
package org.gds.factory.product;

/**
 * A concrete Product subclass of the Factory Method Design Pattern
 */
public class StarterStandardVM extends VirtualMachine {

    public StarterStandardVM() {
        vmName = "Standard Starter VM";
        cores = 2;
        memoryGB = 16;
        storageTB = 1;
        networkBandwidthGBPerMonth = 100;
        costPerMonth = 0.25;
    }
}
