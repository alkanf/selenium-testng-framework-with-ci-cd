package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutPage extends BasePage {
//1 Constructor
public CheckoutPage (WebDriver driver) {
super(driver);
}
//Locators Step 1 Page
private final By txt_FirstName = By.xpath("//input[@id='first-name']");
private final By txt_LastName = By.xpath("//input[@id='last-name']");
private final By txt_PostalCode = By.xpath("//input[@id='postal-code']");
private final By txt_Continue = By.xpath("//input[@id='continue']");
//Methods Step 1 Page
public void typeFirstName(String username) {
sendKeys(txt_FirstName, username);
}
public void typeLastName(String lastname) {
sendKeys(txt_LastName, lastname);
}
public void typePostalCode(String postalcode) {
sendKeys(txt_PostalCode, postalcode);
}
public void clickContinue() {
click(txt_Continue);
}
//Locators Step 2 Page
private final By txt_CartQuantity = By.xpath("//div[@class='cart_quantity']");
private final By btn_Finish = By.xpath("//button[@id='finish']");
//Methods Step 2 Page
public String verifyCartQuantity() {
return waitVisibility(txt_CartQuantity).getText();
}
public void clickFinish() {
click(btn_Finish);
}
//Locators Step 3 Page
private final By txt_verifyCheckout = By.xpath("//h2[normalize-space()='Thank you for your order!']");
//Methods Step 3 Page
public String verifyCheckout() {
return waitVisibility(txt_verifyCheckout).getText();
}







}