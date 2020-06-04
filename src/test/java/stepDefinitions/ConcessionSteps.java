package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MainPage;

import static org.junit.Assert.assertEquals;

public class ConcessionSteps {

    MainPage mainPage = new MainPage(Hooks.driver);
    // ------------------------ SCENARIO STEPS -------------------------

    @Given("I press the 'apply for concession' button for {string}")
    public void i_press_the_apply_for_concession_button_for_course(String courseName){
        mainPage.pressApplyForConcessionButton(courseName);
    }

    @Given("I enter my {string} into the text box for {string}")
    public void i_enter_my_reason_into_the_text_box(String reason,String courseName){
        mainPage.enterReason(reason, courseName);
        assertEquals(reason, mainPage.getReasonTextBoxText(courseName));
    }

    @Then("I can see a {string} stating the reason for my concession for {string}")
    public void i_can_see_a_concession_text_stating_the_reason_for_my_concession(String concessionText, String courseName) {
        mainPage.expandDetailsOfConcession(courseName);
        assertEquals(concessionText, mainPage.getConcessionText(courseName));
    }

    @Then("I can see an alert saying {string}")
    public void i_can_see_an_alert_saying(String alertMessage){
        assertEquals(alertMessage,mainPage.getAlertMessage());
    }

}
