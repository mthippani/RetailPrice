#Retail price

Prerequisites:
1) Download mongodb database installable file
2) Install mongo database.
3) Create folder in C:\Schema\data\db
4) Execute "C:\Program Files\MongoDB\Server\3.4\bin\mongod.exe" --dbpath C:\Schema\data\db
5) For confirmation,Execute C:\Program Files\MongoDB\Server\3.4\bin\mongo.exe
6) MongoDB Server is up and working.
7) Environment: JDK (v1.8), git to get code, mvn to build code. If maven is not present, use mvnw instead of mvn.

Steps to run:
1. `git clone https://github.com/mthippani/ReatilPrice.git`
2. `cd myRetailProducts`
3. To compile & run tests:  `mvn clean compile test`
4. To start the application and be ready for requests: `mvn spring-boot:run`
	

Actions:

1)Access product data using get request from browser/post man.
 http://localhost:8080/products/13860428
 
2)Update record:
 
 URL: http://localhost:8080/products/13860428
 Method : PUT
 Content-Type: application/json
 body: {"id":13860428,"name":"The Big Lebowski (Blu-ray)","currentPrice":{"value":56,"currencyCode":"USD"}}
