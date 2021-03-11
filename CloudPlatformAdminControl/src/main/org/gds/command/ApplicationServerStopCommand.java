package org.gds.command;

import org.gds.receiver.ApplicationServer;

/*
 * This is a concrete Command in the Command Design Pattern
 */
public class ApplicationServerStopCommand implements Command {
    ApplicationServer applicationServer;

    public ApplicationServerStopCommand(ApplicationServer applicationServer) {
        this.applicationServer = applicationServer;
    }

    public void execute() {
        applicationServer.stop();
    }
}
