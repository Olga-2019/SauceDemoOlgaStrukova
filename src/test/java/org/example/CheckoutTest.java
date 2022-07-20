package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {
    @Test
    public void userCanContinueWithValidCredentials() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        cartPage.checkout();
        checkoutPage.fillIn("test", "test", "12345");
        checkoutPage.informationPage();
        assertTrue(informationPage.getTitle().isDisplayed(), "it is not InformationPage");
    }

    @Test
    public void zipCodeShouldBeRequiredForCheckout() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        cartPage.checkout();
        checkoutPage.fillIn("test", "test", "");
        assertEquals(checkoutPage.getError(), "Error: Postal Code is required", "The error is incorrect");
    }

    @Test
    public void userCanGoBackToCartPage() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        cartPage.checkout();
        checkoutPage.cancel();
        assertTrue(cartPage.getTitle().isDisplayed(), "It is not Cart Page");
    }
}
