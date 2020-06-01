Feature: Unenroll from a course

  Background:
    Given I am on the main page
    Given I am logged in as "user123"

  Scenario Outline: Unenrolling from a course when the user is enrolled into at least one course,
    and the time is within the acceptable start and end date for unenrolments

    When I press the 'unenroll' button next to a listed <SpecificCourse>
    Then I can see my <CurrentEnrolments> without the <SpecificCourse>, as <ExpectedEnrolments>

    Examples:
    | SpecificCourse      | CurrentEnrolments                               | ExpectedEnrolments    |
    | SOFTENG701          | SOFTENG701                                      |                       |
    | SOFTENG701          | SOFTENG701,SOFTENG702                           | SOFTENG702                   |
    | SOFTENG702          | SOFTENG701,SOFTENG702,SOFTENG703                | SOFTENG701,SOFTENG703              |
    | SOFTENG702          | SOFTENG701,SOFTENG702,SOFTENG703,SOFTENG704     | SOFTENG701,SOFTENG703,SOFTENG704  |

  Scenario Outline: Unenrolling from a course when the user is NOT enrolled in
    When I press the 'unenroll' button next to a listed <SpecificCourse>
    Then I can see my <CurrentEnrolments> as before, and see an <ErrorMessage>

    Examples:
      | SpecificCourse      | CurrentEnrolments        | ErrorMessage       |
      | SOFTENG702          | SOFTENG701               | InvalidCourseError |

