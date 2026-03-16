package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {
//1) Constructor
public LoginPage(WebDriver driver) {
	super(driver);
}
//2) Locators
private final By txt_Username = By.xpath("//input[@id='user-name']");
private final By txt_Password = By.xpath("//input[@id='password']");
private final By btn_Login = By.xpath("//input[@id='login-button']");
private final By logo_Login = By.xpath("//div[@class='login_logo']");

//3) Methods actions
public void typeUsername(String username) {
sendKeys(txt_Username, username);
}
public void typePassword(String password) {
	sendKeys(txt_Password, password);
}
public void clickLogin() {
	click(btn_Login);
}
public boolean actualResult() {
	return waitVisibility(logo_Login).isDisplayed(); //waitVisibility method from basepage as it is executing fast and test would fail.
}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
