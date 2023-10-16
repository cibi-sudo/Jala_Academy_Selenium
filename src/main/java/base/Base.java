package base;

import browserfactory.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utility.ConfigReader;

import java.util.Properties;

public class Base {
    public WebDriver driver;

    @BeforeMethod
    public void browserSetup(){
        Properties prop = new ConfigReader().intializeProperties();
        driver = Browser.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }
    @AfterMethod
    public void browserclose(){
        driver.quit();
    }
}
