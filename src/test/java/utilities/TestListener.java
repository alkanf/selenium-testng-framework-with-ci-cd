package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import drivers.DriverFactory;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Take driver from driverFactory
        org.openqa.selenium.WebDriver driver = DriverFactory.getDriver();
        
        // Call Screenshot
        if (driver != null) {
            Screenshot.takeScreenshot(driver, result.getName());
        }
    }
}