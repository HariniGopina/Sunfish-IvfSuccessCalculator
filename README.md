# IVF-Success-Calculator
IVF Success Calculator Code(Java)

The IVF Success Calculator is a web application designed to estimate the success rate of In Vitro Fertilization (IVF) based on user inputs such as age, weight, infertility factors, and prior pregnancies. The application is built with a Spring Boot backend and a frontend using vanilla JavaScript, HTML, and CSS.

Features:

•	Dynamic success rate calculation based on user inputs.

•	Backend validations to ensure accurate data input. 

•	CSV-based formula loading for flexibility.

•	Comprehensive logging for debugging and tracking.

•	Well-defined error handling for smoother user experience.

•	Integration and unit-tested for reliability.
___________________________________________________________________
Prerequisites
Before running the application, ensure the following are installed:
1.	Java: Version 11 or above.
2.	Maven: For building the backend.
___________________________________________________________________
Getting Started
1. Download the Project Folder
Unzip the project folder
Open it in any IDE(Intellij)
___________________________________________________________________
2. Setup the Backend

 a. Configuration
 1.	Ensure the application.yml (or application.properties) file is correctly configured in the src/main/resources folder.

 b. Load the CSV
 Ensure the ivf_success_formulas.csv file is placed in the resources folder as the application depends on it for formula loading.

 c. Run

 Navigate to the backend directory 
 cd backend 

 Build the application mvn clean install 

 Run the application
 mvn spring-boot:run
 OR
 In the IDE just open the main file and click on Run.
The application will be running on http://localhost:8080.
__________________________________________________________________

3. Frontend information
We have the frontend files included in the src/main/resources/static folder.
__________________________________________________________________
Testing the Application

Unit and Integration Tests

You can find the unit and integration tests in src/test folder. You can run each file or tests in the file to test the application 
You can also run mvn tests in the project folder to run all the tests.

Manual API Testing

•	There is already Swagger setup for this application. You can visit or view it in http://localhost:8080/swagger-ui/index.html

•	Or you can also use tools like Postman to test the /api/ivf/calculate endpoint.

•	Sample POST request payload:

json
{
  
  "usingOwnEggs": true,
  
  "attemptedIVFPreviously": "yes",
  
  "reasonForInfertilityKnown": true,
  
  "age": 30,
 
  "weight": 150,
  
  "heightFeet": 5,

  "heightInches": 6,
  
  "tubalFactor": false,
  
  "maleFactorInfertility": true,
  
  "endometriosis": false,
  
  "ovulatoryDisorder": false,
  
  "diminishedOvarianReserve": false,
  
  "uterineFactor": false,
  
  "otherReason": false,
  
  "unexplainedInfertility": false,
  
  "priorPregnancies": 1,
  
  "priorLiveBirths": 1
}
_______________________________________________________________________

Logs and Debugging

•	Exceptions are logged with clear messages for debugging.

•	Logs are stored in logs/application.log file for future debugging purposes.
