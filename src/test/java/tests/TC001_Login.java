package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Log;
import pages.LoginPage;
import utilities.ConfigReader;

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
	boolean isProductsPageDisplayed = lp.actualResult();
	Assert.assertTrue(isProductsPageDisplayed);
	}
	catch(Exception e) {
		Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
		Assert.assertTrue(false);

	}
}

}
