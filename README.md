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
- Provide parallel execution, add logging for tests and use Data Provider to parametrize tests. Make sure that all tasks are supported by these 3 conditions: UC-1; UC-2; UC-3.

Please, add task description as README.md into your solution!

To perform the task use the various of additional options:
- Test Automation tool: Selenium WebDriver;
- Project Builder: Maven;
- Browsers: 1) Firefox; 2) Edge;
  - *Note*: I also included support for Chrome if it can't finde Firefox or Edge
- Locators: XPath;
- Test Runner: JUnit;
  - *Note*: Since it needs parallel execution and JUnit only does unit tests, I'm using TestNG that allows parallel execution
- [Optional] Patterns: 1) Singleton; 2) Adapter; 3) Strategy;
  - *Note*: The *Singleton* pattern is implemented in the DriverManager class
- [Optional] Test automation approach: BDD;
  - *Note*: To do this, I'm using Cucumber for the tests
- Assertions: Hamcrest;
  - *Note*: Can be seen in the LoginPageStepDef class
- [Optional] Loggers: SLF4J.