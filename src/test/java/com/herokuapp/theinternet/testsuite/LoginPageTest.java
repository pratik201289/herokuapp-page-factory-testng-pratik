package com.herokuapp.theinternet.testsuite;

import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity","regerssion"})
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getLoginSuccessMessage(), "Secure Area", "Secure Area text is not displayed");

    }

    @Test(groups = {"smoke","regerssion"})
    public void verifyTheUsernameErrorMessage() {

        loginPage.enterUserName("tomsmith2");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        //System.out.println(loginPage.getUserNameErrorMessage());
        Assert.assertEquals(loginPage.getUserNameErrorMessage().replace("×", ""), "Your username is invalid!\n", " User Error Message not displayed");

    }

    @Test(groups = "regression")
    public void verifyThePasswordErrorMessage() {

        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        //System.out.println(loginPage.getUserNameErrorMessage());
        Assert.assertEquals(loginPage.getPasswordErrorMessage().replace("×", ""), "Your password is invalid!\n", " Password Error Message not displayed");


    }
}
