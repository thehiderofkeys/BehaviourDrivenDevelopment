Feature: Enroll into a course

  Background:
    Given I am on the main page
    And I am logged in as "user123"
    And I have completed courses "SOFTENG401,SOFTENG402"

  Scenario Outline: Enroll into a course when prerequisites are met and is within enrolment opening
    and closing times

    Given I enter a <CourseName> into the search bar
    And I press the 'search' button
    When I press the 'enroll' button
    Then I am <EnrolmentStatus> in the <CourseName>

    Examples:
    | CourseName       | EnrolmentStatus   |
    | SOFTENG701       | Enrolled          |
    | SOFTENG702       | Enrolled          |

  Scenario Outline: Enroll into a course when prerequisites are NOT met

    Given I enter a <CourseName> into the search bar
    And I press the 'search' button
    When I press the 'enroll' button
    Then I am <EnrolmentStatus> in the <CourseName>

    Examples:
      | CourseName       | EnrolmentStatus   |
      | SOFTENG710       | NotEnrolled       |
      | SOFTENG711       | NotEnrolled       |

  Scenario Outline: Enroll into a course when time is NOT within enrolment opening
  and closing times

    Given I enter a <CourseName> into the search bar
    And I press the 'search' button
    When I press the 'enroll' button
    Then I am <EnrolmentStatus> in the <CourseName>

    Examples:
      | CourseName       | EnrolmentStatus   |
      | SOFTENG701       | NotEnrolled       |
      | SOFTENG702       | NotEnrolled       |