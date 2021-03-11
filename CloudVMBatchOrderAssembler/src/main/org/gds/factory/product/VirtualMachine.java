/**
 * 
 */
package org.gds.factory.product;

import java.util.ArrayList;
import java.util.List;

/**
 * The Product abstract super class of the Factory Method Design Pattern
 */
public abstract class VirtualMachine {

    String vmName;
    int cores;
    int memoryGB;
    int storageTB;
    int networkBandwidthGBPerMonth;
    List<String> optionalComponents = new ArrayList<>();
    double costPerMonth;
    
    public String getVMName() {
        return vmName;
    }
    
    public void printVMOrder() {
        System.out.println("Creating an order for virtual machine " + vmName);
        System.out.println("  VM will be configured with " + cores + " cores");
        System.out.println("  VM will be configured with " + memoryGB + " GB memory");
        System.out.println("  VM will be configured with " + storageTB + " TB storage");
        System.out.println("  VM will be configured with " + storageTB + " GB/Month network bandwidth out");
        optionalComponents.forEach(component -> System.out.println("  VM will be configured with " + component));
        System.out.println("  VM will cost $" + costPerMonth + "/Month");
        System.out.println();
    }

}
