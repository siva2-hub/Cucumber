Feature: Payments
  In order to make purchases
  As a customer
  I want to be able to pay using different methods

  Scenario Outline: Successful :Credit Card Payment
    When I click on the Shop now button
    Then I should be redirected to the store home page
    When I search for a product with the name "<product_name>"
    And I go to the product page "<product_name>"
    And I add the product to the cart
    And I proceed to checkout
    And I validate the customer details "<phonenumber>"
    And I validate the builling details
    And I validate the shipping details "<shippingMethod>", "<notesText>"
    And I verify the prices "<paymentMethod>"

    Examples:
      | product_name | phonenumber | shippingMethod | notesText                                              | paymentMethod |
      |      231-642 |  1234567890 | FEDX - Ground  | notes are added for credit card payment with Logged In | Credit Card   |
