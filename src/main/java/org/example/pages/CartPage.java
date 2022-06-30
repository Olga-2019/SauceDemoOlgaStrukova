package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private final By TITLE = By.cssSelector(".title");

    private final String Remove = "//div[text()='%s']/ancestor::div[@class='cart_item']//button";
    private final By CONTINUE_SHOPPING = By.id("continue-shopping");
    private final By CART = By.className("shopping_cart_link");
    private final By CHECKOUT = By.id("checkout");
    public void open() {
        driver.findElement(CART).click();
    }

    public WebElement getTitle() {
        return driver.findElement(TITLE);
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public void checkout() {
        driver.findElement(CHECKOUT).click();
    }
}


