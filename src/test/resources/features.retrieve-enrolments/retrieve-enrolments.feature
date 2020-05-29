Feature: Retrieve current enrolments for a user

  Scenario Outline: User requests current enrolments

    Given I am on the login page
    And I enter a <Username>
    And I enter a <Password>
    And I press the login button
    When I press the "see enrolled courses" button
    Then My <Enrolled courses> are displayed

    Examples:
      | Username        | Password          | Enrolled courses                |
      | user001         | password1         | 701                             |
      | user002         | password2         | 701, 702                        |
