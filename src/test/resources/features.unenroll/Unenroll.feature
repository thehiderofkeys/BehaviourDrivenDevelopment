Feature: Unenroll from a course

  Background:
    Given I am on the main page
    Given I am logged in as: <Username>

  Scenario Outline: Unenrolling from a course when the user is enrolled into at least one course,
    and the time is within the acceptable start and end date for unenrolments

    When I press the 'unenroll' button next to a listed <SpecificCourse>
    Then I can see my <CurrentEnrolments> without the <SpecificCourse>, as <ExpectedEnrolments>

    Examples:
    | Username    | SpecificCourse      | CurrentEnrolments                               | ExpectedEnrolments    |
    | user123     | SOFTENG701          | SOFTENG701                                      |                       |
    | user123     | SOFTENG701          | SOFTENG701,SOFTENG702                           | SOFTENG702                   |
    | user123     | SOFTENG702          | SOFTENG701,SOFTENG702,SOFTENG703                | SOFTENG701,SOFTENG703              |
    | user123     | SOFTENG702          | SOFTENG701,SOFTENG702,SOFTENG703,SOFTENG704     | SOFTENG701,SOFTENG703,SOFTENG704  |

  Scenario Outline: Unenrolling from a course when the user is enrolled into at least one course,
  and the time is NOT within the acceptable start and end date for unenrolments

    When I press the 'unenroll' button next to a listed <SpecificCourse>
    Then I can see my <CurrentEnrolments> as before, and see an <ErrorMessage>

    Examples:
      | Username    | SpecificCourse      | CurrentEnrolments        | ErrorMessage     |
      | user123     | SOFTENG701          | SOFTENG701               | InvalidTimeError |

  Scenario Outline: Unenrolling from a course when the user is NOT enrolled in
    When I press the 'unenroll' button next to a listed <SpecificCourse>
    Then I can see my <CurrentEnrolments> as before, and see an <ErrorMessage>

    Examples:
      | Username    | SpecificCourse      | CurrentEnrolments        | ErrorMessage       |
      | user123     | SOFTENG702          | SOFTENG701               | InvalidCourseError |

