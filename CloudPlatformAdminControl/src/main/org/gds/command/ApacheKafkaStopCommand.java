package org.gds.command;

import org.gds.receiver.ApacheKafkaInstance;

/*
 * This is a concrete Command in the Command Design Pattern
 */
public class ApacheKafkaStopCommand implements Command{
    ApacheKafkaInstance apacheKafkaInstance;

    public ApacheKafkaStopCommand(ApacheKafkaInstance apacheKafkaInstance) {
        this.apacheKafkaInstance = apacheKafkaInstance;
    }

    public void execute() {
        apacheKafkaInstance.stop();
    }

}
