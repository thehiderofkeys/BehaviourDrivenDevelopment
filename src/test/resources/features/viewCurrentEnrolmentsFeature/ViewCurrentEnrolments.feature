Feature: Viewing current enrolments

  Scenario Outline: User requesting, then seeing current enrolments

    Given I am on the login page
    Given I am logged in as: <Username> on the main page
    Then I can see my <CurrentEnrolments>

    Examples:
    | Username      | CurrentEnrolments                    |
    | 'rightUsrN'     | 'SOFTENG 701'                      |
    | 'user123'     | 'SOFTENG 701,SOFTENG 754'            |