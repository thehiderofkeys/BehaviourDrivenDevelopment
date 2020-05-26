Feature: Addition Calculator

  Scenario: Addition of two numbers
    Given I have entered 10 into the calculator
    And I have also entered 15 into the calculator
    When I press add
    Then The Result should be 25