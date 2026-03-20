package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class ProductPage extends BasePage {
//1) Constructor
public ProductPage(WebDriver driver) {
super(driver);
}
//2) Locators
private final By txt_ProductName = By.xpath("(//div[@data-test='inventory-item-name'])[1]");
private final By txt_ProductPrice = By.xpath("(//div[@data-test='inventory-item-price'])[1]");
//3) Methods 
public String verifyProductName() {
return getText(txt_ProductName);
}
public String verifyProductPrice() {
return getText(txt_ProductPrice);
}

}
