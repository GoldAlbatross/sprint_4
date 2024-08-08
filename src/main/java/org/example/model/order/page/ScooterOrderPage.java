package org.example.model.order.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScooterOrderPage {

    private final WebDriver driver;

    private static final String COMMENT = "Спасибо!";
    private static final String ELEMENT_IS_NOT_DISPLAYED = "Element is not Displayed";
    private static final String ORDER_IS_DONE = "Заказ оформлен";

    private static final By orderButton = By.xpath("//button[@class='Button_Button__ra12g' ]");

    private static final By firstNameInputField = By.xpath("//input[@placeholder='* Имя']");
    private static final By secondNameInputField = By.xpath("//input[@placeholder='* Фамилия']");
    private static final By addressInputField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By subWayInputField = By.xpath("//input[@placeholder='* Станция метро']");
    private static final By phoneNumberInputField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    private static final By goButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    private static final By dateInputField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private static final By periodInputField = By.xpath("//span[@class='Dropdown-arrow']");
    private static final By commentInputField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private static final By confirmOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");
    private static final By repeatConfirmOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");
    private static final By orderDoneScreen = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public ScooterOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void goButtonClick() {
        driver.findElement(goButton).click();
    }

    public void confirmOrderButtonClick() {
        driver.findElement(confirmOrderButton).click();
    }

    public void repeatConfirmOrderButtonClick() {
        driver.findElement(repeatConfirmOrderButton).click();
    }

    public void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
    }

    public String getTextFromBanner() {
        WebElement answerElement = driver.findElement(orderDoneScreen);
        waitForElementToBeVisible(answerElement);
        if (answerElement.isDisplayed()) {
            return answerElement.getText();
        } else  {
            return ELEMENT_IS_NOT_DISPLAYED;
        }
    }

    public void inputUserFields(String name, String lastName, String street, String subway, String phoneNumber) {
        clickToOrderButton();
        waitForElementToBeClickable(driver.findElement(firstNameInputField));
        driver.findElement(firstNameInputField).sendKeys(name);
        driver.findElement(secondNameInputField).sendKeys(lastName);
        driver.findElement(addressInputField).sendKeys(street);
        driver.findElement(subWayInputField).click();
        driver.findElement(By.xpath("//div[@class='select-search__select']/ul/li[" + subway + "]")).click();
        driver.findElement(phoneNumberInputField).sendKeys(phoneNumber);
    }

    public void inputScooterFields(String data, String period, String colorCheckbox) {
        driver.findElement(dateInputField).sendKeys(data);
        driver.findElement(periodInputField).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-menu']/div[" + period + "]")).click();
        driver.findElement(By.id(colorCheckbox)).click();
        driver.findElement(commentInputField).sendKeys(COMMENT);
        confirmOrderButtonClick();
        repeatConfirmOrderButtonClick();
        driver.findElement(orderDoneScreen);
    }

    public Boolean checkOrderScenario(
            String name,
            String lastName,
            String street,
            String subway,
            String phoneNumber,
            String data,
            String period,
            String colorCheckbox
    ) {
        inputUserFields(name, lastName, street, subway, phoneNumber);
        goButtonClick();
        inputScooterFields(data, period, colorCheckbox);
        String actualText = getTextFromBanner();
        return (ORDER_IS_DONE.equals(actualText));
    }
}