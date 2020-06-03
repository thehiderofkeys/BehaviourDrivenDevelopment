Feature: Apply to enrol to a course via a concession

  Background:
    Given I am logged in as rightUsrN on the main page
    And I enter a 'SOFTENG 702' into the search bar
    And I press the 'search' button
    And I press the 'enroll' button for 'SOFTENG 702' and press the 'save' button

  Scenario Outline: Apply to enrol to a course via a concession, with a reason

    Given I enter my <Reason> into the text box for 'SOFTENG 702'
    Given I press the 'apply for concession' button for 'SOFTENG 702'
    When I press the 'submit concession' button
    Then I can see a <ConcessionMessage> stating my <Reason>

    Examples:
      | Reason                                | ConcessionMessage     |
      | 'I meet the SOFTENG 701 prerequisite' | 'Concession: I meet the SOFTENG 701 prerequisite'|
      | 'I just want to enrol'                | 'Concession: I just want to enrol'               |

  Scenario Outline: Apply to enrol to a course via a concession, WITHOUT a reason

    Given I press the 'apply for concession' button for <CourseName>
    When I press the 'submit concession' button
    Then I can see a <ErrorMessage>

    Examples:
      | CourseName          | ErrorMessage     |
      | 'SOFTENG 702'       | 'Please give a reason for your concession.'     |
      | 'SOFTENG 703'       | 'Please give a reason for your concession.'     |
