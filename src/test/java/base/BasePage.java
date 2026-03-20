package base;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
protected WebDriver driver;
protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
//These are valid also for driver.findelement
//POM Methods, Click, SendKeys, isDisplayed, waitVisibility
protected void click(By locator) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
}
protected void sendKeys(By locator, String text) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
}
protected boolean isDisplayed(By locator) {
    try {
        
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    } catch (Exception e) {
        // This is must otherwise test would fail
        return false;
    }
}
public WebElement waitVisibility(By locator) {
    return new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
}
protected String getText(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
}

//Switch tab methods
public void switchToNewWindow() {
    String mainWindow = driver.getWindowHandle();
    Set<String> allWindows = driver.getWindowHandles();

    for (String window : allWindows) {
        if (!window.equals(mainWindow)) {
            driver.switchTo().window(window);
            break;
        }
    }
}
public void switchToMainWindow(String mainWindowHandle) {
    driver.switchTo().window(mainWindowHandle);
}
	
}
