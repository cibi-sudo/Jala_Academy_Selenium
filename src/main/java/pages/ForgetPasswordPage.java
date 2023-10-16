package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

public class ForgetPasswordPage {
    WebDriver driver;

    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
        Helper.setDriver(driver);
    }

    @FindBy(xpath = "//div[@class='login-box-body']")
    public static WebElement forgetPasswordField;

    public boolean visiblePasswordContainer(){
        Helper.waitForElement(forgetPasswordField);
        return Helper.elementToBeDisplayed(forgetPasswordField);
    }
}
