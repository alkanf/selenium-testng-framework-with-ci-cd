package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CartPage extends BasePage {
//1) Constructor
	public CartPage(WebDriver driver) {
		super(driver);
	}
//2) Locators
private final By btn_CartPage = By.xpath("//a[@class='shopping_cart_link']");
private final By txt_CartQuantity = By.className("cart_quantity");
private final By btn_RemoveCart = By.xpath("//button[@id='remove-sauce-labs-backpack']");

//3) Methods / Actions
public void clickCartPage() {
waitVisibility(btn_CartPage).click();
}
public String verifyCartQuantity() {
return waitVisibility(txt_CartQuantity).getText();
}

public void clickRemoveCart() {
click(btn_RemoveCart);
}

}
