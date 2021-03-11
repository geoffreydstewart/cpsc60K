/**
 * 
 */
package org.gds.product;

/**
 * A concrete Product subclass of the Factory Method Design Pattern
 */
public class EnterpriseCustomVM extends VirtualMachine {

    public EnterpriseCustomVM() {
        vmName = "Custom Enterprise VM";
        cores = 8;
        memoryGB = 64;
        storageTB = 4;
        networkBandwidthGBPerMonth = 500;
        optionalComponents.add("24/7 Ops and Apps Support");
        costPerMonth = 1.00;
    }
    
}
