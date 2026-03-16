package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class InventoryPage extends BasePage {
	//1) Constructor
	public InventoryPage(WebDriver driver) {
		super(driver);
	}
	//2) Locators
	private final By txt_Products = By.xpath("//span[@class='title']");
	private final By btn_Hamburger = By.xpath("//button[@id='react-burger-menu-btn']");
	private final By btn_Logout = By.xpath("//a[@id='logout_sidebar_link']");

	//3) Methods actions
	public boolean actualResult() {
		return isDisplayed(txt_Products);
	}
	public void clickHamburger() {
	click(btn_Hamburger);
	}
	public void clickLogout() {
	click(btn_Logout);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
