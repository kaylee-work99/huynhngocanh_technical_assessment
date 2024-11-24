package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import actions.GlobalConstants;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.ROOT_FOLDER + "/extentV5/ExtentReport.html");
        reporter.config().setReportName("DemoQA HTML Report");
        reporter.config().setDocumentTitle("DemoQA HTML Report");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.DARK);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company", "HuynhNgocAnh");
        extentReports.setSystemInfo("Project", "HuynhNgocAnh");
        extentReports.setSystemInfo("Team", "HuynhNgocAnh");
        extentReports.setSystemInfo("JDK version", GlobalConstants.JAVA_VERSION);
        return extentReports;
    }
}
