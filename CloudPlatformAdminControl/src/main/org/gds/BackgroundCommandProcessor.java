package org.gds;

import org.gds.command.Command;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BackgroundCommandProcessor {
    private Queue<Command> commandQueue;
    private ExecutorService threadExecutor;

    public BackgroundCommandProcessor(Queue<Command> commandQueue) {
        this.commandQueue = commandQueue;
    }

    public void startCommandProcessor() {
        System.out.println("Starting the command processor ...");
        //Instantiate an anonymous implementation of a Runnable using a lambda
        Runnable runnable = () -> {
            // loop forever, there is control logic in the loop to break out
            while (true) {
                // if there is no command in the queue, sleep
                if (commandQueue.peek() == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // The thread will be interrupted when this Runnable is asked to shutdown
                        System.out.println("This Runnable has been interrupted, breaking out of the loop.");
                        break;
                    }
                } // there is a command in the queue, execute it!
                else {
                    Command command = commandQueue.poll();
                    command.execute();
                }
            }
        };

        // We just need a single background thread here, but using an ExecutorService is a good practice.
        threadExecutor = Executors.newSingleThreadExecutor();
        threadExecutor.submit(runnable);
    }

    public void stopCommandProcessor(){
        System.out.println("Stopping the command processor ...");
        // Shutdown the ExecutorService
        threadExecutor.shutdownNow();
    }
}
