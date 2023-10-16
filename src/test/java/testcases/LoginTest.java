package testcases;


import base.Base;
import browserfactory.Browser;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ForgetPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ConfigReader;

import java.util.Properties;


public class LoginTest extends Base {
    static LoginPage loginpage;
    static HomePage homepage;
    static ForgetPasswordPage forgetPasswordPage;
    static Properties prop = new ConfigReader().intializeProperties();

    @BeforeMethod
    public static void init() {
        loginpage = PageFactory.initElements(Browser.getDriver(), LoginPage.class);
        homepage = PageFactory.initElements(Browser.getDriver(), HomePage.class);
        forgetPasswordPage = PageFactory.initElements(Browser.getDriver(), ForgetPasswordPage.class);
    }

    @Test(priority = 1)
    public void verifyLogInWithValidCredentials() {
        loginpage.loginToApplication(prop.getProperty("email"), prop.getProperty("password"));
        Assert.assertTrue(homepage.logoutVisible());
    }

    @Test(priority = 2)
    public void verifyLogInWithInValidCredentials() {
        loginpage.loginToApplication(prop.getProperty("invalidEmail"), prop.getProperty("invalidPassword"));
        Assert.assertTrue(loginpage.warningMessage());
    }

    @Test(priority = 3)
    public void verifyLogInWithInValidEmail() {
        loginpage.loginToApplication(prop.getProperty("invalidEmail"), prop.getProperty("password"));
        Assert.assertTrue(loginpage.warningMessage());
    }

    @Test(priority = 4)
    public void verifyLogInWithInValidPassword() {
        loginpage.loginToApplication(prop.getProperty("email"), prop.getProperty("invalidPassword"));
        Assert.assertTrue(loginpage.warningMessage());
    }

    @Test(priority = 5)
    public void verifyLogInWithoutValidCredentials() {
        loginpage.loginToApplication("", "");
        Assert.assertTrue(loginpage.emailWarning());
        Assert.assertTrue(loginpage.passwordWarning());
    }

    @Test(priority = 6)
    public void verifyForgetPasswordPage() {
        loginpage.forgetPassword();
        Assert.assertTrue(forgetPasswordPage.visiblePasswordContainer());
    }

    @Test(priority = 7)
    public void verifyLogInWithValidCredentialsUsingKeyboard() {
        loginpage.loginToApplicationUsingKeyboard(prop.getProperty("email"), prop.getProperty("password"));
        Assert.assertTrue(homepage.logoutVisible());
    }

    @Test(priority = 8)
    public void verifyPlaceholder() {
        Assert.assertEquals("Email or Mobile No", loginpage.usernamePlaceholder());
        Assert.assertEquals("Password", loginpage.passwordPlaceholder());
    }

    @Test(priority = 9)
    public void verifyLogInWithValidCredentialsWithoutClickingRemember() {
        loginpage.loginToApplicationWithoutClickingRemember(prop.getProperty("email"), prop.getProperty("password"));
        Assert.assertTrue(homepage.logoutVisible());
    }
}

