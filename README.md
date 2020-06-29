# BILL
Microservice responsible for managing the bills of sale

## Table of contents
* [Technologies](#technologies)
* [Prerequisites](#prerequisites)
* [Setup](#setup)
* [Usage](#usage)

## Technologies
Project is created with:
* Java version: 1.8
* Spring-boot version: 2.3.1.RELEASE
* Lombok version: 1.18.12
* Ojdbc8 version: 19.7.0.0
* Springfox-swagger2 version: 2.9.2
* Springfox-swagger-ui: 2.9.2
* Spring-boot-starter-data-jpa version: 2.3.1.RELEASE
* Junit version: 4.13

## Prerequisites
* Maven version: 3.6.1
* Docker version: 19.03.8
* [Oracle database installed and configured](https://github.com/YesidHoyos/oracle-database/blob/master/README.md).
* Network created with Docker: ```docker network create --subnet 172.168.0.1/24 --gateway 172.168.0.2 -d bridge yhoyos-network```

## Setup
To run this project, execute it using maven and docker:

```
$ cd proyectBaseFolder
$ mvn clean install
$ docker build -t bill-microservice:1.0.0 .
$ docker run -d -p 9090:9090 --name billMicroservice --network yhoyos-network --ip 172.168.0.21 bill-microservice:1.0.0
```
To view the service initialization log running: `docker logs container_id`

After the service has started, you can access the rest api documentation at http://localhost:9090/swagger-ui.html

**Note:**
If you want to run this service locally you must modify the application.properties file in the property spring.datasource.url by changing the ip to localhost.

## Usage
Load this [collection](Order.postman_collection.json) in postman and use the request Bill
