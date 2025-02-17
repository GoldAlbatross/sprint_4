import org.example.model.main.page.CookieItem;
import org.example.model.main.page.ImportantThings;
import org.example.model.order.page.ScooterOrderPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebTest {

    private WebDriver driver;

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        open();
        new CookieItem(driver).scrollToCookieItemAndClick();
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    public void open() {
        driver.get(PAGE_URL);
    }

    @Test
    public void checkAccordionComponentsAskHowMatch() {
        ImportantThings importantThings = new ImportantThings(driver);
        assertTrue(importantThings.checkAskHowMatch(ExpectedResultConstant.expectedAnswerHowMatch));
    }

    @Test
    public void checkAccordionComponentsAskCanSeveralScooter() {
        ImportantThings importantThings = new ImportantThings(driver);
        assertTrue(importantThings.checkAskCanSeveralScooter(ExpectedResultConstant.expectedAnswerCanSeveralScooter));
    }

    @Test
    public void checkAccordionComponentsAskRentalTime() {
        ImportantThings importantThings = new ImportantThings(driver);
        assertTrue(importantThings.checkAskRentalTime(ExpectedResultConstant.expectedAnswerRentalTime));
    }

    @Test
    public void checkAccordionComponentsAskOrderToday() {
        ImportantThings importantThings = new ImportantThings(driver);
        assertTrue(importantThings.checkAskOrderToday(ExpectedResultConstant.expectedAnswerOrderToday));
    }

    @Test
    public void checkAccordionComponentsAskExtendOrReturn() {
        ImportantThings importantThings = new ImportantThings(driver);
        assertTrue(importantThings.checkAskExtendOrReturn(ExpectedResultConstant.expectedAnswerExtendOrReturn));
    }

    @Test
    public void checkAccordionComponentsAskChargerIncluded() {
        ImportantThings importantThings = new ImportantThings(driver);
        assertTrue(importantThings.checkAskChargerIncluded(ExpectedResultConstant.expectedAnswerChargerIncluded));
    }

    @Test
    public void checkAccordionComponentsAskCancelOrder() {
        ImportantThings importantThings = new ImportantThings(driver);
        assertTrue(importantThings.checkAskCancelOrder(ExpectedResultConstant.expectedAnswerCancelOrder));
    }

    @Test
    public void checkAccordionComponentsAskDeliverOutsideMKAD() {
        ImportantThings importantThings = new ImportantThings(driver);
        assertTrue(importantThings.checkAskDeliverOutsideMKAD(ExpectedResultConstant.expectedAnswerDeliverOutsideMKAD));
    }


    @ParameterizedTest
    @CsvSource({
            "Иван, Иванов, г Москва ул Черкизовская 12 кв 4, 7, +79069999999, 22.08.2024, 1, black",
            "Петр, Петров, г Москва Сереневый бульвар 34 кв 3, 2, +79507854565, 10.11.2024, 2, grey",
    })
    public void checkOrderScenario(
            String name,
            String lastName,
            String street,
            String subway,
            String phoneNumber,
            String data,
            String period,
            String colorCheckbox
            ) {
        ScooterOrderPage scooterOrderPage = new ScooterOrderPage(driver);
        open();
        scooterOrderPage.inputUserFields(name, lastName, street, subway, phoneNumber);
        boolean result = scooterOrderPage.checkOrderScenario(name, lastName, street, subway, phoneNumber, data, period, colorCheckbox);
        assertTrue(result);
    }
}