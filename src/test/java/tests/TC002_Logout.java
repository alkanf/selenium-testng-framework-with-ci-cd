package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Log;

public class TC002_Logout extends BaseTest{
	@Test
	public void verifySuccessfullLogout() {
		Log.info("TC002_Logouts starts....");
		try {
			LoginPage lp = new LoginPage(driver); 
			
			Log.info("Entering Valid Test Data");
			lp.login(ConfigReader.getProperty("valid_username"), ConfigReader.getProperty("valid_password"));
			
			Log.info("Validating logout");
			InventoryPage ip = new InventoryPage(driver);
			ip.clickHamburger(); ip.clickLogout();
			boolean isLoginPageDisplayed = lp.actualResult();
			Assert.assertTrue(isLoginPageDisplayed);
			
			Log.info(" Expected logout page result is validated, test is sucessfull");
			}
			catch(Exception e) {
				Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
				Assert.fail(e.getMessage());

		}

} } 
