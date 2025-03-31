Feature:
  Background:
  Given I am on the login page
  When I enter valid credentials
  Scenario: Verify that the user can select blood tests and calculate the cost.
    When I select the Blood test
    And I select the discount for blood test
    Then I should see the cost updates after applying discounts