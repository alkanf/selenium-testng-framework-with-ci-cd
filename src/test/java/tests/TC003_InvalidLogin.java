package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.Log;

public class TC003_InvalidLogin extends BaseTest {
	
	
@Test
public void verifyInvalidLogin() {
	Log.info("TC003_InvalidLogin starts....");
	try {
		

	LoginPage lp = new LoginPage(driver); 
		
	Log.info("Entering Invaalid Test Data");
	lp.login("invalid_username", "invalid_password");
	
	Log.info("Validating expected error result");
	boolean isErrorDisplayed = lp.invalidLogin();
	Assert.assertTrue(isErrorDisplayed);
	Log.info("Expected error result is validated, test is sucessfull");
	}
	catch(Exception e) {
		Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
		Assert.fail(e.getMessage());

	}
}

}
