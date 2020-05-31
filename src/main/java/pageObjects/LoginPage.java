package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.ID, using="username")
    private WebElement usernameElement;

    @FindBy(how= How.ID, using="password")
    private WebElement passwordElement;

    @FindBy(how= How.ID, using="loginButton")
    private WebElement loginButton;


    public void enterUsername(String username){
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getUsername(){
        return usernameElement.getText();
    }

    public String getPassword(){
        return passwordElement.getText();
    }





}
