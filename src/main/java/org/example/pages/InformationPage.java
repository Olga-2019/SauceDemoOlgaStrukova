package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformationPage extends BasePage {
    private final By TITLE = By.cssSelector(".title");

    public InformationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return driver.findElement(TITLE);
    }
}
