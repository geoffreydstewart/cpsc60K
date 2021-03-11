package org.gds.command;

import org.gds.receiver.ApplicationServer;

/*
 * This is a concrete Command in the Command Design Pattern
 */
public class ApplicationServerRestartCommand implements Command {
    ApplicationServer applicationServer;

    public ApplicationServerRestartCommand(ApplicationServer applicationServer) {
        this.applicationServer = applicationServer;
    }

    public void execute() {
        applicationServer.restart();
    }
}
