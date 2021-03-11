package org.gds.command;

import org.gds.receiver.MySQLDB;

/*
 * This is a concrete Command in the Command Design Pattern
 */
public class MySQLDBReloadDefaultDataCommand implements Command {
    MySQLDB mySQLDB;

    public MySQLDBReloadDefaultDataCommand(MySQLDB mySQLDB) {
        this.mySQLDB = mySQLDB;
    }

    public void execute() {
        mySQLDB.reloadDefaultData();
    }
}
