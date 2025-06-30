Feature: Login Functionality

  I want to test the login feature of the saucedemo webpage

  Scenario: Login with empty credentials
    Given I am on the saucedemo login page
    And I have entered a empty username and password
    When I click the login button
    Then I should get an error message Username is required

  Scenario: Login with Username and no password
    Given I am on the saucedemo login page
    And I have entered a valid username and an empty password
    When I click the login button
    Then I should get an error message Password is required

  Scenario: Successful login with valid credentials
    Given I am on the saucedemo login page
    And I have entered a valid username and password
    When I click the login button
    Then I should be logged correctly

  Scenario Outline: Check certain logins
    Given I am on the saucedemo login page
    And I have entered "<username>" and "<password>"
    When I click the login button
    Then I get the correct "<message>"

    Examples:
      | username                | password     | message                               |
      | standard_user           | secret_sauce | Correct login                         |
      | locked_out_user         | secret_sauce | Sorry, this user has been locked out. |
      | problem_user            | secret_sauce | Correct login                         |
      | performance_glitch_user | secret_sauce | Correct login                         |
      | error_user              | secret_sauce | Correct login                         |
      | visual_user             | secret_sauce | Correct login                         |