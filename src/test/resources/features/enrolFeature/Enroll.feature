Feature: Enroll into a course

  Background:
    Given user123 has completed SOFTENG 401,SOFTENG 402
    And rightUsr has completed no courses
    And COMPSYS 726 is closed for enrollment

  Scenario Outline: Enroll into a course when prerequisites are met and is within enrolment opening
    and closing times

    Given I am logged in as: <User> on the main page to enroll
    And I enter a <CourseName> into the search bar
    And I press the 'search' button
    When I press the 'enroll' button and press the 'save' button
    Then I am <EnrolmentStatus> in <CourseName>

    Examples:
    | User       | CourseName          | EnrolmentStatus     |
    | 'rightUsrN'| 'SOFTENG 701'       | 'Enrolled'          |
    | 'user123'  | 'SOFTENG 702'       | 'Enrolled'          |

  Scenario Outline: Enroll into a course when prerequisites are NOT met

    Given I am logged in as: <User> on the main page to enroll
    Given I enter a <CourseName> into the search bar
    And I press the 'search' button
    When I press the 'enroll' button and press the 'save' button
    Then I am <EnrolmentStatus> in <CourseName>

    Examples:
      | User       | CourseName          | EnrolmentStatus         |
      | 'rightUsrN'| 'SOFTENG 702'       | 'Not Enrolled'          |
      | 'rightUsrN'| 'SOFTENG 702'       | 'Not Enrolled'          |

  Scenario Outline: Enroll into a course when time is NOT within enrolment opening
  and closing times

    Given I am logged in as: <User> on the main page to enroll
    Given I enter a <CourseName> into the search bar
    And I press the 'search' button
    When I press the 'enroll' button and press the 'save' button
    Then I am <EnrolmentStatus> in <CourseName>

    Examples:
      | User      | CourseName          | EnrolmentStatus         |
      | 'user123' | 'COMPSYS 726'       | 'Not Enrolled'          |