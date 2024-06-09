# API Gateway for ToDoNotificationSystem Microservices

# Introduction 
This project serves as an API Gateway for the ToDoNotification microservices architecture. The primary objective is to provide a centralized entry point for clients to interact with the various microservices in a secure and efficient manner. By using Spring Cloud Gateway, we aim to simplify the complexities of microservices communication, routing, and handling cross-cutting concerns. 

# Getting Started
1.	Installation process
	1. Clone the repository: 
	```
	git clone https://ToDoNotification@dev.azure.com/ToDoNotification/ToDoNotificationSystem/_git/ToDoNotificationSystem-APIGateway
	
	```
	2. Navigate to the project directory:
	```
	cd ToDoNotificationSystem-APIGateway
	
	```
	3. Build the project using Maven:
	```
	mvn clean install
	
	```
	4. Run the Gateway:
	```
	java -jar target/ToDoNotificationSystem-APIGateway-0.0.1-SNAPSHOT.jar
	
	```
2.	Software dependencies
	- Java 17
	- Maven
	- Spring Boot 3.2.x
	- Spring CLoud 2023.0.x
	- Spring Cloud Starter Gateway
	- Spring Cloud Starter Load Balancer
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