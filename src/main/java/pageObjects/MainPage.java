package pageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using="username")
    private WebElement usernameElement;

    @FindBy(how = How.ID, using="showCurrentEnrolmentsButton")
    private WebElement showCurrentEnrolmentsButtonElement;

    @FindBy(how = How.NAME, using="currentEnrolledCourse")
    private List<WebElement> currentEnrolmentElementsList;

    public void click_show_current_enrolments_button(){
        showCurrentEnrolmentsButtonElement.click();
    }

    public void logIn(String username){
        usernameElement.sendKeys(username);
    }

    public String getUsername(){
        return usernameElement.getAttribute("value");
    }

    public List<String> getCurrentEnrolmentsList(){
        List<String> currentEnrolmentsList = new ArrayList();
        for (WebElement currentEnrolledCourseElement : currentEnrolmentElementsList){
            currentEnrolmentsList.add(currentEnrolledCourseElement.getAttribute("value"));
        }
        return currentEnrolmentsList;
    }
}
