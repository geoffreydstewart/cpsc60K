package org.gds;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

import org.gds.factory.product.VirtualMachine;
import org.gds.iterator.ArrayBasedOrders;
import org.gds.iterator.Orders;
import org.gds.iterator.QueueBasedOrders;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CloudVMBatchOrderAssemblerTest {
    
    // This class is the client in the Iterator Design Pattern
    static class TestIteratorClient {
        Orders arrayBasedOrders;
        Orders queueBasedOrders;
        
        TestIteratorClient(Orders arrayBasedOrders, Orders queueBasedOrders) {
            this.arrayBasedOrders = arrayBasedOrders;
            this.queueBasedOrders = queueBasedOrders;
        }
        
        public void printOrders() {
            Iterator<VirtualMachine> arrayOrdersIterator = arrayBasedOrders.createIterator();
            Iterator<VirtualMachine> queueOrdersIterator = queueBasedOrders.createIterator();
            printOrders(arrayOrdersIterator);
            printOrders(queueOrdersIterator);
        }
        
        void printOrders(Iterator<VirtualMachine> ordersIterator) {
            while (ordersIterator.hasNext()) {
                ordersIterator.next().printVMOrder();
            }
        }
    }
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err; 
    
    @BeforeEach
    void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void tearDown() throws Exception {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    
    @Test
    void theBigTest() {
        
        Orders arrayBasedOrders = new ArrayBasedOrders();
        Orders queueBasedOrders = new QueueBasedOrders();
        TestIteratorClient client = new TestIteratorClient(arrayBasedOrders, queueBasedOrders);
        client.printOrders();
        
        assertEquals("Creating an order for virtual machine Standard Starter VM\n"
                + "  VM will be configured with 2 cores\n"
                + "  VM will be configured with 16 GB memory\n"
                + "  VM will be configured with 1 TB storage\n"
                + "  VM will be configured with 1 GB/Month network bandwidth out\n"
                + "  VM will cost $0.25/Month\n"
                + "\n"
                + "Creating an order for virtual machine Standard Starter VM\n"
                + "  VM will be configured with 2 cores\n"
                + "  VM will be configured with 16 GB memory\n"
                + "  VM will be configured with 1 TB storage\n"
                + "  VM will be configured with 1 GB/Month network bandwidth out\n"
                + "  VM will cost $0.25/Month\n"
                + "\n"
                + "Creating an order for virtual machine Custom Starter VM\n"
                + "  VM will be configured with 2 cores\n"
                + "  VM will be configured with 16 GB memory\n"
                + "  VM will be configured with 1 TB storage\n"
                + "  VM will be configured with 1 GB/Month network bandwidth out\n"
                + "  VM will be configured with 2 4GPUGraphicsCards\n"
                + "  VM will cost $0.65/Month\n"
                + "\n"
                + "Creating an order for virtual machine Custom Starter VM\n"
                + "  VM will be configured with 2 cores\n"
                + "  VM will be configured with 16 GB memory\n"
                + "  VM will be configured with 1 TB storage\n"
                + "  VM will be configured with 1 GB/Month network bandwidth out\n"
                + "  VM will be configured with 2 4GPUGraphicsCards\n"
                + "  VM will cost $0.65/Month\n"
                + "\n"
                + "Creating an order for virtual machine Standard Business VM\n"
                + "  VM will be configured with 4 cores\n"
                + "  VM will be configured with 32 GB memory\n"
                + "  VM will be configured with 2 TB storage\n"
                + "  VM will be configured with 2 GB/Month network bandwidth out\n"
                + "  VM will cost $0.5/Month\n"
                + "\n"
                + "Creating an order for virtual machine Standard Business VM\n"
                + "  VM will be configured with 4 cores\n"
                + "  VM will be configured with 32 GB memory\n"
                + "  VM will be configured with 2 TB storage\n"
                + "  VM will be configured with 2 GB/Month network bandwidth out\n"
                + "  VM will cost $0.5/Month\n"
                + "\n"
                + "Creating an order for virtual machine Custom Business VM\n"
                + "  VM will be configured with 4 cores\n"
                + "  VM will be configured with 48 GB memory\n"
                + "  VM will be configured with 3 TB storage\n"
                + "  VM will be configured with 3 GB/Month network bandwidth out\n"
                + "  VM will cost $0.7/Month\n"
                + "\n"
                + "Creating an order for virtual machine Custom Business VM\n"
                + "  VM will be configured with 4 cores\n"
                + "  VM will be configured with 48 GB memory\n"
                + "  VM will be configured with 3 TB storage\n"
                + "  VM will be configured with 3 GB/Month network bandwidth out\n"
                + "  VM will cost $0.7/Month\n"
                + "\n"
                + "Creating an order for virtual machine Standard Enterprise VM\n"
                + "  VM will be configured with 8 cores\n"
                + "  VM will be configured with 64 GB memory\n"
                + "  VM will be configured with 4 TB storage\n"
                + "  VM will be configured with 4 GB/Month network bandwidth out\n"
                + "  VM will cost $1.0/Month\n"
                + "\n"
                + "Creating an order for virtual machine Standard Enterprise VM\n"
                + "  VM will be configured with 8 cores\n"
                + "  VM will be configured with 64 GB memory\n"
                + "  VM will be configured with 4 TB storage\n"
                + "  VM will be configured with 4 GB/Month network bandwidth out\n"
                + "  VM will cost $1.0/Month\n"
                + "\n"
                + "Creating an order for virtual machine Custom Enterprise VM\n"
                + "  VM will be configured with 8 cores\n"
                + "  VM will be configured with 64 GB memory\n"
                + "  VM will be configured with 4 TB storage\n"
                + "  VM will be configured with 4 GB/Month network bandwidth out\n"
                + "  VM will be configured with 24/7 Ops and Apps Support\n"
                + "  VM will cost $1.0/Month\n"
                + "\n"
                + "Creating an order for virtual machine Custom Enterprise VM\n"
                + "  VM will be configured with 8 cores\n"
                + "  VM will be configured with 64 GB memory\n"
                + "  VM will be configured with 4 TB storage\n"
                + "  VM will be configured with 4 GB/Month network bandwidth out\n"
                + "  VM will be configured with 24/7 Ops and Apps Support\n"
                + "  VM will cost $1.0/Month\n\n", outContent.toString());
    }

}
