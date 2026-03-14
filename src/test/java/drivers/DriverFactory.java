package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
//Thread for each test case has driver,
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//Driver start -> BaseTest, WebDriverManager is usefull for CICD and different machines,  will be used in before annotation
	public static void initDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		    driver.set(new FirefoxDriver());
		} else {
			throw new RuntimeException("Unsupported browser " + browser);
		}
		WebDriver webDriver = getDriver(); // You can use getDriver directly but you will be calling driver 3 times.
        //No implicit wait as we add explicit wait in BasePage
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
	}

//Will be used in POM Pages
	public static WebDriver getDriver() {
		return driver.get();
		

	}

//Will be used in after annotation
	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
