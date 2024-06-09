# Spring Cloud Netflix Eureka Server for ToDoNotificationSystem Microservices

# Introduction 
This project serves as a Eureka Server for the ToDoNotification microservices architecture. The main objective is to facilitate service discovery among the various microservices within the ToDoNotification project. By using the Spring Boot Netflix Eureka Server, clients can register themselves with this server, making it easier for them to locate and communicate with each other in a scalable and efficient manner. 



# Getting Started
1.	Installation process
    1. Clone the repository:
    ```
    git clone https://ToDoNotification@dev.azure.com/ToDoNotification/ToDoNotificationSystem/_git/ToDoNotificationSystem-Eureka
    
    ```
    2. Navigate to the project directory:
    ```
    cd ToDoNotificationSystem-Eureka

    ```
    3. Build the project using Maven:
    ```
    mvn clean install

    ```
    4. Run the Eureka Server:
    ```
    java -jar target/ToDoNotificationSystem-Eureka-0.0.1-SNAPSHOT.jar
    
    ```
2.	Software dependencies
    - Java 17
    - Maven
    - Spring Boot 3.2.x
    - Spring Cloud 2023.0.x
    - Spring Cloud Starter Netflix Eureka Server
3.	Latest releases
4.	API references

# Build and Test
To build the project, use the following Maven command:
```
mvn clean install

```

# Contribute
TODO: Explain how other users and developers can contribute to make your code better. 

If you want to learn more about creating good readme files then refer the following [guidelines](https://docs.microsoft.com/en-us/azure/devops/repos/git/create-a-readme?view=azure-devops). You can also seek inspiration from the below readme files:
- [ASP.NET Core](https://github.com/aspnet/Home)
- [Visual Studio Code](https://github.com/Microsoft/vscode)
- [Chakra Core](https://github.com/Microsoft/ChakraCore)