package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MainPage;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MainPage;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class ViewReasoningForCourseEnrolmentDecisionsSteps {
    MainPage mainPage = new MainPage(Hooks.driver);

    // ------------------ EMPTY STEPS FOR READABILITY ------------------
    // @Given("user123 has completed SOFTENG 401,SOFTENG 402")
    //      Defined in EnrollSteps.java

    // @Given("rightUsr has completed no courses")
    //      Defined in EnrollSteps.java

    // @Given("COMPSYS 726 is closed for enrollment")
    //      Defined in EnrollSteps.java

    // ------------------------ SCENARIO STEPS -------------------------

    //@Given("I am logged in as: {string} on the main page to enroll")
    //      Defined in EnrollSteps.java

    //@Given("I enter a {string} into the search bar")
    //      Defined in EnrollSteps.java

    //Given("I press the 'search' button")
    //      Defined in EnrollSteps.java

    //@When("I press the 'enroll' button for {string} and press the 'save' button")
    //      Defined in EnrollSteps.java

    @When("I click on the expansion button next to the course I failed to enroll in, {string}")
    public void i_click_on_the_expansion_button_next_to_failed_course(String courseName){
        mainPage.expandDetailsOfFailedCourse(courseName);
    }

    @Then("{string} should not be in the list of courses I failed to enroll in")
    public void course_should_not_be_in_the_list_of_courses_i_failed_to_enroll_in(String courseName){
        assertFalse(mainPage.didFailToEnrollInCourse(courseName));
    }

    @Then("An error message: {string} is displayed for the course {string}")
    public void a_error_message_reason_is_displayed_for_the_course(String errorMessageReason,String courseName){
        assertEquals("Could not enroll, Reason:",mainPage.getErrorMessage(courseName));
        assertEquals(errorMessageReason,mainPage.getErrorMessageReason(courseName));
    }
}
