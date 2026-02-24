package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage login = new LoginPage(getDriver());
        getDriver().navigate().to("https://the-internet.herokuapp.com/login");
        login.enterUsername("tomsmith");
        login.enterPassword("SuperSecretPassword!");
        login.clickLogin();

        Assert.assertTrue(login.getSuccessMessage().contains("You logged into a secure area"));
    }

    @Test
    public void invalidLoginTest() {
        LoginPage login = new LoginPage(getDriver());
        getDriver().navigate().to("https://the-internet.herokuapp.com/login");
        login.enterUsername("wrong");
        login.enterPassword("wrong");
        login.clickLogin();

        Assert.assertTrue(login.getErrorMessage().contains("Your username is invalid"));
    }
}
