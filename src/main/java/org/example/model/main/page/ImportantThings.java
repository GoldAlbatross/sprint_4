package org.example.model.main.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImportantThings {

    private final WebDriver driver;

    private static final String ELEMENT_IS_NOT_DISPLAYED = "Element is not Displayed";
    private static final By askHowMatch = By.id("accordion__heading-0");
    private static final By answerHowMatch = By.xpath("//div[@id='accordion__panel-0']/p");

    private static final By askCanSeveralScooter = By.id("accordion__heading-1");
    private static final By answerCanSeveralScooter = By.xpath("//div[@id='accordion__panel-1']/p");

    private static final By askRentalTime = By.id("accordion__heading-2");
    private static final By answerRentalTime = By.xpath("//div[@id='accordion__panel-2']/p");

    private static final By askOrderToday = By.id("accordion__heading-3");
    private static final By answerOrderToday = By.xpath("//div[@id='accordion__panel-3']/p");

    private static final By askExtendOrReturn = By.id("accordion__heading-4");
    private static final By answerExtendOrReturn = By.xpath("//div[@id='accordion__panel-4']/p");

    private static final By askChargerIncluded = By.id("accordion__heading-5");
    private static final By answerChargerIncluded = By.xpath("//div[@id='accordion__panel-5']/p");

    private static final By askCancelOrder = By.id("accordion__heading-6");
    private static final By answerCancelOrder = By.xpath("//div[@id='accordion__panel-6']/p");

    private static final By askDeliverOutsideMKAD = By.id("accordion__heading-7");
    private static final By answerDeliverOutsideMKAD = By.xpath("//div[@id='accordion__panel-7']/p");

    public ImportantThings(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToCurrentElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
    }

    public void clickAccordionHeader(By locator) {
        WebElement element = driver.findElement(locator);
        scrollToCurrentElement(element);
        waitForElementToBeClickable(element);
        element.click();
    }

    public String getTextFromAccordionPanel(By locator) {
        WebElement answerElement = driver.findElement(locator);
        waitForElementToBeVisible(answerElement);
        if (answerElement.isDisplayed()) {
            return driver.findElement(locator).getText();
        } else  {
            return ELEMENT_IS_NOT_DISPLAYED;
        }
    }

    public Boolean checkAskHowMatch(String expectedAnswerHowMatch) {
        clickAccordionHeader(askHowMatch);
        String actualText = getTextFromAccordionPanel(answerHowMatch);
        return (expectedAnswerHowMatch.equals(actualText));
    }

    public Boolean checkAskCanSeveralScooter(String expectedAnswerCanSeveralScooter) {
        clickAccordionHeader(askCanSeveralScooter);
        String actualText = getTextFromAccordionPanel(answerCanSeveralScooter);
        return (expectedAnswerCanSeveralScooter.equals(actualText));
    }

    public Boolean checkAskRentalTime(String expectedAnswerRentalTime) {
        clickAccordionHeader(askRentalTime);
        String actualText = getTextFromAccordionPanel(answerRentalTime);
        return (expectedAnswerRentalTime.equals(actualText));
    }

    public Boolean checkAskOrderToday(String expectedAnswerOrderToday) {
        clickAccordionHeader(askOrderToday);
        String actualText = getTextFromAccordionPanel(answerOrderToday);
        return (expectedAnswerOrderToday.equals(actualText));
    }

    public Boolean checkAskExtendOrReturn(String expectedAnswerExtendOrReturn) {
        clickAccordionHeader(askExtendOrReturn);
        String actualText = getTextFromAccordionPanel(answerExtendOrReturn);
        return (expectedAnswerExtendOrReturn.equals(actualText));
    }

    public Boolean checkAskChargerIncluded(String expectedAnswerChargerIncluded) {
        clickAccordionHeader(askChargerIncluded);
        String actualText = getTextFromAccordionPanel(answerChargerIncluded);
        return (expectedAnswerChargerIncluded.equals(actualText));
    }

    public Boolean checkAskCancelOrder(String expectedAnswerCancelOrder) {
        clickAccordionHeader(askCancelOrder);
        String actualText = getTextFromAccordionPanel(answerCancelOrder);
        return (expectedAnswerCancelOrder.equals(actualText));
    }

    public Boolean checkAskDeliverOutsideMKAD(String expectedAnswerDeliverOutsideMKAD) {
        clickAccordionHeader(askDeliverOutsideMKAD);
        String actualText = getTextFromAccordionPanel(answerDeliverOutsideMKAD);
        return (expectedAnswerDeliverOutsideMKAD.equals(actualText));
    }
}
