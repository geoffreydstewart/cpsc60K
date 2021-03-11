package org.gds.receiver;

/*
 * This is a receiver in the Command Design Pattern
 */
public class ApacheKafkaInstance {

    private String connectString;

    public ApacheKafkaInstance(String connectString) {
        this.connectString = connectString;
    }

    public void start() {
        System.out.println("Starting the Apache Kafka instance, connect string is: " + connectString);
    }

    public void stop() {
        System.out.println("Stopping the Apache Kafka instance.");
    }
}
