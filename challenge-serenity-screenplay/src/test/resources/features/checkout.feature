Feature: Checkout flow on SauceDemo

  Background:
    Given the user is on the SauceDemo login page

  Scenario Outline: Checkout fails when required fields are empty
    When the user logs in with username <username> and password <password>
    And the user adds <quantity> products to the cart
    And the user navigates to the cart
    When the user attempts checkout with first name <firstName>, last name <lastName> and zip <zip>
    Then the user should see the error message <expectedError>
    Examples:
      | username        | password       | quantity | firstName | lastName | zip     | expectedError                        |
      | "standard_user" | "secret_sauce" | 1        | ""        | ""       | ""      | "Error: First Name is required"      |
      | "standard_user" | "secret_sauce" | 1        | "Test"    | ""       | ""      | "Error: Last Name is required"       |
      | "standard_user" | "secret_sauce" | 1        | "Test"    | "User"   | ""      | "Error: Postal Code is required"     |