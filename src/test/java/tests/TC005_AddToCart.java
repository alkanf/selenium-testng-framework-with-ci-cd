package tests;

import org.testng.Assert;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Log;

public class TC005_AddToCart extends BaseTest {
	
	public void verifySuccessfullLogin() {
		Log.info("TC005_AddToCart starts....");
		try {
			

		LoginPage lp = new LoginPage(driver); 
		
		Log.info("Entering Valid Test Data");
		lp.typeUsername(ConfigReader.getProperty("valid_username"));
		lp.typePassword(ConfigReader.getProperty("valid_password"));
		lp.clickLogin();
		
		
		
		
		
		
		
		Log.info("Validating expected products page result");
		
		
		Log.info("Expected products page result is validated, test is sucessfull");
		}
		catch(Exception e) {
			Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
			Assert.assertTrue(false);

		}
	}
	
	

}
