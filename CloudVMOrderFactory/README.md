# cpsc60KFactory
CPSC 60000 Week 2 Factory Pattern

The project for this weeks assignment is in the CloudVMOrderFactory directory. In this context, it felt like the Factory Method design pattern was more appropriate than the Abstract Factory pattern, since there wasn't really a need to create related sets of objects. Some reasonable exception handling has been implemented to observe the impact on the design.

The main method in the Class org.gds.CloudVMOrderFactory

Sample program output:

```
*** Ordering a Standard Starter VM ***

Creating a blueprint for virtual machine Standard Starter VM
  VM will be configured with 2 cores
  VM will be configured with 16 GB memory
  VM will be configured with 1 TB storage
  VM will be configured with 1 GB/Month network bandwidth out
  VM will cost $0.25/Month

Provisioning the virtual machine Standard Starter VM

Generating login credentials for virtual machine Standard Starter VM

Virtual Machine Standard Starter VM is ready!

*** Ordering a Custom Starter VM ***

Creating a blueprint for virtual machine Custom Starter VM
  VM will be configured with 2 cores
  VM will be configured with 16 GB memory
  VM will be configured with 1 TB storage
  VM will be configured with 1 GB/Month network bandwidth out
  VM will be configured with 2 4GPUGraphicsCards
  VM will cost $0.65/Month

Provisioning the virtual machine Custom Starter VM

Generating login credentials for virtual machine Custom Starter VM

Virtual Machine Custom Starter VM is ready!

*** Ordering a Standard Business VM ***

Creating a blueprint for virtual machine Standard Business VM
  VM will be configured with 4 cores
  VM will be configured with 32 GB memory
  VM will be configured with 2 TB storage
  VM will be configured with 2 GB/Month network bandwidth out
  VM will cost $0.5/Month

Provisioning the virtual machine Standard Business VM

Generating login credentials for virtual machine Standard Business VM

Virtual Machine Standard Business VM is ready!

*** Ordering a Custom Business VM ***

Creating a blueprint for virtual machine Custom Business VM
  VM will be configured with 4 cores
  VM will be configured with 48 GB memory
  VM will be configured with 3 TB storage
  VM will be configured with 3 GB/Month network bandwidth out
  VM will cost $0.7/Month

Provisioning the virtual machine Custom Business VM

Generating login credentials for virtual machine Custom Business VM

Virtual Machine Custom Business VM is ready!

*** Ordering a Standard Enterprise VM ***

Creating a blueprint for virtual machine Standard Enterprise VM
  VM will be configured with 8 cores
  VM will be configured with 64 GB memory
  VM will be configured with 4 TB storage
  VM will be configured with 4 GB/Month network bandwidth out
  VM will cost $1.0/Month

Provisioning the virtual machine Standard Enterprise VM

Generating login credentials for virtual machine Standard Enterprise VM

Virtual Machine Standard Enterprise VM is ready!

*** Ordering a Custom Enterprise VM ***

Creating a blueprint for virtual machine Custom Enterprise VM
  VM will be configured with 8 cores
  VM will be configured with 64 GB memory
  VM will be configured with 4 TB storage
  VM will be configured with 4 GB/Month network bandwidth out
  VM will be configured with 24/7 Ops and Apps Support
  VM will cost $1.0/Month

Provisioning the virtual machine Custom Enterprise VM

Generating login credentials for virtual machine Custom Enterprise VM

Virtual Machine Custom Enterprise VM is ready!

Demonstrate some exception handling ...

An (expected) error occured: Unknown VM Type

```
