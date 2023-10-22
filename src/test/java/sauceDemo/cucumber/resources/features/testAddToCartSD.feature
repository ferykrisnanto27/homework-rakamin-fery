Feature: User add product to cart

  Scenario: User click add to cart button
    Given User login with valid credentials
    And User redirected in the main page
    When User click add to cart button
    Then The cart badge popped up icon number

