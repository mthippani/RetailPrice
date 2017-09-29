#Retail price

Prerequisites:
1. Has a running instance of mongoDb. The host for mongoDb can be customized in application.properties file. <br />
  1. To download and setup mongodb on linux: <br />
       1. `wget https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-amazon-3.2.9.tgz`
       2. `tar -xvzf ./mongodb-linux-x86_64-amazon-3.2.9.tgz`
       3.  `mkdir -p mongodb`
       4. `mv mongodb-linux-x86_64-amazon-3.2.9 mongodb`
       5. `mkdir -p mongodb/data/db`
  2. To start mongodb:
       1. `cd mongodb`
       2. `./bin/mongod --dbpath ./data/db`
2. Environment: JDK (v1.8), git to get code, mvn to build code. If maven is not present, use mvnw instead of mvn.

Steps to run:
1. `git clone https://github.com/mthippani/ReatilPrice.git`
2. `cd myRetailProducts`
3. To compile & run tests:  `mvn clean compile test`
4. To start the application and be ready for requests: `mvn spring-boot:run`


Actions:

1. Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number.

Example product ID: 13860428
Example response: {"id":13860428,"name":"Nike","current_price":{"value": 45.49,"currency_code":"USD"}}

2. Performs an HTTP PUT request  at the same path (/products/{id} using resful API. it will accept json data to update the data({"id":13860428,"name":"Nike","current_price":{"value": 45.49,"currency_code":"USD"}}
)
