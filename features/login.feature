Feature: Login
    # Given I am on the login page with the URL "http://staging-portal.iidm.com/dashboard"
  # Scenario Outline: Unsuccessful Case :Login
  #   When I enter my username as "<username>"
  #   And I enter my password as "<password>"
  #   And I click the login button
  #   Then I should see an error message "<error_message>"
  #   Examples:
  #     | username              | password        | error_message             |
  #     | invalid_user@test.com | InvalidPassword | Invalid Email or Password |
  #     |                       | InvalidPassword | Please Enter Email Id     |
  #     | invalid_user@test.com |                 | Please Enter Password     |
  # Scenario Outline: Empty Credentials :Login
  #   When I enter my username as "<username>"
  #   And I enter my password as "<password>"
  #   And I click the login button
  #   Then I should see an error message "<error_message1>", "<error_message2>"
  #   Examples:
  #     | username | password | error_message1        | error_message2        |
  #     |          |          | Please Enter Email Id | Please Enter Password |

  Scenario Outline: Successful :Login
    Given I am on the login page with the URL "http://staging-portal.iidm.com/dashboard"
    When I enter my username as "<username>"
    And I enter my password as "<password>"
    And I click the login button
    Then I should see a welcome message "<customerName>"
    Then I should be redirected to the dashboard
    When I log out
    Then I should be redirected to the login page

    Examples:
      | username              | password   | customerName |
      | multicam@testuser.com | Enter@4321 | MULTICAM INC |

  Scenario Outline: Successful :Credit Card Payment
    When I click on the Shop now button
    Then I should be redirected to the store home page
    When I search for a product with the name "<product_name>"
    And I go to the product page
    And I add the product to the cart
    And I proceed to checkout

    Examples:
      | product_name | phonenumber |
      |              |  1234567890 |
