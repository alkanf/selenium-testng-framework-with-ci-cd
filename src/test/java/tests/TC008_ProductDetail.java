package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.ConfigReader;
import utilities.Log;

public class TC008_ProductDetail extends BaseTest {
	
	@Test
	public void verifyProductDetail() {
		Log.info("TC008_ProductDetail starts....");
		try {
			

		LoginPage lp = new LoginPage(driver); 
		
		Log.info("Entering Valid Test Data");
		lp.login(ConfigReader.getProperty("valid_username"), ConfigReader.getProperty("valid_password"));
		
		Log.info("Product name and price in inventory page");
		InventoryPage ip = new InventoryPage(driver);
		String productPriceInInventoryPage = ip.verifyFirstProductPrice();
		String productNameInInventoryPage = ip.verifyFirstProductName();
		
		Log.info("Navigating first product page");
		ip.clickFirstProduct();
		ProductPage pp = new ProductPage(driver);
		String productNameInProductPage = pp.verifyProductName();
		String productPriceInProductPage = pp.verifyProductPrice();

		Log.info("Validating expected product page result");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(productNameInProductPage, productNameInInventoryPage);
		sa.assertEquals(productPriceInProductPage, productPriceInInventoryPage);
		
		sa.assertAll();

		
		Log.info("Expected product page result is validated, test is sucessfull");
		}
		catch(Exception e) {
			Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
			Assert.fail(e.getMessage());

		}
	}


}
