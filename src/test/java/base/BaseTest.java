package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import drivers.DriverFactory;
import utilities.ConfigReader;


public class BaseTest {
protected WebDriver driver; //Class level as both method will access it
	
@BeforeMethod
public void setup() {
String browser = ConfigReader.getProperty("browser");
DriverFactory.initDriver(browser);
driver = DriverFactory.getDriver();
driver.get(ConfigReader.getProperty("baseUrl"));

}

@AfterMethod
public void tearDown() {
	if (driver != null) {
        DriverFactory.quitDriver();
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
