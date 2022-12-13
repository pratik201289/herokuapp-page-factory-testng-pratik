package com.herokuapp.theinternet.pages;

import com.aventstack.extentreports.Status;
import com.herokuapp.theinternet.customlisteners.CustomListeners;
import com.herokuapp.theinternet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name="username")
    WebElement usernameField;
    @CacheLookup
    @FindBy(name="password")
    WebElement passwordFiled;
    @CacheLookup
    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement loginButton;
    //By loginButton =By.xpath("");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'example']/h2[contains(text(), 'Secure Area')]")
    WebElement loginSuccessfulMessage;
    @CacheLookup
    @FindBy(xpath = "//div[@class='flash error']")
    WebElement userNameErrorMessage;
    @CacheLookup
    @FindBy(xpath = "//div/div[@id='flash']")
    WebElement passwordErrorMessage;

    public void enterUserName(String username){
        Reporter.log("Enter Username:" +username+" on username field"+ usernameField.toString());
        sendTextToElement(usernameField,username);
        CustomListeners.test.log(Status.PASS, "Enter Username " + username);
    }
    public void enterPassword(String password) {

        Reporter.log("Enter Username:" +password+" on username field"+ usernameField.toString());
        sendTextToElement(passwordFiled,password);
        CustomListeners.test.log(Status.PASS, "Enter Username " + password);
    }
    public void clickOnLoginButton(){

        Reporter.log("Click on Login Button "+ loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }
    public String getLoginSuccessMessage(){
        Reporter.log("Getting Login Successful Message" +loginSuccessfulMessage.toString());
        String message = getTextFromElement(loginSuccessfulMessage);
        CustomListeners.test.log(Status.PASS, "Verify Login Success Message");
        return getTextFromElement(loginSuccessfulMessage);
    }
    public String getUserNameErrorMessage(){
        Reporter.log("Getting Username Error Message" +userNameErrorMessage.toString());
        CustomListeners.test.log(Status.FAIL, "Getting Username Error Message");
        return getTextFromElement(userNameErrorMessage);

    }
    public String getPasswordErrorMessage(){
        Reporter.log("Getting Password Error Message" +passwordErrorMessage.toString());
        CustomListeners.test.log(Status.FAIL, "Getting Password Error Message");
        return getTextFromElement(passwordErrorMessage);

    }


}
