package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By TITLE = By.cssSelector(".title");
    private final By FIRST_NAME_INPUT = By.id("first-name");
    private final By LAST_NAME_INPUT = By.id("last-name");
    private final By ZIP_INPUT = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By FINISH_BUTTON = By.id("finish");
    private final By ERROR = By.cssSelector("h3[data-test=error]");

    private final By CANCEL = By.id("cancel");
    public WebElement getTitle() {
        return driver.findElement(TITLE);
    }

    public void fillIn(String firstName, String lastName, String zip) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_INPUT).sendKeys(zip);
        driver.findElement(CONTINUE_BUTTON).submit();
    }

    public void fillInAsStandardUser() {
        fillIn("test", "test", "12345");
    }
    public void informationPage() {
        driver.findElement(FINISH_BUTTON).click();
    }
    public String getError() {
        return driver.findElement(ERROR).getText();
    }
    public void cancel() {
        driver.findElement(CANCEL).click();
    }
}