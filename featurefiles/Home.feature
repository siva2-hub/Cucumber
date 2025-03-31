Feature: Home Page
  Background:
    Given I am on the login page
    When I enter valid credentials
  Scenario: Verify that the home page loads successfully after login.
    Then I should be redirected to the home page
   Scenario: Verify that the user can view the list of todos on the home page.
     Then I should see the list of todos
   Scenario: Verify that the user can access the Cost Calculator.
     Then I should see the cost calculator