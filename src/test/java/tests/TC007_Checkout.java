package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Log;

public class TC007_Checkout extends BaseTest {
	@Test
	public void verifyCheckoutPage() {
		Log.info("TC007_Checkout starts....");
		try {
			
		LoginPage lp = new LoginPage(driver); 
		
		Log.info("Entering Valid Test Data");
		lp.login(ConfigReader.getProperty("valid_username"), ConfigReader.getProperty("valid_password"));
		
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
		
		Log.info("Navigating Cart Page"); //Using soft assert as there is two assertions
		ip.clickCartPage();
		
		Log.info("Navigating Checkout Page");
		CartPage ce = new CartPage(driver);
		ce.clickCheckoutPage();
		
		Log.info("Typing Checkout informations");
		CheckoutPage ca = new CheckoutPage(driver);
		ca.typeFirstName(ConfigReader.getProperty("username"));
		ca.typeLastName(ConfigReader.getProperty("lastname"));
		ca.typePostalCode(ConfigReader.getProperty("zip"));
		ca.clickContinue();
		
		Log.info("Navigating continue");
		String cartQuantityInCheckout = ca.verifyCartQuantity();
		sa.assertEquals(cartQuantityInCheckout, cartNumberVerify);
		ca.clickFinish();
		
		Log.info("Navigating finish");
		boolean verifyCheckout = ca.verifyCheckout();
		sa.assertTrue(verifyCheckout);
		
		sa.assertAll();
	
		
		Log.info("Expected checkout function result is validated, test is sucessfull");
		}
		catch(Exception e) {
			Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
			Assert.fail(e.getMessage());

		}
	
	

} 
}
