package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MainPage;

import static org.junit.Assert.assertEquals;

public class ConcessionSteps {
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
        // ------------------------ SCENARIO STEPS -------------------------

        @Given("I am logged in as rightUsrN on the main page")
        public void i_am_logged_in_as_rightUsrN() {
            // check we're on a given web page
            assert(Hooks.driver.getCurrentUrl().equals("http://localhost:3000/"+"rightUserN"+"/main"));
        }

        @Given("I enter a {string} into the search bar")
        public void i_enter_a_course_name_into_the_search_bar(String courseName){
            assertEquals(courseName, mainPage.getSearchBarText());
        }

        @Given("I press the 'search' button")
        public void i_press_the_search_button() {

        }

        @Given("I press the 'apply for concession' button for <CourseName>")
        public void i_press_the_apply_for_concession_button_for_course(String courseName){

        }

        @Given("I enter my <Reason> into the text box")
        public void i_enter_my_reason_into_the_text_box(String reason){
            assertEquals(reason, mainPage.getReasonTextBoxText());
        }

        @Given("I press the 'submit concession' button")
        public void i_press_the_search_button() {
            mainPage.pressSubmitConcessionButton();
        }

        @Then("I can see a {string} stating my {string}")
        public void i_can_see_a_confirmation_message_stating_my_reason(String confirmationMessage, String reason){
            assertEquals(confirmationMessage, mainPage.getConfirmationMessage());
        }
    }

}
