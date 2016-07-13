A very simple application implementing the Payment.java interface as restful endpoints. 

The application will compile to a war file that can run under *Apache Tomcat*.


I created the initial project using this :
`mvn -U -X -V archetype:generate -DgroupId=au.com.fis.devtest -DartifactId=PaymentChecker -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false`

Then just add the necessary jars to the pom.xml and get coding!

The restful endpoints that are exposed are :

* /PaymentChecker/rest/payment/checkNumber?cardNumber=<cardNumber>
* /PaymentChecker/rest/payment/checkAmount?amount=<value with decimal point removed eg $1.99 should be sent as 199>
* /PaymentChecker/rest/payment/checkExpiry?cardNumber=<cardNumber>&expiryMonth=<value>&expiryYear=<value>

Its all pretty simple and has unit test coverage for most of the business logic.

You will find Mod10Checker.java which I've implemented a luhn calculation for the check digit. I hope its right!


