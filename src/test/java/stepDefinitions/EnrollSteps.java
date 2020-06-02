package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MainPage;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EnrollSteps {
    MainPage mainPage = new MainPage(Hooks.driver);

    // ------------------ EMPTY STEPS FOR READABILITY ------------------
    @Given("user123 has completed SOFTENG 401,SOFTENG 402")
    public void user123_has_completed_SOFTENG_401_and_SOFTENG_402() {}

    @Given("rightUsr has completed no courses")
    public void rightUsr_has_completed_no_courses() {}

    @Given("COMPSYS 726 is closed for enrollment")
    public void SOFTENG_754_is_closed_for_enrollment() {}

    // ------------------------ SCENARIO STEPS -------------------------

    @Given("I am logged in as: {string} on the main page to enroll")
    public void i_am_logged_in_on_the_main_page(String username) {
        Hooks.driver.get("http://localhost:3000/"+username+"/main");

        // check we're on a given web page
        assert(Hooks.driver.getCurrentUrl().equals("http://localhost:3000/"+username+"/main"));
    }

    @Given("I enter a {string} into the search bar")
    public void i_enter_a_course_name_into_the_search_bar(String courseName){
        mainPage.enterCourseName(courseName);
        assertEquals(courseName, mainPage.getSearchBarText());
    }

    @Given("I press the 'search' button")
    public void i_press_the_search_button() {
        mainPage.pressSearchButton();
    }

    @When("I press the 'enroll' button for {string} and press the 'save' button")
    public void i_press_the_enroll_button(String courseName){
        mainPage.pressAnEnrollButton(courseName);
        mainPage.pressSaveButton();
    }

    @Then("I am {string} in {string}")
    public void i_am_enrolled_in_the_course(String enrolmentStatus, String courseName){
        assertEquals(enrolmentStatus, mainPage.getEnrolmentStatus(courseName));
    }
}
