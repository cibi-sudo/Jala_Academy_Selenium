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
import utility.ConfigFailedCase;
import utility.ConfigReader;

import java.util.Properties;

public class CreateEmployeePageTest extends Base {
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
        homepage.clickEmployee();
        homepage.clickCreateOnEmployee();
    }

    @Test()
    public void verifyFirstNameMaxLength() {
        Assert.assertEquals("20", createEmployeePage.firstNameMaxLength());
    }

    @Test()
    public void verifyFirstNamePlaceholder() {
        Assert.assertEquals("First Name", createEmployeePage.firstNamePlaceholder());
    }

    @Test()
    public void verifyLastNameMaxLength() {
        Assert.assertEquals("20", createEmployeePage.lastNameMaxLength());
    }

    @Test()
    public void verifyLastNamePlaceholder() {
        Assert.assertEquals("Last Name", createEmployeePage.lastNamePlaceholder());
    }

    @Test()
    public void verifyEmailWarningMessage() {
        Assert.assertEquals("Please enter valid email address", createEmployeePage.emailWarningMessage(prop.getProperty("invalidEmail")));
    }

    @Test()
    public void verifyMobileNumberMaxLength() {
        Assert.assertEquals("10", createEmployeePage.mobileNumberMaxLength());
    }

    @Test()
    public void verifyMobileNumberPlaceholder() {
        Assert.assertEquals("Mobile No", createEmployeePage.mobileNumberPlaceholder());
    }

    @Test()
    public void verifyMaleRadioSelected() {
        Assert.assertTrue(createEmployeePage.maleRadioSelected());
    }

    @Test()
    public void verifyFemaleRadioSelected() {
        Assert.assertFalse(createEmployeePage.femaleRadioSelected());
    }

    @Test()
    public void verifyFemaleRadioDeselected() {
        Assert.assertFalse(createEmployeePage.femaleRadioDeselected());
    }

    @Test()
    public void verifyMaleRadioDeselected() {
        Assert.assertFalse(createEmployeePage.maleRadioDeselected());
    }

    @Test()
    public void verifyCityDisabled() {
        Assert.assertFalse(createEmployeePage.cityDisabled());
    }

    @Test()
    public void verifyOtherCityPlaceholder() {
        Assert.assertEquals("City Name", createEmployeePage.otherCityPlaceholder());
    }

    @Test()
    public void verifySaveWithoutCredentials() {
        createEmployeePage.saveButton();
        Assert.assertTrue(createEmployeePage.saveButtonWarning());
        Assert.assertTrue(createEmployeePage.firstNameWarning());
        Assert.assertTrue(createEmployeePage.lastNameWarning());
        Assert.assertTrue(createEmployeePage.emailWarning());
        Assert.assertTrue(createEmployeePage.mobileNumberWarning());
    }

    @Test()
    public void verifySaveWithValidCredentials() {
        createEmployeePage.saveWithValidCredentials("Jane", "Doe",
                "jane.doe@example.com", "5555555555",
                "01/01/1990", "123 Main Street, Anytown, CA 91234",
                "USA", "California");
    }

    @Test(priority = 1, retryAnalyzer = ConfigFailedCase.class)
    public void verifySpellingOfSkills() {
        Assert.assertEquals("Skills", createEmployeePage.checkSpellSkills());
    }

    @Test()
    public void verifyMobileNumberWarningWhileLowCount() {
        Assert.assertEquals("Mobile No must be 10 digits.", createEmployeePage.mobileWarning(prop.getProperty("invalidMobileNumber")));
    }


}
