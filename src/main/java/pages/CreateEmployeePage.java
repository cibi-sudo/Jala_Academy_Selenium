package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

public class CreateEmployeePage {
    @FindBy(xpath = "//h3[@class='box-title']")
    public static WebElement employeeDetails;
    @FindBy(xpath = "//input[@id='FirstName']")
    public static WebElement employeeFirstName;
    @FindBy(xpath = "//span[@for='FirstName']")
    public static WebElement employeeFirstName_Warning;
    @FindBy(xpath = "//input[@id='LastName']")
    public static WebElement employeeLastName;
    @FindBy(xpath = "//span[@for='LastName']")
    public static WebElement employeeLastName_Warning;
    @FindBy(xpath = "//input[@id='EmailId']")
    public static WebElement employeeEmail;
    @FindBy(xpath = "//span[@for='EmailId']")
    public static WebElement employeeEmail_Warning;
    @FindBy(xpath = "//input[@id='MobileNo']")
    public static WebElement employeeMobileNumber;
    @FindBy(xpath = "//span[@for='MobileNo']")
    public static WebElement employeeMobileNumber_Warning;
    @FindBy(xpath = "//input[@id='DOB']")
    public static WebElement employeeDateOfBirth;
    @FindBy(xpath = "//input[@id='rdbMale']")
    public static WebElement employeeButtonMale;
    @FindBy(xpath = "//input[@id='rdbFemale']")
    public static WebElement employeeButtonFemale;
    @FindBy(xpath = "//textarea[@id='Address']")
    public static WebElement employeeAddress;
    @FindBy(xpath = "//select[@id='CountryId']")
    public static WebElement employeeCountry;
    @FindBy(xpath = "//select[@id='CityId']")
    public static WebElement employeeCity;
    @FindBy(xpath = "//span[@class='checkmark']")
    public static WebElement employeeOtherCity_Checkbox;
    @FindBy(xpath = "//input[@id='OtherCity']")
    public static WebElement employeeOtherCity;
    @FindBy(xpath = "//div[@class='col-md-12 form-group m-t-lg']/h4")
    public static WebElement employeeSkills;
    @FindBy(xpath = "//input[@id='chkSkill_1']")
    public static WebElement employeeSkill_QA_Automation;
    @FindBy(xpath = "//input[@id='chkSkill_2']")
    public static WebElement employeeSkill_Full_Stack_Developer;
    @FindBy(xpath = "//input[@id='chkSkill_3']")
    public static WebElement employeeSkill_DevOps;
    @FindBy(xpath = "//input[@id='chkSkill_4']")
    public static WebElement employeeSkill_Middleware;
    @FindBy(xpath = "//input[@id='chkSkill_5']")
    public static WebElement employeeSkill_AWS;
    @FindBy(xpath = "//input[@id='chkSkill_6']")
    public static WebElement employeeSkill_WebServices;
    @FindBy(xpath = "//div[@class='box-footer text-right']//button")
    public static WebElement employeeSaveButton;
    @FindBy(xpath = "//div[@id='toast-container']")
    public static WebElement employeeSaveButton_Warning;
    @FindBy(xpath = "//div[@class='box-footer text-right']//a")
    public static WebElement employeeCancelButton;
    WebDriver driver;

    public CreateEmployeePage(WebDriver driver) {
        this.driver = driver;
        Helper.setDriver(driver);
    }

    public boolean visibleEmployeeDetails() {
        Helper.waitForElement(employeeDetails);
        return Helper.elementToBeDisplayed(employeeDetails);
    }

    public String firstNameMaxLength() {
        Helper.waitForElement(employeeFirstName);
        return Helper.getAttributeMaxLength(employeeFirstName);
    }

    public String firstNamePlaceholder() {
        Helper.waitForElement(employeeFirstName);
        return Helper.getAttributePlaceholder(employeeFirstName);
    }

    public String lastNameMaxLength() {
        Helper.waitForElement(employeeFirstName);
        return Helper.getAttributeMaxLength(employeeFirstName);
    }

