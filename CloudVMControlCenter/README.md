# cpsc60KProxy
CPSC 60000 Week 6 Proxy

The project for this weeks assignment is in the CloudVMControlCenter directory. This code builds upon the assignment from last week and implements a Protection Proxy, using the Context from State Design Pattern which now doubles as the Real Subject from the Proxy Design pattern. Adding the Protection Proxy, controls access to the CloudVM operations. In this program example, there are two users, AdminUser and ReadOnlyUser. Performing CloudVM operations is restricted to the AdminUser, and both the AdminUser and ReadOnlyUser can view the state of the CloudVMs.

The project uses JUnit 5 for unit testing. The test class CloudVMControlCenterTest, is located in the src/test directory.
