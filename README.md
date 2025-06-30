Launch URL: https://www.saucedemo.com/

**UC-1 Test Login form with empty credentials**:
- Type any credentials into "Username" and "Password" fields.
- Clear the inputs.
- Hit the "Login" button.
- Check the error messages: "Username is required".

**UC-2 Test Login form with credentials by passing Username**:
- Type any credentials in username.
- Enter password.
- Clear the "Password" input.
- Hit the "Login" button.
- Check the error messages: "Password is required".

**UC-3 Test Login form with credentials by passing Username & Password**:
- Type credentials in username which are under Accepted username are sections.
- Enter password as secret sauce.
- Click on Login and validate the title “Swag Labs” in the dashboard.
  - *Note*: Since login page and the inventory page (the one that loads after a successful login) both have a "Swag Labs" title, I checked the URL to verify if it was a successful login.
- Provide parallel execution, add logging for tests and use Data Provider to parametrize tests. Make sure that all tasks are supported by these 3 conditions: UC-1; UC-2; UC-3.
  - *Note*:
    - With Cucumber it's better tu use a Scenario Outline instead of the Data Provider.
    - The Cucumber login.feature has a Scenario Outline to run multiple tests (instead of a Data Provider)
    - I also created `@ParametrizedTests` with JUnit in the `LoginParameterTest` class

To perform the task use the various of additional options:
- Test Automation tool: Selenium WebDriver;
- Project Builder: Maven;
- Browsers: 1) Firefox; 2) Edge;
  - *Note*: I also included support for Chrome if it can't find Firefox or Edge
- Locators: XPath;
- Test Runner: JUnit;
  - *Note*: 
    - Since it needs parallel execution and JUnit only does unit tests, I'm using TestNG that can be executed with the `resources/testng.xml` file
    - JUnit tests are in in `src/test/java/test`
    - Cucumber/TestNG/Parallel tests in `src/test/java/runners`, `src/test/java/stepdefinitions`, `src/test/resources` and `src/test/resources/features`
- [Optional] Patterns: 1) Singleton; 2) Adapter; 3) Strategy;
  - *Note*:
    - The *Singleton* pattern is implemented in the DriverManager class to manage only one WebDriver for all the JUnit test
    - The *Adapter* pattern, although not programmed by me, is seen while using SLF4J as an adapter to Log4j (we could change Log4j for logback, JLo, LN2, etc)
    - The *Strategy* pattern is not implemented
- [Optional] Test automation approach: BDD;
  - *Note*: To do this, I'm using Cucumber for the tests
- Assertions: Hamcrest;
  - *Note*: Can be seen in the `LoginPageStepDef`, `LoginParameterTest` and `LoginTest` classes
- [Optional] Loggers: SLF4J.
  - *Note*: SLF4J is linked to Log4j