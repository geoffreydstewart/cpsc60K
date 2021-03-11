/**
 * 
 */
package org.gds.component;

public final class VMConstants {

    private VMConstants() {
        // this restricts instantiation of this class
    }

    // These labels were made constants, since they are common to the base
    // characteristics of a VM, and they are also available as decorators
    public static final String MEMORY_LABEL = "Memory(GB)";
    public static final String STORAGE_LABEL = "Storage(TB)";
    public static final String NETWORK_BANDWIDTH_LABEL = "NetworkBandwidth(GB/Month)";

}
