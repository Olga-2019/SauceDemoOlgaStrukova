package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {
    @Test
    public void openCart() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        assertTrue(cartPage.getTitle().isDisplayed(), "It isn't cartpage");
    }

    @Test
    public void userCanGoBackToProductsPageFromCartPage() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        cartPage.continueShopping();
        assertTrue(productsPage.getTitle().isDisplayed(), "User was not go back to product page");
    }

    @Test
    public void userCanGoToCheckoutPageFromCartPage() {
        loginPage.open();
        loginPage.loginAsStandardUser();
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        cartPage.checkout();
        assertTrue(checkoutPage.getTitle().isDisplayed(), "User was not go to checkout page");
    }
}