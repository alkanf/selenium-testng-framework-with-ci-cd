package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	private final By btn_Sort = By.xpath("//select[@class='product_sort_container']");
	private final By ele_prices = By.xpath("//div[@data-test='inventory-item-price']");
	private final By btn_AddToCart = By.xpath("(//button[text()='Add to cart'])[1]"); //index path as product can change
	private final By icon_AddToCartNumber = By.xpath("//span[@class='shopping_cart_badge']");
	private final By btn_RemoveCart = By.xpath("(//button[text()='Remove'])[1]");
	private final By btn_CartPage = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

	//3) Methods actions
	public boolean actualResult() {
		return isDisplayed(txt_Products);
	}
	public void clickHamburger() {
	click(btn_Hamburger);
	}
	public void clickLogout() {
	waitVisibility(btn_Logout).click();
	}
	public void clickSortLowToHighSelect() { //Create Select class and pass webelement
	WebElement dropdown = driver.findElement(btn_Sort);
	Select select = new Select(dropdown);
	select.selectByVisibleText("Price (low to high)");
	}
	public List<Double> returnProductPrices() {
	    // 1. Find all prices
	    List<WebElement> priceElements = driver.findElements(ele_prices);
	    // 2. For storing double prices
	    List<Double> doublePrices = new ArrayList<>();
	    // 3. Take all elements and converts to number
	    for (WebElement element : priceElements) {
	        // "$7.99" -> "7.99" -> 7.99 (Double)
	        String priceText = element.getText().replace("$", "").trim();
	        doublePrices.add(Double.parseDouble(priceText));
	    }
	    // 4. Return prices
	    return doublePrices;
	}
	public void clickSortHighToLowSelect() { //Create Select class and pass webelement
		WebElement dropdown = driver.findElement(btn_Sort);
		Select select = new Select(dropdown);
		select.selectByVisibleText("Price (high to low)");
		}
	public void clickAddToCart() {
	click(btn_AddToCart);
	}
	public String verifyAddToCart() {
	return driver.findElement(btn_AddToCart).getText();
	}
	public String verifyAddToCartNumber() {
	return driver.findElement(icon_AddToCartNumber).getText();
	}
	public String verifyRemoveCart() {
	return driver.findElement(btn_RemoveCart).getText();
	}
	public void ClickRemoveCart() {
	click(btn_RemoveCart);
	}
	public void clickCartPage() {
		waitVisibility(btn_CartPage).click();
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

