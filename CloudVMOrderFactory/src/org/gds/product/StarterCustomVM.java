/**
 * 
 */
package org.gds.product;

/**
 * A concrete Product subclass of the Factory Method Design Pattern
 */
public class StarterCustomVM extends VirtualMachine {

    public StarterCustomVM() {
        vmName = "Custom Starter VM";
        cores = 2;
        memoryGB = 16;
        storageTB = 1;
        networkBandwidthGBPerMonth = 100;
        optionalComponents.add("2 4GPUGraphicsCards");
        costPerMonth = 0.65;
    }
}
