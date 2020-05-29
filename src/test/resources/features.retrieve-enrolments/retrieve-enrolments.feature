Feature: Retrieve current enrolments for a user

  Scenario Outline: User requests current enrolments

    Given I am on the main page
    And I am logged in with a <Username>
    When I press the "see enrolled courses" button
    Then My <Enrolled courses> are displayed

    Examples:
      | Username        | Password          | Enrolled courses                |
      | user001         | password1         | 701                             |
      | user002         | password2         | 701, 702                        |
