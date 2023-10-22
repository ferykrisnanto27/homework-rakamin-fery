Feature: User click checkout button from cart page

  Scenario: User click checkout button with items added before
    Given User already in main page
    And User add items
    And User go to cart page
    And User check items
    When User click checkout button
    Then User redirected to fill information page

  Scenario: User click checkout button without items added before
    Given User already in main page
    And User go to cart page
    When User click checkout button
    Then Error message in checkout page showed up
