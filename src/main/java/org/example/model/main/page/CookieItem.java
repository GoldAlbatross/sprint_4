package org.example.model.main.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookieItem {

    private final WebDriver driver;

    public CookieItem(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToCookieItemAndClick() {
        WebElement element = driver.findElement(By.id("rcc-confirm-button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
}
