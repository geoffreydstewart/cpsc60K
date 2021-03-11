/**
 * 
 */
package org.gds.factory.product;

/**
 * A concrete Product subclass of the Factory Method Design Pattern
 */
public class EnterpriseStandardVM extends VirtualMachine {
    
    public EnterpriseStandardVM() {
        vmName = "Standard Enterprise VM";
        cores = 8;
        memoryGB = 64;
        storageTB = 4;
        networkBandwidthGBPerMonth = 500;
        costPerMonth = 1.00;
    }

}
