* Folder Location & Supported file extensions are configurable in src/main/resources/config.properties. 

* please update folder.location in properties file to desired folder location before executing the tests

* Below CSV format is acceptable

Registration Number,	Colour,	Make
KV06 OJT,	SILVER,	MERCEDES
HN11 OSX,	RED,	FIAT

* To execute the unit tests 

mvn test

* To execute the feature file 

mvn test -Dtest=RunVehicleEnquiry

* Place chrome driver in src/test/resources/driver

