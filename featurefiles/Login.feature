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
@Login_Logout
Feature: Login and Logout feature
  I want to use this template for Login and Logout

  @Login
  Scenario Outline: Login Into Application with Valid Data
    Then I see the Login Page
    When I enter valid data "<username>","<password>" and click sign-in
    Then I should see the username
    When I click on logout
  Examples:
    | username | password |
    | djf      | sdjgn    |

