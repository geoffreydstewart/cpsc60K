package org.gds.command;

import org.gds.receiver.ApacheKafkaInstance;

/*
 * This is a concrete Command in the Command Design Pattern
 */
public class ApacheKafkaStartCommand implements Command{
    ApacheKafkaInstance apacheKafkaInstance;

    public ApacheKafkaStartCommand(ApacheKafkaInstance apacheKafkaInstance) {
        this.apacheKafkaInstance = apacheKafkaInstance;
    }

    public void execute() {
        apacheKafkaInstance.start();
    }
}
