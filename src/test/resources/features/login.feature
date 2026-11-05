Feature: SauceDemo login

  Scenario: Successful login with valid demo credentials
    Given the user opens the SauceDemo login page
    When the user signs in with valid demo credentials
    Then the products page should be displayed
