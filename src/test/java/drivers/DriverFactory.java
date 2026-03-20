package drivers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
//Thread for each test case has driver,
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//Driver start -> BaseTest, WebDriverManager is usefull for CICD and different machines,  will be used in before annotation
	public static void initDriver(String browser) {

		boolean isRemote = Boolean.parseBoolean(System.getProperty("remote")); //remote will be given from maven, ci/cd

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		    // For pop up and extensions
		    ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        options.addArguments("--disable-save-password-bubble");
	        //Change password notification exception handle
	        Map<String, Object> chromePrefs = new HashMap<>();
	        chromePrefs.put("credentials_enable_service", false);
	        chromePrefs.put("profile.password_manager_enabled", false);
	        chromePrefs.put("profile.password_manager_leak_detection", false);
	        // Add preff to options
	        options.setExperimentalOption("prefs", chromePrefs);

	        if (isRemote) {
	        	options.addArguments("--headless=new");
	        	options.addArguments("--no-sandbox");
	        	options.addArguments("--disable-dev-shm-usage");
	        	options.addArguments("--disable-gpu");
	        	options.addArguments("--window-size=1920,1080");
	        }

		    driver.set(new ChromeDriver(options));

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();

			EdgeOptions options = new EdgeOptions();

			if (isRemote) {
				options.addArguments("--headless=new");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1920,1080");
			}

			driver.set(new EdgeDriver(options));

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();

			if (isRemote) {
				options.addArguments("-headless");
				options.addArguments("--width=1920");
				options.addArguments("--height=1080");
			}

		    driver.set(new FirefoxDriver(options));

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