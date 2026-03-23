package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.DataProviders;
import utilities.Log;

public class TC011_DataDrivenLogin extends BaseTest {
@Test(dataProvider = "validLoginData", dataProviderClass = DataProviders.class, priority = 1) //as its in different package.
public void verifySuccessfullLogin(String username, String password) {// Dont forget to pass parametres as we are taking data but variable its not important
	Log.info("TC011_DataDrivenLogin starts....");
	Log.info("TC011_DataDrivenLogin validLogin starts....");

	try {
		
    
	LoginPage lp = new LoginPage(driver); 
	
	Log.info("Entering Valid Test Data");
	lp.login(username, password);
	
	Log.info("Validating expected products page result");
	InventoryPage ip = new InventoryPage(driver);
	boolean isProductsPageDisplayed = ip.actualResult();
	Assert.assertTrue(isProductsPageDisplayed);
	
	Log.info("Expected products page result is validated, test is sucessfull");
	}
	catch(Exception e) {
		Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
		Assert.fail(e.getMessage());

	}
}

@Test(dataProvider = "invalidLoginData", dataProviderClass = DataProviders.class, priority = 2) //as its in different package.
public void verifyInvalidLogin(String invalidUsername, String invalidPassword) {
	Log.info("TC011_DataDrivenLogin starts....");
	Log.info("TC011_DataDrivenLogin invalidLogin starts....");

	try {
		

	LoginPage lp = new LoginPage(driver); 
		
	Log.info("Entering Invalid Test Data");
	lp.login(invalidUsername, invalidPassword);
	
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
