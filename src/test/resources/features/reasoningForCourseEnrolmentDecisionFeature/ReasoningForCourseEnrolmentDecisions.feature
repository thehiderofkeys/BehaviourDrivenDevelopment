Feature: Get a message to tell the user of any problem with their enrolment

  Background:
    Given user123 has completed SOFTENG 401,SOFTENG 402
    And rightUsr has completed no courses
    And COMPSYS 726 is closed for enrollment

  Scenario Outline: Enroll into a course when prerequisites are met and is within enrolment opening
  and closing times

    Given I am logged in as: <User> on the main page to enroll
    And I enter a <CourseName> into the search bar
    And I press the 'search' button
    And I press the 'enroll' button for <CourseName>
    And I press the 'save' button
    When I press the 'update enrolments' button
    Then a <ErrorMessage> is displayed

    Examples:
      | User       | CourseName          | ErrorMessage     |
      | 'rightUsrN'| 'SOFTENG 701'       | 'Enrolled successfully'         |
      | 'user123'  | 'SOFTENG 702'       | 'Enrolled successfully'         |

  Scenario Outline: Enroll into a course when prerequisites are NOT met

    Given I am logged in as: <User> on the main page to enroll
    And I enter a <CourseName> into the search bar
    And I press the 'search' button
    And I press the 'enroll' button for <CourseName>
    And I press the 'save' button
    When I press the 'update enrolments' button
    Then a <ErrorMessage> is displayed

    Examples:
      | User       | CourseName          | ErrorMessage         |
      | 'rightUsrN'| 'SOFTENG 702'       | 'Failed to enroll. Course prerequisites not met'          |

  Scenario Outline: Enroll into a course when time is NOT within enrolment opening
  and closing times

    Given I am logged in as: <User> on the main page to enroll
    And I enter a <CourseName> into the search bar
    And I press the 'search' button
    And I press the 'enroll' button for <CourseName>
    And I press the 'save' button
    When I press the 'update enrolments' button
    Then a <ErrorMessage> is displayed

    Examples:
      | User      | CourseName          | ErrorMessage         |
      | 'user123' | 'COMPSYS 726'       | 'Failed to enroll. Current time is not within the enrolment period for this course.'          |