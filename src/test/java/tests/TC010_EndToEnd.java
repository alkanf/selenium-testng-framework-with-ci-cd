package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Log;

public class TC010_EndToEnd extends BaseTest {

    @Test
    public void verifyEndToEndFlow() {

        Log.info("TC010_EndToEndTest starts....");

        try {
            SoftAssert sa = new SoftAssert();

            // LOGIN
            LoginPage lp = new LoginPage(driver);
            Log.info("Logging in...");
            lp.login(ConfigReader.getProperty("valid_username"),
                     ConfigReader.getProperty("valid_password"));

            // INVENTORY VALIDATION, LOW TO HIGH
            InventoryPage ip = new InventoryPage(driver);
        	ip.clickSortLowToHighSelect();


            // ADD TO CART
            Log.info("Adding product to cart...");
            ip.clickAddToCart();

            String cartCount = ip.verifyAddToCartNumber();
            sa.assertEquals(cartCount, "1", "Cart count is not 1");

            // GO TO CART
            Log.info("Navigating to cart...");
            ip.clickCartPage();

            CartPage cp = new CartPage(driver);

            // CHECKOUT
            Log.info("Proceeding to checkout...");
            cp.clickCheckoutPage();

            CheckoutPage ch = new CheckoutPage(driver);

            Log.info("Filling checkout info...");
            ch.typeFirstName(ConfigReader.getProperty("username"));
            ch.typeLastName(ConfigReader.getProperty("lastname"));
            ch.typePostalCode(ConfigReader.getProperty("zip"));
            ch.clickContinue();

            // VERIFY PRODUCT COUNT IN CHECKOUT
            String checkoutQty = ch.verifyCartQuantity();
            sa.assertEquals(checkoutQty, "1", "Checkout quantity mismatch");

            // FINISH ORDER
            Log.info("Finishing order...");
            ch.clickFinish();

            // VERIFY SUCCESS
            boolean isOrderComplete = ch.verifyCheckout();
            Assert.assertTrue(isOrderComplete, "Order not completed");

            // LOGOUT
            Log.info("Logging out...");
            ip.clickHamburger();
            ip.clickLogout();

            Assert.assertTrue(lp.actualResult(), "Logout failed");

            sa.assertAll();

            Log.info("Expected end to end result is validated, test is sucessfull ");

        } catch (Exception e) {
            Log.error("E2E Test failed: " + e.getMessage());
            Assert.fail();
        }
    }
}