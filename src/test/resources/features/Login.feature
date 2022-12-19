Feature: Zero Bank Test
  @efe
  Scenario: go to web site and verify
    Given The user should be on the page
    When The user click Sign in button
    And The user should input "username" and "password"
    Then The User should go to another page
    And get the title of the page and verify
    And User should be able to see account options
    |Cash Accounts|
    |Investment Accounts|
    |Credit Accounts|
    |Loan Accounts|

