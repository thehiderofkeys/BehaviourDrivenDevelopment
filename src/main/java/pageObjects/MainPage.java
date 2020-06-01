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

    @FindBy(how = How.ID, using="currentEnrolledCourse")
    private List<WebElement> currentEnrolmentElementsList;

    @FindBy(how = How.ID, using="errorMessage")
    private WebElement errorMessageElement;

    @FindBy(how = How.ID, using="unenrollButton")
    private List<WebElement> unenrollButtonList;

    @FindBy(how = How.ID, using="saveButton")
    private WebElement saveButton;


    public List<String> getCurrentEnrolmentsList(){
        List<String> currentEnrolmentsList = new ArrayList();
        for (WebElement currentEnrolledCourseElement : currentEnrolmentElementsList){
            currentEnrolmentsList.add(currentEnrolledCourseElement.getText());
        }
        return currentEnrolmentsList;
    }

    public void pressAnUnenrollButton(String specifiedCourse){
        for (WebElement buttonElement : unenrollButtonList){
            if (buttonElement.getAttribute("courseName").equals(specifiedCourse)){
                buttonElement.click();
                return;
            }
        }
    }

    public void pressSaveButton(){
       saveButton.click();
    }

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }
}
