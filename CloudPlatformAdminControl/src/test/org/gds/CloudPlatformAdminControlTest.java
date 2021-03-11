package org.gds;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

import org.gds.command.ApacheKafkaStartCommand;
import org.gds.command.ApacheKafkaStopCommand;
import org.gds.command.ApplicationServerRestartCommand;
import org.gds.command.ApplicationServerStartCommand;
import org.gds.command.ApplicationServerStopCommand;
import org.gds.command.Command;
import org.gds.command.MySQLDBReloadDefaultDataCommand;
import org.gds.command.MySQLDBStartCommand;
import org.gds.command.MySQLDBStopCommand;
import org.gds.receiver.ApacheKafkaInstance;
import org.gds.receiver.ApplicationServer;
import org.gds.receiver.MySQLDB;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CloudPlatformAdminControlTest {
    
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
    void testCloudPlatformAdminControl() {
        // In the Command Design pattern, this commandQueue, together with the BackgroundCommandProcessor, play the
        // role of the Invoker, since the queue holds the commands, and the command processor eventually calls each
        // command's execute method
        Queue<Command> commandQueue = new LinkedList<>();
        
        // Instantiate the BackgroundCommandProcessor, composing it with a reference to the command queue
        BackgroundCommandProcessor commandProcessor = new BackgroundCommandProcessor(commandQueue);
        // Start it up!
        commandProcessor.startCommandProcessor();
        
        assertEquals("Starting the command processor ...\n", outContent.toString());
        
        outContent.reset();
        
        //Instantiate the receivers
        ApacheKafkaInstance apacheKafkaInstance = new ApacheKafkaInstance("localhost:9092");
        MySQLDB mySQLDB = new MySQLDB("testDB");
        ApplicationServer applicationServer = new ApplicationServer("https://localhost:8080/admin");

        //Instantiate the concrete commands, composing each with the appropriate receiver object.
        ApacheKafkaStartCommand apacheKafkaStartCommand = new ApacheKafkaStartCommand(apacheKafkaInstance);
        ApacheKafkaStopCommand apacheKafkaStopCommand = new ApacheKafkaStopCommand(apacheKafkaInstance);

        MySQLDBStartCommand mySQLDBStartCommand = new MySQLDBStartCommand(mySQLDB);
        MySQLDBStopCommand mySQLDBStopCommand = new MySQLDBStopCommand(mySQLDB);
        MySQLDBReloadDefaultDataCommand mySQLDBReloadDefaultDataCommand = new MySQLDBReloadDefaultDataCommand(mySQLDB);

        ApplicationServerStartCommand appServerStartCommand = new ApplicationServerStartCommand(applicationServer);
        ApplicationServerStopCommand appServerStopCommand = new ApplicationServerStopCommand(applicationServer);
        ApplicationServerRestartCommand appServerRestartCommand = new ApplicationServerRestartCommand(applicationServer);

        // Add the commands to the queue.
        commandQueue.add(apacheKafkaStartCommand);
        commandQueue.add(apacheKafkaStopCommand);
        commandQueue.add(mySQLDBStartCommand);
        commandQueue.add(mySQLDBStopCommand);
        commandQueue.add(mySQLDBReloadDefaultDataCommand);
        commandQueue.add(appServerStartCommand);
        commandQueue.add(appServerStopCommand);
        commandQueue.add(appServerRestartCommand);
        
        // We need to chill here for a moment, to give the BackgroundCommandProcessor a chance to start executing
        // the commands, so we can test for their output
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            fail("Hmmm, this InterruptedException is unexpected.");
        }

        assertEquals("Starting the Apache Kafka instance, connect string is: localhost:9092\n" + 
                     "Stopping the Apache Kafka instance.\n" + 
                     "Starting the MySQL DB instance: testDB\n" + 
                     "Stopping the MySQL DB instance: testDB\n" + 
                     "Reloading the default data.\n" + 
                     "Starting the Application Server, Admin URL is: https://localhost:8080/admin\n" +
                     "Stopping the Application Server.\n" + 
                     "Restarting the Application Server, Admin URL is: https://localhost:8080/admin\n", outContent.toString());
        
        outContent.reset();
        
        // Stop the BackgroundCommandProcessor
        commandProcessor.stopCommandProcessor();
        
        assertEquals("Stopping the command processor ...\n", outContent.toString());
        
    }

}
