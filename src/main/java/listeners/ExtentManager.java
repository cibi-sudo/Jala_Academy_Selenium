package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utility.Helper;

public class ExtentManager {
    public static ExtentReports extent;
    public static ExtentReports getInstance(){
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    public static ExtentReports createInstance(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./Reports/Automation_"+ Helper.getCurrentTime()+".html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("sprint report");
        sparkReporter.config().setReportName("Automation report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        return extent;
    }
}
