Feature: Login Functionality

  I want to test the login feature of the saucedemo webpage

  Background:
    Given I am on the saucedemo login page

  Scenario: Login with empty credentials
    Given I have entered a empty username and password
    When I click the login button
    Then I should get an error message Username is required

  Scenario: Login with Username and no password
    Given I have entered a valid username and an empty password
    When I click the login button
    Then I should get an error message Password is required

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click the login button
    Then I should be logged correctly