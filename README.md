# Using Legacy Systems 

This project implements a software system that allows the interface of the old system to be used as the new 
interface and is able to convert these two interfaces.

# Application Description

A company has two systems to access customer data. 
One is the new and developed system and the other one is the old legacy system.
The old system access the customer data using USB connection to get the customer data from some binary files.
The new system access the customer data using REST API over HTTPS connection to an external server.
You can consider that the two systems have the following APIs.

# Implementation Description

## Adapter Pattern

I used the object adapter pattern for this assignment. 
This pattern "converts the interface of a class into another interface that the clients expect to have" [1]. 
This structural pattern "lets classes work together that could not otherwise because of incompatible interfaces" [1].

Factory method pattern has the following participants:
- Client 
  - This is a "class that contains the existing business logic of the program [3]."
- Target
  - This interface "describes a protocol that other classes must follow to collaborate with the client code. [3]"
- Adapter
  - This implements Target (realization relationship) and wraps an Adaptee object (dependency relationship).
  - This implements Target's request() method and calls Adaptee's specificRequest() method.
  - This rewires the request() to invoke the specificRequest() in Adaptee.  
- Adaptee
  - This cannot be used by the client "directly because it has an incompatible interface. [3]"

Relatedly, this application has the following participants:
- Interfaces
  - CustomerData (Target)
  - CustomerDataOverHttps (Adaptee)
- Implementations
  - CustomerDataConcrete (implements Target interface)
  - CustomerDataOverHttpsConcrete (implements Adaptee interface)
  - UsbToHttpsCustomerDataAdapter (adapter implements Target interface)

Lastly,the equivalent of request() is getCustomer_withUsbConnect() and
the equivalent of specificRequest() is getCustomer_withHttpsConnect().

## Goals of Software Design 

- **Robustness**: Its frequent use for multiple targeted classes promotes robustness at the same time [1].
- **Flexibility**: A single Adapter works with many Adaptees [1].
- **Reusability**: It creates a reusable class that cooperates with unrelated or unforeseen classes [1].
- **Information Hiding**: The wrapped object, i.e., adaptee isn’t even aware of the adapter.

# UML Diagram

![](UML_Diagram.png)

# How to compile the project

We use Apache Maven to compile and run this project.

You need to install Apache Maven (https://maven.apache.org/)  on your system.

Type on the command line:

```bash
mvn clean compile
```

# How to create a binary runnable package

```bash
mvn clean compile assembly:single
```

# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" 
```

# Run all the unit test classes.

```bash
mvn clean compile test checkstyle:check  spotbugs:check
```

# Using Spotbugs to find bugs in your project

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using

```bash
mvn spotbugs:gui 
```

or

```bash
mvn spotbugs:spotbugs
```

```bash
mvn spotbugs:check 
```

check goal runs analysis like spotbugs goal, and make the build failed if it found any bugs.

For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.

# Run Checkstyle

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code
style. You can change it to other styles like sun checkstyle.

To analyze this example using CheckStyle run

```bash
mvn checkstyle:check
```

This will generate a report in XML format

```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser.

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```

# References

- [1] Adapter Pattern PPT
- [2] Module 3 PDF
- [3] https://refactoring.guru/design-patterns/adapter


