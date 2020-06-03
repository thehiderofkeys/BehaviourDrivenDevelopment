Feature: Apply to enrol to a course via a concession

  Background:
    Given I am logged in as rightUsrN on the main page
    And I enter a CourseName into the search bar
    And I press the search button

  Scenario Outline: Apply to enrol to a course via a concession, with a reason

    Given I press the 'apply for concession' button for <CourseName>
    And I enter my <Reason> into the text box
    When I press the 'submit concession' button
    Then I can see a <ConfirmationMessage> stating my <Reason>

    Examples:
      | Reason                                | CourseName          | ConfirmationMessage     |
      | 'I meet the SOFTENG 701 prerequisite' | 'SOFTENG 702'       | 'You have successfully applied for a concession with the reason: "I meet the SOFTENG 701 prerequisite"'     |
      | 'I just want to enrol'                | 'SOFTENG 702'       | 'You have successfully applied for a concession with the reason: "I just want to enrol"'          |

  Scenario Outline: Apply to enrol to a course via a concession, WITHOUT a reason

    Given I press the 'apply for concession' button for <CourseName>
    When I press the 'submit concession' button
    Then I can see a <ErrorMessage>

    Examples:
      | CourseName          | ErrorMessage     |
      | 'SOFTENG 702'       | Error: Concession reason must be given'     |
      | 'SOFTENG 703'       | Error: Concession reason must be given'     |
