package org.gds;

import org.gds.command.*;
import org.gds.receiver.ApacheKafkaInstance;
import org.gds.receiver.ApplicationServer;
import org.gds.receiver.MySQLDB;

import java.util.LinkedList;
import java.util.Queue;

public class CloudPlatformAdminControl {
    public static void main(String[] args) {
        // In the Command Design pattern, this commandQueue, together with the BackgroundCommandProcessor, play the
        // role of the Invoker, since the queue holds the commands, and the command processor eventually calls each
        // command's execute method
        Queue<Command> commandQueue = new LinkedList<>();

        // Instantiate the BackgroundCommandProcessor, composing it with a reference to the command queue
        BackgroundCommandProcessor commandProcessor = new BackgroundCommandProcessor(commandQueue);
        // Start it up!
        commandProcessor.startCommandProcessor();

        // Simulate some client operations
        simulateClientOperations(commandQueue);

        // We need to chill here for a moment, to give the BackgroundCommandProcessor a chance to start executing
        // the commands, since the very next thing we do is shut it down
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Hmmm, this is unexpected");
        }

        // Stop the BackgroundCommandProcessor
        commandProcessor.stopCommandProcessor();
    }

    /**
     * Simulate the logic which is performed by a client of the CloudPlatformAdminControl. In case it's not obvious,
     * this logic represents the Client role in the Command Design pattern.
     */
    private static void simulateClientOperations(Queue<Command> commandQueue) {
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

    }

}
