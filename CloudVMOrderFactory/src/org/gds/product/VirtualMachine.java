/**
 * 
 */
package org.gds.product;

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
    
    public void createVMBlueprint() {
        System.out.println("Creating a blueprint for virtual machine " + vmName);
        System.out.println("  VM will be configured with " + cores + " cores");
        System.out.println("  VM will be configured with " + memoryGB + " GB memory");
        System.out.println("  VM will be configured with " + storageTB + " TB storage");
        System.out.println("  VM will be configured with " + storageTB + " GB/Month network bandwidth out");
        optionalComponents.forEach(component -> System.out.println("  VM will be configured with " + component));
        System.out.println("  VM will cost $" + costPerMonth + "/Month");
        System.out.println();
    }
    
    public void provision() {
        System.out.println("Provisioning the virtual machine " + vmName);
        System.out.println();
    }
    
    public void generateCredentials() {
        System.out.println("Generating login credentials for virtual machine " + vmName);
        System.out.println();
    }
    
    public void done() {
        System.out.println("Virtual Machine " + vmName + " is ready!");
        System.out.println();
    }
    
}
