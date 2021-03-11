package org.gds.decorator;

import org.gds.component.VirtualMachine;

/**
 * The base Decorator of the Decorator Design Pattern
 */
public abstract class VMDecorator extends VirtualMachine {

    public abstract String getLabel();

}
