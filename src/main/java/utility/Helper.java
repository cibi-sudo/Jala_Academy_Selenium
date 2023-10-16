package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Helper {
    public static int pageloadouttime = 20;
    public static int implicittime = 10;
    public static int explicittime = 5;
    static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        Helper.driver = driver;
    }

    public static String captureScreenShotInBase64(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64;
        base64 = ts.getScreenshotAs(OutputType.BASE64);
        return base64;
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
    }

    public static boolean elementToBeDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static void elementClick(WebElement element) {
        element.click();
    }

    public static void sendText(WebElement element, String string) {
        element.click();
        element.clear();
        element.sendKeys(string);
    }

    public static void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicittime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void usingKeyTab() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
    }

    public static void usingKeyEnter() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
    }

    public static String getAttributePlaceholder(WebElement element) {
        return element.getAttribute("placeholder");
    }

    public static String getAttributeMaxLength(WebElement element) {
        return element.getAttribute("maxlength");
    }

    public static boolean elementSelected(WebElement element) {
        return element.isSelected();
    }

    public static boolean elementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public static String getElementText(WebElement element) {
        return element.getText();
    }

    public static void selectDropDown(WebElement element, String string) {
        Select select = new Select(element);
        select.selectByVisibleText(string);
    }
}
