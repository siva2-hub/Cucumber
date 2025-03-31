#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Login functionality of the Pathology Lab Management app

  Background:
    Given I am on the login page
  Scenario: Verify that the login page loads correctly with username and password fields.
    Then I should see the username and password fields

  Scenario: Verify that the login page displays an error with incorrect credentials.
    When I enter inValid credentials
    Then I should see the error validations

  Scenario: Verify that the login functionality works with valid credentials.
    When I enter valid credentials
    Then I should be redirected to the home page

