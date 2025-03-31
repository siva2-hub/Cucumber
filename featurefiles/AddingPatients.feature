Feature: Adding Patients and Creating Tests
  Background:
    Given I am on the login page
    When I enter valid credentials
    Scenario: Verify that the user can add a new patient.
      When I go to Tests Tab
      And I click on Add Patient Test
      Then I Should see the Patient Contact details Form
      When I enter patient contact details
      And I click general details button
      Then I should see the General details forn
      When I fill general details from
      And I click on Add Test
      When I add test
      And I add equipment
      And I click on Add Patient