package browserfactory;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import utility.ConfigReader;
import utility.Helper;

import java.time.Duration;
import java.util.Properties;

import static java.time.Duration.*;

public class Browser {
    @Getter
    static WebDriver driver;
    static Properties prop = new ConfigReader().intializeProperties();

    public static WebDriver initializeBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions opt=new ChromeOptions();
            if(prop.getProperty("headless").contains("true"))
            {
                opt.addArguments("--headless");
            }
            driver=new ChromeDriver(opt);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions opt=new FirefoxOptions();
            if(prop.getProperty("headless").contains("true"))
            {
                opt.addArguments("--headless");
            }
            driver=new FirefoxDriver(opt);
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions opt=new EdgeOptions();
            if(prop.getProperty("headless").contains("true"))
            {
                opt.addArguments("--headless");
            }
            driver=new EdgeDriver(opt);
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(Helper.pageloadouttime));
        driver.manage().timeouts().implicitlyWait(ofSeconds(Helper.implicittime));
        return driver;
    }

}
