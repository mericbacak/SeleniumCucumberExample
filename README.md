## Selenium Cucumber Example
* This project is a Selenium and Cucumber based test automation framework developed for end-to-end (E2E) testing. 
* It covers account registration, login and deletion scenarios on Automationexercise.com website.

## Requirements
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) JDK 11 
- [Maven](https://maven.apache.org/download.cgi)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) 

## Project Structure

- **src/main/java/utils**: Utility classes for auxiliary functions and methods.
- **src/main/java/pages**: Page object models representing user interface elements.
- **src/main/java/stepdefinitions**: Step definition classes for Cucumber scenarios.
- **src/main/java/runner**: Classe de test JUnit pour exécuter les tests Cucumber.
- **src/main/java/config**: Project configurations and settings.
- **src/test/resources/features**: Cucumber scenario files.
- **src/test/resources/config**: Project configuration files.
- **src/test/resources/drivers**: WebDriver Drivers.
- **src/test/resources/screenshots**: Screenshots in case of failure.

## TechStacks

- Selenium WebDriver
- Cucumber
- JUnit
- Maven
- Faker
- PrettyReports


## Reporting
* The project automatically generates reports using the Cucumber reporting plugin. 
* The reports are available in the `target` folder. 
* Additionally, screenshots are stored in the `screenshots` folder in case the scenario fails.

## Contribution et Mises à Jour

Si vous souhaitez contribuer au projet en ajoutant de nouvelles fonctionnalités ou en corrigeant des erreurs, veuillez créer une branche, effectuer vos modifications, puis soumettre une demande de fusion pour intégrer vos changements à ce dépôt.


