Feature: Reasoning for Rejected Enrollment

  Background:
    Given user123 has completed SOFTENG 401,SOFTENG 402
    And rightUsr has completed no courses
    And COMPSYS 726 is closed for enrollment

  Scenario Outline: Enroll into a course when prerequisites are met and is within enrolment opening
  and closing times

    Given I am logged in as: <User> on the main page to enroll
    And I enter a <CourseName> into the search bar
    And I press the 'search' button
    When I press the 'enroll' button for <CourseName> and press the 'save' button
    Then <CourseName> should not be in the list of courses I failed to enroll in

    Examples:
      | User       | CourseName          |
      | 'rightUsrN'| 'SOFTENG 701'       |
      | 'user123'  | 'SOFTENG 702'       |

  Scenario Outline: Enroll into a course when prerequisites are NOT met

    Given I am logged in as: <User> on the main page to enroll
    And I enter a <CourseName> into the search bar
    And I press the 'search' button
    And I press the 'enroll' button for <CourseName> and press the 'save' button
    When I click on the expansion button next to the course I failed to enroll in, <CourseName>
    Then An error message: <ErrorMessage> is displayed for the course <CourseName>

    Examples:
      | User       | CourseName          | ErrorMessage         |
      | 'rightUsrN'| 'SOFTENG 702'       | '• Prerequisites not met'          |

  Scenario Outline: Enroll into a course that is closed.

    Given I am logged in as: <User> on the main page to enroll
    And I enter a <CourseName> into the search bar
    And I press the 'search' button
    And I press the 'enroll' button for <CourseName> and press the 'save' button
    When I click on the expansion button next to the course I failed to enroll in, <CourseName>
    Then An error message: <ErrorMessage> is displayed for the course <CourseName>

    Examples:
      | User      | CourseName          | ErrorMessage         |
      | 'user123' | 'COMPSYS 726'       | '• Closed'             |

  Scenario Outline: Enroll into two courses that clash

    Given I am logged in as: <User> on the main page to enroll
    And I enter a <FirstCourseName> into the search bar
    And I press the 'search' button
    And I press the 'enroll' button for <FirstCourseName>
    And I enter a <SecondCourseName> into the search bar
    And I press the 'search' button
    And I press the 'enroll' button for <SecondCourseName> and press the 'save' button
    When I click on the expansion button next to the courses I failed to enroll in, <FirstCourseName>,<SecondCourseName>
    Then An error message: <ErrorMessage> is displayed for the course <FirstCourseName>
    Then An error message: <ErrorMessage> is displayed for the course <SecondCourseName>

    Examples:
      | User       | FirstCourseName     | SecondCourseName    | ErrorMessage         |
      | 'rightUsrN'| 'SOFTENG 701'       | 'SOFTENG 703'       | '• Clash'             |