package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Log;

public class TC001_Login extends BaseTest {
	
	
@Test
public void verifySuccessfullLogin() {
	Log.info("TC001_Login starts....");
	try {
		

	LoginPage lp = new LoginPage(driver); 
	
	Log.info("Entering Valid Test Data");
	lp.typeUsername(ConfigReader.getProperty("valid_username"));
	lp.typePassword(ConfigReader.getProperty("valid_password"));
	lp.clickLogin();
	
	Log.info("Validating expected products page result");
	InventoryPage ip = new InventoryPage(driver);
	boolean isProductsPageDisplayed = ip.actualResult();
	Assert.assertTrue(isProductsPageDisplayed);
	
	Log.info("Expected products page result is validated, test is sucessfull");
	}
	catch(Exception e) {
		Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
		Assert.assertTrue(false);

	}
}

}
