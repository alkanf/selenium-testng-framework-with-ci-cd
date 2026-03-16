package utilities;

import java.util.Locale;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Report will be saved in
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
            Locale.setDefault(Locale.US); //as i am getting Turkish keyboard error
            
            // Report Setting
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Sauce Demo TestNG Framework");
            sparkReporter.config().setReportName("Test Results");
            sparkReporter.config().setEncoding("utf-8");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            
            // Additional Informations
            extent.setSystemInfo("Automation Engineer", "Furkan");
            extent.setSystemInfo("Project", "Sauce Demo Framework");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            
            String browser = ConfigReader.getProperty("browser");
            extent.setSystemInfo("Browser", ConfigReader.getProperty(browser));
            }
        return extent;
    }
}