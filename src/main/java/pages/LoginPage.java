package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

public class LoginPage {
    @FindBy(xpath = "//input[@id='UserName']")
    public static WebElement usernameField;

    @FindBy(xpath = "//input[@id='Password']")
    public static WebElement passwordField;

    @FindBy(xpath = "//div[@class='col-xs-6 m-t-xs']")
    public static WebElement rememberField;

    @FindBy(xpath = "//button[@id='btnLogin']")
    public static WebElement sign_inField;

    @FindBy(xpath = "//a[@class='btn btn-block btn-facebook btn-flat text-center']")
    public static WebElement forgot_passwordField;

    @FindBy(xpath = "//div[@id='toast-container']")
    public static WebElement warning_messageField;

    @FindBy(xpath = "//span[@for='UserName']")
    public static WebElement email_warning_messageField;

    @FindBy(xpath = "//span[@for='Password']")
    public static WebElement password_warning_messageField;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        Helper.setDriver(driver);
    }

    public void loginToApplication(String Email, String Password) {
        Helper.sendText(usernameField, Email);
        Helper.sendText(passwordField, Password);
        Helper.elementClick(rememberField);
        Helper.elementClick(sign_inField);
    }

    public void loginToApplicationUsingKeyboard(String Email, String Password) {
        Helper.sendText(usernameField, Email);
        Helper.usingKeyTab();
        Helper.sendText(passwordField, Password);
        Helper.usingKeyTab();
        Helper.elementClick(rememberField);
        Helper.usingKeyTab();
        Helper.usingKeyEnter();
    }

    public void loginToApplicationWithoutClickingRemember(String Email, String Password) {
        Helper.sendText(usernameField, Email);
        Helper.sendText(passwordField, Password);
        Helper.elementClick(sign_inField);
    }

    public boolean warningMessage() {
        Helper.waitForElement(warning_messageField);
        return Helper.elementToBeDisplayed(warning_messageField);
    }

    public boolean emailWarning() {
        Helper.waitForElement(email_warning_messageField);
        return Helper.elementToBeDisplayed(email_warning_messageField);
    }

    public boolean passwordWarning() {
        Helper.waitForElement(password_warning_messageField);
        return Helper.elementToBeDisplayed(password_warning_messageField);
    }

    public void forgetPassword() {
        Helper.elementClick(forgot_passwordField);
    }

    public String usernamePlaceholder() {
        return Helper.getAttributePlaceholder(usernameField);
    }

    public String passwordPlaceholder() {
        return Helper.getAttributePlaceholder(passwordField);
    }

    public boolean visibleSignIn(){
        Helper.waitForElement(sign_inField);
        return Helper.elementToBeDisplayed(sign_inField);
    }
}
