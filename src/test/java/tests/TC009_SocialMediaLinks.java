package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Log;

public class TC009_SocialMediaLinks extends BaseTest {
	@Test
	public void verifySocialMediaXLink() {
		Log.info("TC009_SocialMediaLinks starts....");
		Log.info("TC009_SocialMediaLinks verify X link starts....");
		try {

			LoginPage lp = new LoginPage(driver);

			Log.info("Entering Valid Test Data");
			lp.login(ConfigReader.getProperty("valid_username"), ConfigReader.getProperty("valid_password"));

			Log.info("Navigating x social media link");
			InventoryPage ip = new InventoryPage(driver);
			ip.switchTabToX();
			
			Log.info("Validating expected x social media result");
			Assert.assertTrue(driver.getCurrentUrl().contains("x.com"));

			
			Log.info("Expected x social media page result is validated, test is sucessfull");
		} catch (Exception e) {
			Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void verifySocialMediaFacebookLink() {
			Log.info("TC009_SocialMediaLinks starts....");
			Log.info("TC009_SocialMediaLinks verify Facebook link starts....");
			try {

				LoginPage lp = new LoginPage(driver);

				Log.info("Entering Valid Test Data");
				lp.login(ConfigReader.getProperty("valid_username"), ConfigReader.getProperty("valid_password"));

				Log.info("Navigating facebook social media link");
				InventoryPage ip = new InventoryPage(driver);
				ip.switchTabToFacebook();
				
				Log.info("Validating expected facebook social media result");
				Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com"));

				
				Log.info("Expected facebook social media page result is validated, test is sucessfull");
			} catch (Exception e) {
				Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
				Assert.fail(e.getMessage());
			}
		}
} 