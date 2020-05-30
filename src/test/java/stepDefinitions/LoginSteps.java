package stepDefinitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import static org.junit.Assert.assertThat;

public class LoginSteps {

    private final WebDriver driver = new FirefoxDriver();
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("localhost:3000");

        // check we're on a given web page
        String url = driver.getCurrentUrl();
        assert(url.equals("localhost:3000"));
    }
    @Given("I enter a username:{string}")
    public void i_enter_a_username(String username){
        // Automation needs to be implemented
        driver.findElement(By.id("username")).sendKeys(username);

        WebElement element = driver.findElement(By.id("username"));
        String userInput = element.getText();
        assert(userInput.equals(username));
    }

    @Given("I enter a password:{string}")
    public void i_enter_a_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);

        WebElement element = driver.findElement(By.id("password"));
        String userInput = element.getText();
        assert(userInput.equals(password));
    }

    @When("I press the login button")
    public void i_press_the_login_button(){
        driver.findElement(By.id("loginButton")).click();

        // no test needed
    }
    @Then("I will be {string}")
    public void i_will_be_logged_in(String loggedIn){
        // no automation needed

        // check for the resulting elements that arise from logging in
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        boolean testedLoggedIn = welcomeMessage.getText().equals("Welcome");
        assert(loggedIn.equals(Boolean.toString(testedLoggedIn)));

        System.out.println("You are now logged in");
    }


}
