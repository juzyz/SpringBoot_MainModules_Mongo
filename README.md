# SpringBoot_MainModules_Mongo

### Introduction

**Spring Boot** is an open-source Java-based framework designed to simplify the process of building, deploying, and running production-ready applications based on the Spring framework. Spring Boot provides a convention-over-configuration approach, allowing developers to create stand-alone, production-grade Spring-based Applications with minimal effort.

**Spring MVC** (Model-View-Controller) is a framework within the broader Spring framework that facilitates the development of web applications based on the Model-View-Controller architectural pattern. It provides a structured way to build scalable and maintainable web applications in Java.

![SpringMvcSchema](https://github.com/juzyz/SpringBoot_Demo/assets/96008515/1abcd1fa-9d76-4da9-86a4-33ebf4948f09)


**Spring Security** is a versatile module that simplifies authentication and authorization for Java applications. Key features include support for various authentication mechanisms, fine-grained access control, token-based security (such as JWT), secure password storage, and seamless integration with Spring Boot. 

![SpringSecuritySchema](https://github.com/juzyz/SpringBoot_Demo/assets/96008515/abe679a7-9f08-4659-be6c-cc8c4a31ccdc)


**Spring Data JPA** is part of the larger Spring Data project, aiming to simplify data access in Spring-based applications, particularly in the context of Java Persistence API (JPA). JPA is a standard specification for object-relational mapping (ORM) in Java, providing a programming interface for managing relational data in Java applications.

**Spring OpenApi Docs** helps to document RESTful services, providing explanations of the input, output, and endpoint URL for each API to enhance effective usage. In this project, the springdoc-openapi java library is used to automate API generation and integration with Swagger. Default Swagger link is http://localhost:8080/swagger-ui/index.html.

<img src="https://github.com/juzyz/SpringBoot_MainModules_Mongo/assets/96008515/093e17be-0c5e-4732-bef8-e16774a87051" width="700" height="300">


**PostgreSQL** is a powerful open-source relational database management system. It is known for its advanced features, extensibility, and compliance with SQL standards. PostgreSQL is widely used for various types of applications, ranging from small projects to large enterprise-level systems.




### Used frameworks 

1. Java: **17**
2. Spring Boot: **3.0.0**


### Prerequisites

Ensure you have the following installed:
- Maven
- MongoDB

### Quick Start 

1. Clone the repository:

```
 git clone https://github.com/juzyz/SpringBoot_MainModules_Mongo.git
```

2. Navigate to the project directory:

```
cd SpringBoot_MainModules_Mongo
```

3. Build the project using Maven:
   
```
mvn clean install
```

### Configuration

Configure the Mongo database connection in src/main/resources/application.yml:

```
spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: studentManager
```

### Endpoints

#### 1. Authentication Controller

| Endpoints   |   Method    | Description | Parameters | Request Body |
| ----------- | ----------- |----------- |----------- |----------- |
| api/v1/auth/authenticate  | POST     |Authenticates a user based on provided credentials.| None| `email` (String): The email of the user.<br> `password` (String): The password of the user.

The access token is ```eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbi5tYWlsQGdtYWlsLmNvbSIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE3MDI0NDAxNjcsImV4cCI6MTcwMjUyNjU2N30.XhxHpimn-nnVS6eKgRHdKgjhI4R8dGichVKhx4O6ALg```

#### 2. Student Controller

| Endpoints   |   Method    | Description | Parameters | Request Body |
| ----------- | ----------- |----------- |----------- |----------- |
| api/v1/student  | GET     |Retrieves a list of all students.| None| None
| api/v1/student  | POST    |Creates a new student with the provided details.| None| `name` (String): The student's name  <br>`email` (String): The student's email address<br> `dateOfBirth` (String): The student's date of birth
| api/v1/student/{studentId}  | PUT     | Updates the student information based on the provided student's data.|  `studentId` (Integer): The unique identifier of the student.|`name` (String): The student's name  <br>`email` (String): The student's email address.
| api/v1/student/{studentId}  | DELETE     | Deletes the student information based on the provided `studentId`.|  `studentId` (Integer): The unique identifier of the student. | None


### Contributing
Feel free to contribute to this project by opening issues or submitting pull requests. 
 

