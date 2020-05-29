package stepDefinitions;

import cucumber.api.java.en.Given;

public class retrieveEnrolmentsSteps {
    @Given (I am on the login page
    And I enter a <Username>
    And I enter a <Password>
    And I press the login button
    When I press the "see enrolled courses" button
    Then My <Enrolled courses> are displayed
}
