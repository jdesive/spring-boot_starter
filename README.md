# Spring-Boot Starter
This project was modeled after a creation made using [spring.io](http://start.spring.io/).  

## Features
* Liquibase
* In-memory database for tests
* Specification JPA repositories
* Mockito and MockMvc for testing
* External PostgreSQL database
* Swagger API documentation 
* Automated Dockerization with docker-maven-plugin

## How to start
### Local
1. Clone this repo to your local computer **`git clone https://github.com/jdesive/spring-boot_starter.git`**
2.  Run **`mvn spring-boot:run`** from the cloned repo's root directory
3. Open your browser and goto [**`localhost:8080/users`**](http://localhost:8080/users)

### Docker
1. Run the `sudo ./mvnw package docker:build` script to install the app and build a local docker image
2. Run `docker run -p "8080:8080" spring-boot-starter` to start the app in docker. 

*If you are pushing to a docker repo you can use `sudo ./mvnw docker:push` to push*

## API Documentation
Goto [**`http://localhost:8080/swagger-ui.html`**](http://localhost:8080/swagger-ui.html) once you have started the application to view the swagger documentation.

## Maven Dependencies
* [Jackson-core](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.9.1)
* [Guava](https://mvnrepository.com/artifact/com.google.guava/guava/23.0)
* [Spring Boot Starters](https://mvnrepository.com/artifact/org.springframework.boot)
  * [Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
  * [Data Rest](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-rest)
  * [Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
  * [Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)
* [H2](https://mvnrepository.com/artifact/com.h2database/h2)
* [Liquibase](https://mvnrepository.com/artifact/org.liquibase/liquibase-core/3.5.3)
* [PostgreSQL](https://mvnrepository.com/artifact/postgresql/postgresql/9.1-901-1.jdbc4)
* [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)
* [Swagger](https://mvnrepository.com/artifact/io.springfox)