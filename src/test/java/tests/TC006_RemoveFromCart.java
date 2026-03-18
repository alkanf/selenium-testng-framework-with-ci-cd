package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Log;

public class TC006_RemoveFromCart extends BaseTest {
	@Test
	public void verifyRemovingProductFromCartInInventoryPage() {
		Log.info("TC006_RemoveFromCart starts....");
		Log.info("TC006_RemoveFromCart in Inventory Page starts....");
		try {
			
		LoginPage lp = new LoginPage(driver); 
		
		Log.info("Entering Valid Test Data");
		lp.typeUsername(ConfigReader.getProperty("valid_username"));
		lp.typePassword(ConfigReader.getProperty("valid_password"));
		lp.clickLogin();
		
		Log.info("Clicking Add To Cart");
		SoftAssert sa = new SoftAssert(); 
		InventoryPage ip = new InventoryPage(driver);
		String addToCartVerify = ip.verifyAddToCart();
		sa.assertTrue(addToCartVerify.equalsIgnoreCase("Add to cart"));
		ip.clickAddToCart();

		
		Log.info("Validating Add to Cart number"); //Using soft assert as there is two assertions
		String cartNumberVerify = ip.verifyAddToCartNumber();
		System.out.println(cartNumberVerify);
		sa.assertEquals(cartNumberVerify, "1");
		
		Log.info("Validating Remove in Inventory Page and clicking it"); //Using soft assert as there is two assertions
		String removeCartVerify = ip.verifyRemoveCart();
		sa.assertTrue(removeCartVerify.equalsIgnoreCase("Remove"));
		ip.ClickRemoveCart();

		
		sa.assertAll();

		
		Log.info("Expected remove from cart in inventory page function result is validated, test is sucessfull");
		}
		catch(Exception e) {
			Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
			Assert.assertTrue(false);

		}
	}
	@Test
	public void verifyRemovingProductFromCartInCartPage() {
		Log.info("TC006_RemoveFromCart starts....");
		Log.info("TC006_RemoveFromCart in Cart Page starts....");
		try {
			
		LoginPage lp = new LoginPage(driver); 
		
		Log.info("Entering Valid Test Data");
		lp.typeUsername(ConfigReader.getProperty("valid_username"));
		lp.typePassword(ConfigReader.getProperty("valid_password"));
		lp.clickLogin();
		
		Log.info("Clicking Add To Cart");
		SoftAssert sa = new SoftAssert(); 
		InventoryPage ip = new InventoryPage(driver);
		String addToCartVerify = ip.verifyAddToCart();
		sa.assertTrue(addToCartVerify.equalsIgnoreCase("Add to cart"));
		ip.clickAddToCart();

		
		Log.info("Validating Add to Cart number"); //Using soft assert as there is two assertions
		String cartNumberVerify = ip.verifyAddToCartNumber();
		System.out.println(cartNumberVerify);
		sa.assertEquals(cartNumberVerify, "1");
		
		Log.info("Validating Remove in Cart Page and clicking it"); //Using soft assert as there is two assertions
		CartPage ce = new CartPage(driver);
		ce.clickCartPage();
		ce.clickRemoveCart();
		
		
		
		
		
		sa.assertAll();
	
		
		Log.info("Expected remove from cart in cart page function result is validated, test is sucessfull");
		}
		catch(Exception e) {
			Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
			Assert.assertTrue(false);

		}
	
	

} 
}
