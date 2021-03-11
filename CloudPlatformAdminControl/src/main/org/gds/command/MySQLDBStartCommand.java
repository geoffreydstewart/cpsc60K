package org.gds.command;

import org.gds.receiver.MySQLDB;

/*
 * This is a concrete Command in the Command Design Pattern
 */
public class MySQLDBStartCommand implements Command {
    MySQLDB mySQLDB;

    public MySQLDBStartCommand(MySQLDB mySQLDB) {
        this.mySQLDB = mySQLDB;
    }

    public void execute() {
        mySQLDB.start();
    }
}
