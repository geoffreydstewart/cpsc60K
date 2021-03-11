package org.gds.command;

import org.gds.receiver.MySQLDB;

/*
 * This is a concrete Command in the Command Design Pattern
 */
public class MySQLDBStopCommand implements Command {
    MySQLDB mySQLDB;

    public MySQLDBStopCommand(MySQLDB mySQLDB) {
        this.mySQLDB = mySQLDB;
    }

    public void execute() {
        mySQLDB.stop();
    }
}
