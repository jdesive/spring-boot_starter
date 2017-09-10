# Spring-Boot Starter
This project was modeled after a creation made using [spring.io](http://start.spring.io/).  

## How to start
### Local
1. Clone this repo to your local computer **`git clone https://github.com/jdesive/spring-boot_starter.git`**
2.  Run **`mvn spring-boot:run`** from the cloned repo's root directory
3. Open your browser and goto [**`http://localhost:8080/test`**](http://localhost:8080/test)

### Docker
1. Run the `build.sh` script to install the app and build a local docker image
2. Run `docker run -p "8080:8080" starter` to start the app in docker. 

## Dependencies
* JPA
* Web
* Rest Repositories
* DevTools
* Security
* Web Services
* Lombok
* H2
* Actuator
* Orika