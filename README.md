# Property Management APIs

> This is a sample appliacation to showcase the ability to develop REST APIs with Spring boot and Hibernate. It should be considered as a prototype and not a full fledged application. For now, We have included only the requested APIs  

## Getting Started

### Install

This application uses H2 Database for the sake of simplicity so that no additional database servers need to be installed. 

To compile and install these dependencies, type `mvn clean package` in your terminal. This will generate the jar file.

### Run the application

After compiling using maven command, to run application, simply go to target folder and execute `java -jar property-manager-1.0.jar`

### Testing

> We have integrated Swagger for the ease of testing. Also, this can be tested using postman. 

To use swagger, after running the application go to  `http://localhost:8080/swagger-ui.html` and start testing the APIs from there

### Credentials:

> For the sake of simplicity, we have created some users with their keys so that the APIs would be accessible only with the keys. The key values needs to be passed in the request header for each request. The key for the header is `api-key` and values are different for users as per the following.

for user `admin`, the api-key value is `tpetjfj27p`

for user `innkeeper`, the api-key value is `pg94l805y4`

for the user `purchaser`, the api-key value is `l8527a5tim`
