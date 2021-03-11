# cpsc60KCommand
CPSC 60000 Week 3 Command Pattern

The project for this weeks assignment is in the CloudPlatformAdminControl directory. For the Command Design Pattern, rather than use an example which closely followed the examples from the book, I wanted to explore using the Command Pattern to queue requests as described on page 228 of the course text book.

There is a main method in the Class org.gds.CloudPlatformAdminControl

The project uses JUnit 5 for unit testing.

Sample program output:

```
Starting the command processor ...
Starting the Apache Kafka instance, connect string is: localhost:9092
Stopping the Apache Kafka instance.
Starting the MySQL DB instance: testDB
Stopping the MySQL DB instance: testDB
Reloading the default data.
Starting the Application Server, Admin URL is: https://localhost:8080/admin
Stopping the Application Server.
Restarting the Application Server, Admin URL is: https://localhost:8080/admin
Stopping the command processor ...
This Runnable has been interrupted, breaking out of the loop.
```
