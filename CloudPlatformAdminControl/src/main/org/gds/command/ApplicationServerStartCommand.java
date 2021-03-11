package org.gds.command;

import org.gds.receiver.ApplicationServer;

/*
 * This is a concrete Command in the Command Design Pattern
 */
public class ApplicationServerStartCommand implements Command {
    ApplicationServer applicationServer;

    public ApplicationServerStartCommand(ApplicationServer applicationServer) {
            this.applicationServer = applicationServer;
    }

    public void execute() {
        applicationServer.start();
    }
}
