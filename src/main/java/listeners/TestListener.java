package listeners;

import browserfactory.Browser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.Helper;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentManager.getInstance();
    ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        parentTest.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {
        parentTest.get().pass("Test passed");
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = Browser.getDriver();
        String base64 = Helper.captureScreenShotInBase64(driver);
        parentTest.get().fail("Test failed " + result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
    }

    public void onTestSkipped(ITestResult result) {
        WebDriver driver = Browser.getDriver();
        String base64 = Helper.captureScreenShotInBase64(driver);
        parentTest.get().skip("Test skipped " + result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
