Feature: Negative Login Test

  Scenario Outline:
    Given The user should be on the page
    When The user click Sign in button
    And The user input "<login>" and "<password>"
    And The user click Sign in button after login
    Then Then The warning message contains "<message>"

    Examples:
      | login | password | message |
      | username| passSSSword | Login and/or password are wrong. |
      | useEEEErname| password | Login and/or password are wrong. |




