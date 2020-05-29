package stepDefinitions;

import cucumber.api.java.en.Given;

public class retrieveEnrolmentsSteps {
    @Given ("I am on the main page")
    public void i_am_on_the_main_page(){
        //driver.get("localhost:3000");

        //check we're on the web page (might just be localhost for our testing)
        String url = driver.getCurrentUrl;
    }

}
