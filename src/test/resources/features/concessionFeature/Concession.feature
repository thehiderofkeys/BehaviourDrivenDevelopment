Feature: Concessions

  Background:
    Given I am logged in as: 'rightUsrN' on the main page to enroll
    And I enter a 'SOFTENG 702' into the search bar
    And I press the 'search' button
    And I press the 'enroll' button for 'SOFTENG 702' and press the 'save' button
    And I click on the expansion button next to the course I failed to enroll in, 'SOFTENG 702'

  Scenario Outline: Apply to enrol to a course via a concession, with a reason
    Given I enter my <Reason> into the text box for 'SOFTENG 702'
    When I press the 'apply for concession' button for 'SOFTENG 702'
    Then I can see a <ConcessionMessage> stating the reason for my concession for 'SOFTENG 702'

    Examples:
      | Reason                                | ConcessionMessage     |
      | 'I meet the SOFTENG 701 prerequisite' | 'Concession: I meet the SOFTENG 701 prerequisite'|
      | 'I just want to enrol'                | 'Concession: I just want to enrol'               |

  Scenario Outline: Apply to enrol to a course via a concession, WITHOUT a reason

    When I press the 'apply for concession' button for 'SOFTENG 702'
    Then I can see an alert saying <ErrorMessage>

    Examples:
      | ErrorMessage     |
      | 'Please give a reason for your concession.'     |
      | 'Please give a reason for your concession.'     |
