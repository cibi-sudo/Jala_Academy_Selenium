package testcases;

import base.Base;
import browserfactory.Browser;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateEmployeePage;
import pages.HomePage;
import pages.LoginPage;
import utility.ConfigReader;

import java.util.Properties;

public class HomePageTest extends Base {
    static LoginPage loginpage;
    static HomePage homepage;
    static CreateEmployeePage createEmployeePage;
    static Properties prop = new ConfigReader().intializeProperties();

    @BeforeMethod
    public static void init() {
        loginpage = PageFactory.initElements(Browser.getDriver(), LoginPage.class);
        homepage = PageFactory.initElements(Browser.getDriver(), HomePage.class);
        createEmployeePage = PageFactory.initElements(Browser.getDriver(), CreateEmployeePage.class);
        loginpage.loginToApplication(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test()
    public void verifyClickLogout() {
        homepage.clickLogout();
        Assert.assertTrue(loginpage.visibleSignIn());
    }

    @Test()
    public void verifyClickEmployee() {
        homepage.clickEmployee();
        Assert.assertTrue(homepage.visible_Create());
        Assert.assertTrue(homepage.visible_Search());
    }

    @Test()
    public void verifyClickEmployeeCreate() {
        homepage.clickEmployee();
        homepage.clickCreateOnEmployee();
        Assert.assertTrue(createEmployeePage.visibleEmployeeDetails());
    }
}
