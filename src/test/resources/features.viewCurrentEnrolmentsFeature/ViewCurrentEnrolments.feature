Feature: Viewing current enrolments

  Scenario Outline: User requesting, then seeing current enrolments

    Given I am on the main page
    Given I am logged in as: <Username>
    When I press the 'show current enrolments' button
    Then I can see my <CurrentEnrolments>

    Examples:
    | Username      | CurrentEnrolments     |
    | user123       | 701                   |
    | user456       | 701, 702              |