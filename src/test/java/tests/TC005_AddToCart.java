package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Log;

public class TC005_AddToCart extends BaseTest {
	@Test
	public void verifyAddtoCart() {
		Log.info("TC005_AddToCart starts....");
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

		
		Log.info("Validating Add to Cart becomes Remove and Cart icon's number is increased"); //Using soft assert as there is two assertions
		String cartNumberVerify = ip.verifyAddToCartNumber();
		System.out.println(cartNumberVerify);
		sa.assertEquals(cartNumberVerify, "1");
		sa.assertAll();

		
		Log.info("Expected add to cart function result is validated, test is sucessfull");
		}
		catch(Exception e) {
			Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
			Assert.fail(e.getMessage());

		}
	}
	
	

}