    public String lastNamePlaceholder() {
        Helper.waitForElement(employeeLastName);
        return Helper.getAttributePlaceholder(employeeLastName);
    }

    public String emailWarningMessage(String email) {
        Helper.sendText(employeeEmail, email);
        Helper.elementClick(employeeSaveButton);
        Helper.waitForElement(employeeEmail_Warning);
        return Helper.getElementText(employeeEmail_Warning);
    }

    public String mobileNumberMaxLength() {
        Helper.waitForElement(employeeMobileNumber);
        return Helper.getAttributeMaxLength(employeeMobileNumber);
    }

    public String mobileNumberPlaceholder() {
        Helper.waitForElement(employeeMobileNumber);
        return Helper.getAttributePlaceholder(employeeMobileNumber);
    }

    public boolean maleRadioSelected() {
        return Helper.elementSelected(employeeButtonMale);
    }

    public boolean femaleRadioSelected() {
        return Helper.elementSelected(employeeButtonFemale);
    }

    public boolean femaleRadioDeselected() {
        Helper.elementClick(employeeButtonMale);
        return Helper.elementSelected(employeeButtonFemale);
    }

    public boolean maleRadioDeselected() {
        Helper.elementClick(employeeButtonFemale);
        return Helper.elementSelected(employeeButtonMale);
    }

    public boolean cityDisabled() {
        Helper.elementClick(employeeOtherCity_Checkbox);
        return Helper.elementEnabled(employeeCity);
    }

    public String otherCityPlaceholder() {
        Helper.elementClick(employeeOtherCity_Checkbox);
        Helper.waitForElement(employeeOtherCity);
        return Helper.getAttributePlaceholder(employeeOtherCity);
    }

    public void saveButton() {
        Helper.elementClick(employeeSaveButton);
    }

    public boolean saveButtonWarning() {
        Helper.waitForElement(employeeSaveButton_Warning);
        return Helper.elementToBeDisplayed(employeeSaveButton_Warning);
    }

    public boolean firstNameWarning() {
        Helper.waitForElement(employeeFirstName_Warning);
        return Helper.elementToBeDisplayed(employeeFirstName_Warning);
    }

    public boolean lastNameWarning() {
        Helper.waitForElement(employeeLastName_Warning);
        return Helper.elementToBeDisplayed(employeeLastName_Warning);
    }

    public boolean emailWarning() {
        Helper.waitForElement(employeeEmail_Warning);
        return Helper.elementToBeDisplayed(employeeEmail_Warning);
    }

    public boolean mobileNumberWarning() {
        Helper.waitForElement(employeeMobileNumber_Warning);
        return Helper.elementToBeDisplayed(employeeMobileNumber_Warning);
    }

    public boolean saveWithValidCredentials(String firstName, String lastName, String email, String mobileNumber, String dob, String address, String country, String city) {
        Helper.sendText(employeeFirstName, firstName);
        Helper.sendText(employeeLastName, lastName);
        Helper.sendText(employeeEmail, email);
        Helper.sendText(employeeMobileNumber, mobileNumber);
        Helper.sendText(employeeDateOfBirth, dob);
        Helper.elementClick(employeeButtonFemale);
        Helper.sendText(employeeAddress, address);
        Helper.selectDropDown(employeeCountry, country);
        Helper.selectDropDown(employeeCity, city);
        Helper.elementClick(employeeSkill_QA_Automation);
        Helper.elementClick(employeeSkill_Full_Stack_Developer);
        Helper.elementClick(employeeSaveButton);
        Helper.waitForElement(employeeSaveButton_Warning);
        return Helper.elementToBeDisplayed(employeeSaveButton_Warning);
    }

    public String checkSpellSkills() {
        return Helper.getElementText(employeeSkills);
    }

    public String mobileWarning(String mobileNumber) {
        Helper.sendText(employeeMobileNumber, mobileNumber);
        Helper.elementClick(employeeSaveButton);
        return Helper.getElementText(employeeMobileNumber_Warning);
    }
}
