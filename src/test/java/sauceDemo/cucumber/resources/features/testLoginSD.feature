Feature: Login into sauce demo website

  Scenario: User login using valid credentials
    Given User launch the website
    And User input registered username
    And User input valid password
    When User click login button
    Then Screen redirected to main page

  Scenario: User login using invalid credentials
    Given User launch the website
    And User input registered username
    And User input wrong password
    When User click login button
    Then Error message showed up
