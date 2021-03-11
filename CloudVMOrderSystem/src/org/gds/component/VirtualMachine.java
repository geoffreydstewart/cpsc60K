/**
 * 
 */
package org.gds.component;

/**
 * The base Component of the Decorator Design Pattern
 */
public abstract class VirtualMachine {
    String label = "";

    public String getLabel() {
        return label;
    }

    public abstract double costPerMonth();
}
