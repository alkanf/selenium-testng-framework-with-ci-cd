package utilities;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.DriverFactory;

public class TestListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        // Test başladığında raporda yer aç
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test is successfull.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("Test is failed: " + result.getThrowable());
        
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            // Screenshot location
            String imgPath = Screenshot.takeScreenshot(driver, result.getName());
            // Screenshot saved in extent report 
            test.get().addScreenCaptureFromPath("../" + imgPath); 
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        // Dont forget to save report
        extent.flush();
    }
}