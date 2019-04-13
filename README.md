# Roman Numeral Converter

## Overview

A simple web service that converts an integer to roman numeral symbols. Currently this service only supports integer to roman numeral, not the other way around.

## How to Build and Run

### With Docker

**Prerequisites**: Docker engine installed.

To easily run the service is by using docker, simply run with command:
```
docker run --name roman-converter -p 8080:8080 -d hanlakewind/roman-converter
```
This will create and run the service in a docker container named *roman-converter* with port *8080* exposed.
***The docker image is hosted in central docker hub. See the Dockerhub repo at [hanlakewind/roman-converter](https://hub.docker.com/r/hanlakewind/roman-converter)***

### Download and Build Locally

**Prerequisites**: JDK 8 installed.

To build the project locally, git clone this repo. Navigate to the root repository of the project and run
```
./mvnw clean install
```
This will create a `target` directory that contains the output of the build. The executable fat jar is in the `target` directory, named `roman-converter-X.X.X.jar` where `X.X.X` is the version number.

To run the project, run the executable jar generated in the build step with command
```
java -jar /path/to/the/roman-converter-1.0.0.jar
```
This will start a Spring Boot web application that listens to port *8080*.

## How to Use

Use a modern browser and go to the service URL with endpoint `romannumeral`. A query parameter named `query` must present. The value of the parameter is a number between **1** and **10,000,000** that you wish to convert to roman numeral.

*Example*:

```
http://localhost:8080/romannumeral?query=1234
```
Will display converted roman numeral result of *MCCXXXIV*.

***Note***: This service is not a restful API. A simple HTML template and some CSS styling is used in this service. **Internet Explorer and Microsoft Edge are not supported**.

## Testing

A comprehensive coverage of unit testing is required. The project uses JaCoCo to measure the overall test coverage, and enforce a requirement of
 - 90% line coverage
 - 80% branch coverage

You can see a detailed coverage report in the generated `target/site/jacoco/` directory by opening the `index.html` file after successfully building the project.

## Operation

### Logging

This project currently adapts SLF4J with LOG4J implementation.

### Health check

A shallow health check is enabled by spring boot actuator with endpoint `/actuator/health`

### Service metrics

Spring boot actuator provides a set of service metrics out of the box. Endpoint `/actuator/metrics` provides a list of supported metric names, append a metric name to see the details of the metrics.

*Example*
```
http://localhost:8080/actuator/metrics/http.server.requests
```
