package org.gds.receiver;

/*
 * This is a receiver in the Command Design Pattern
 */
public class MySQLDB {
    private String databaseName;

    public MySQLDB(String databaseName) {
        this.databaseName = databaseName;
    }

    public void start() {
        System.out.println("Starting the MySQL DB instance: " + databaseName);
    }

    public void stop() {
        System.out.println("Stopping the MySQL DB instance: " + databaseName);
    }

    public void reloadDefaultData() {
        System.out.println("Reloading the default data.");
    }

}
