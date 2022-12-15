# Getting Started

### Development guide

#### Stack
* Java 19 [link](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html)
* Spring Boot  
* DB H2

#### Tools
* Maven 3.8.6

### Project Scaffolding
* Controller - interface of http layer
  * Exception - application exception handler
  * Mapper - Mappings between domain object and user view
  * View - User view definition
* Domain - Objects that represents app's domain
* Repository - Data access and represent data model 
* Service - Core of application use cases 

### Running Project

#### Profiles
Used to start a specific environment settings.
* development
* production (todo)

This command cleans previous compiled packages and generate new sources 
```bash
mvn clean install
```

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=development
```

### Resources

* Product Price

PATH
```go
GET /products/:product_id/price
```
PARAMS
* brand_id(integer)
* start   (datetime)

Request
```curl
curl --location --request GET 'localhost:8080/products/35455/price?brand_id=1&start=2020-06-16T21:00:00'
```

Response
```json
{
    "product_id": 35455,
    "brand_id": 1,
    "price": 38.95,
    "price_list": 4,
    "start_at": "2020-06-15T16:00:00",
    "end_at": "2020-12-31T23:59:59"
}
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.0/maven-plugin/reference/html/#build-image)

