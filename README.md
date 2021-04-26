# calculator-challenge
This project was created for a Java Challenge. It is a REST API that exposes the basic features of a calculator.

Implemented using Spring Boot, it uses RabbitMQ for the communication between the two modules, **Rest** and **Calculator**.

## Start environment

### RabbitMQ docker container
```
cd rabbitmq-local

docker compose up
```

### Build project
```
mvn clean package -DskipTests
```

### Start rest module
```
java -jar rest/target/rest-0.0.1.jar
```

### Start calculator module
```
java -jar calculator/target/calculator-0.0.1.jar
```

## SwaggerUI
Swagger UI is used to document and test the REST API from the browser. It can be accessed from this address (http://localhost:8081/calculator/swagger-ui.html)

## Request Examples
---

### Addition
```
curl -i "http://localhost:8081/calculator/api/v1/sum?a={num1}&b={num2}"
```
### Example
```
curl -i "http://localhost:8081/calculator/api/v1/sum?a=10&b=5"
...
HTTP/1.1 200 OK Content-Type: application/json
{"result":15}
```
---

### Subtraction
```
curl -i "http://localhost:8081/calculator/api/v1/sub?a={num1}&b={num2}"
```
#### Example
```
curl -i "http://localhost:8081/calculator/api/v1/sub?a=10&b=5"
...
HTTP/1.1 200 OK Content-Type: application/json
{"result":5}
```
---

### Multiplication
```
curl -i "http://localhost:8080/calculator/api/v1/mul?a={num1}&b={num2}"
```
#### Example
```
curl -i "http://localhost:8080/calculator/api/v1/mul?a=10&b=5"
...
HTTP/1.1 200 OK Content-Type: application/json
{"result":50}
```
---

### Division
```
curl -i "http://localhost:8080/calculator/api/v1/divb?a={num1}&b={num2}"
```
#### Example
```
curl -i "http://localhost:8080/calculator/api/v1/div?a=10&b=5"
...
HTTP/1.1 200 OK Content-Type: application/json
{"result":2}
```
