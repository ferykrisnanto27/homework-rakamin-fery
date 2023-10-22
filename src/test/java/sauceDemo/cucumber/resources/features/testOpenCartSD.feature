Feature: User can open cart page to checkout

  Scenario: User open cart page by clicking cart icon
    Given User open the website
    And User login with registered username and password
    When User click cart button
    Then User redirected to cart page
