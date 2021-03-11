/**
 * 
 */
package org.gds;

import org.gds.component.BusinessVM;
import org.gds.component.EnterpriseVM;
import org.gds.component.StarterVM;
import org.gds.component.VirtualMachine;
import org.gds.decorator.Add16GBMemory;
import org.gds.decorator.Add1TBStorage;
import org.gds.decorator.Add24By7OpsAndAppsSupport;
import org.gds.decorator.Add4GPUGraphicsCard;
import org.gds.decorator.VMPrettyPrint;

public class CloudVMOrderSystem {

    public static void main(String[] args) {
        System.out.println("Preparing the next order of Virtual Machines...");
        System.out.println();
        
        VirtualMachine enterpriseVM = new EnterpriseVM();
        enterpriseVM = new Add24By7OpsAndAppsSupport(enterpriseVM);
        printOrder(enterpriseVM.getLabel(), enterpriseVM.costPerMonth());
        // there's no need to wrap the current VirtualMachine with the VMPrettyPrint
        // decorator, since it doesn't have any duplicate outputs.
        System.out.println();

        VirtualMachine customBusinessVM = new BusinessVM();
        customBusinessVM = new Add16GBMemory(customBusinessVM);
        customBusinessVM = new Add1TBStorage(customBusinessVM);
        // not wrapped by the VMPrettyPrint decorator, shows duplicate outputs for
        // Memory and Storage, rather than a total
        printOrder(customBusinessVM.getLabel(), customBusinessVM.costPerMonth());
        // wrapping the current VirtualMachine with the VMPrettyPrint decorator, shows a
        // nicely formatted VMOrder
        customBusinessVM = new VMPrettyPrint(customBusinessVM);
        printOrder(customBusinessVM.getLabel(), customBusinessVM.costPerMonth());
        System.out.println();

        VirtualMachine neuralNetworkVM = new StarterVM();
        neuralNetworkVM = new Add4GPUGraphicsCard(neuralNetworkVM);
        neuralNetworkVM = new Add4GPUGraphicsCard(neuralNetworkVM);
        // not wrapped by the VMPrettyPrint decorator, shows duplicate outputs for
        // 4GPUGraphicsCard, rather than a total
        printOrder(neuralNetworkVM.getLabel(), neuralNetworkVM.costPerMonth());
        // wrapping the current VirtualMachine with the VMPrettyPrint decorator, shows a
        // nicely formatted VMOrder
        neuralNetworkVM = new VMPrettyPrint(neuralNetworkVM);
        printOrder(neuralNetworkVM.getLabel(), neuralNetworkVM.costPerMonth());

    }

    private static void printOrder(String label, double costPerMonth) {
        System.out.println(label + ". VM costs $" + costPerMonth + "/Month");
    }

}
