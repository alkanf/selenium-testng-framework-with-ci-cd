package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Log;

public class TC004_ProductSort extends BaseTest { //2 Test
	
	
@Test
public void verifyLowToHighSortingProducts() {
	Log.info("TC004_ProductSort starts....");
	Log.info("TC004_ProductSort low to high sorting starts....");
	try {
		

	LoginPage lp = new LoginPage(driver); 
	
	Log.info("Entering Valid Test Data");

	lp.typeUsername(ConfigReader.getProperty("valid_username"));
	lp.typePassword(ConfigReader.getProperty("valid_password"));
	lp.clickLogin();
	
	Log.info("Click sorting and selecting low to high");
	InventoryPage ip = new InventoryPage(driver);
	ip.clickSortLowToHighSelect();

	Log.info("Validating product prices sorted low to high");
	List<Double> prices = ip.returnProductPrices(); //Get all prices
	for(int i =0;i<prices.size()-1;i++) { //last number wont be compared
	double currentPrice = prices.get(i);
	double nextPrice = prices.get(i+1);
	Assert.assertTrue(currentPrice <= nextPrice);
	} 
	
	Log.info("Expected low to high sorting is validated, test is sucessfull");
	}
	catch(Exception e) {
		Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
		Assert.assertTrue(false);

	}
}
@Test
public void verifyHighToLowSortingProducts() {
	Log.info("TC004_ProductSort starts....");
	Log.info("TC004_ProductSort high to low sorting starts....");

	try {
		

	LoginPage lp = new LoginPage(driver); 
	
	Log.info("Entering Valid Test Data");

	lp.typeUsername(ConfigReader.getProperty("valid_username"));
	lp.typePassword(ConfigReader.getProperty("valid_password"));
	lp.clickLogin();
	
	Log.info("Click sorting and selecting high to low");
	InventoryPage ip = new InventoryPage(driver);
	ip.clickSortHighToLowSelect();

	Log.info("Validating product prices sorted high to low");
	List<Double> prices = ip.returnProductPrices(); //Get all prices
	for(int i =0;i<prices.size()-1;i++) { //last number wont be compared
	double currentPrice = prices.get(i);
	double nextPrice = prices.get(i+1);
	Assert.assertTrue(currentPrice >= nextPrice);
	} 
	
	Log.info("Expected sorting is validated, test is sucessfull");
	}
	catch(Exception e) {
		Log.error("Test failed due to unexpected behaviour: " + e.getMessage());
		Assert.assertTrue(false);

	}
}
}
