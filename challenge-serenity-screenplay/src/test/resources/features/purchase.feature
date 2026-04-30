@purchase
Feature: Purchase flow on SauceDemo

  Background:
    Given the user is on the SauceDemo login page

  Scenario Outline: Successful product purchase with two items
    When the user logs in with username <username> and password <password>
    And the user adds <quantity> products to the cart
    And the user navigates to the cart
    Then the cart should contain <expectedCount> items
    When the user completes checkout with first name <firstName>, last name <lastName> and zip <zip>
    Then the user should see the confirmation message <expectedMessage>
    Examples:
      | username        | password       | quantity | expectedCount | firstName | lastName | zip     | expectedMessage            |
      | "standard_user" | "secret_sauce" | 2        | 2             | "Test"    | "User"   | "12345" | "THANK YOU FOR YOUR ORDER" |