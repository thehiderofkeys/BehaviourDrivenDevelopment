Feature: Unenroll from a course

  Scenario Outline: Unenrolling from a course when the user is enrolled into at least one course
    Given I am logged in as: <Username> on the main page to unenroll
    Given I am enrolled in <CurrentEnrolments>
    When I press the 'unenroll' button next to a listed <SpecificCourse> and I click Save
    Then The list of enrolled courses should be updated to <ExpectedEnrolments>

    Examples:
    |Username   | SpecificCourse| CurrentEnrolments      | ExpectedEnrolments|
    |'rightUsrN'| 'SOFTENG754'  | 'SOFTENG754'           | ''                |
    |'user123'   | 'SOFTENG701'  | 'SOFTENG754,SOFTENG701'| 'SOFTENG754'      |

