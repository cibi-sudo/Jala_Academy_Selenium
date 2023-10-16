package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

public class HomePage {
    @FindBy(xpath = "//li[@class='dropdown user user-menu']")
    public static WebElement logoutButton;

    @FindBy(xpath = "//li[@class='treeview'][1]")
    public static WebElement employeeField;

    @FindBy(xpath = "//a[normalize-space()='Create']")
    public static WebElement employee_CreateField;

    @FindBy(xpath = "//a[normalize-space()='Search']")
    public static WebElement employee_SearchField;
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        Helper.setDriver(driver);
    }

    public boolean logoutVisible() {
        Helper.waitForElement(logoutButton);
        return Helper.elementToBeDisplayed(logoutButton);
    }

    public void clickLogout(){
        Helper.elementClick(logoutButton);
    }

    public void clickEmployee(){
        Helper.waitForElement(employeeField);
        Helper.elementClick(employeeField);
    }

    public boolean visible_Create(){
        Helper.waitForElement(employee_CreateField);
        return Helper.elementToBeDisplayed(employee_CreateField);
    }

    public boolean visible_Search(){
        Helper.waitForElement(employee_SearchField);
        return Helper.elementToBeDisplayed(employee_SearchField);
    }

    public void clickCreateOnEmployee(){
        Helper.waitForElement(employeeField);
        Helper.elementClick(employeeField);
        Helper.waitForElement(employee_CreateField);
        Helper.elementClick(employee_CreateField);
    }

    public void clickSearchOnEmployee(){
        Helper.waitForElement(employeeField);
        Helper.elementClick(employeeField);
        Helper.waitForElement(employee_SearchField);
        Helper.elementClick(employee_SearchField);
    }
}
