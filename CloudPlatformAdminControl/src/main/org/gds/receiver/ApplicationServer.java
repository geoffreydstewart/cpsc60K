package org.gds.receiver;

/*
 * This is a receiver in the Command Design Pattern
 */
public class ApplicationServer {
    private String adminURL;

    public ApplicationServer(String adminURL) {
        this.adminURL = adminURL;
    }

    public void start() {
        System.out.println("Starting the Application Server, Admin URL is: " + adminURL);
    }

    public void stop() {
        System.out.println("Stopping the Application Server.");
    }

    public void restart() {
        System.out.println("Restarting the Application Server, Admin URL is: " + adminURL);
    }
}
