package by.itacademy.vorontsova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TempoOrderTest extends BaseTest {

    @BeforeEach
    public void getUrl() {
        driver.get("https://www.pizzatempo.by/");
    }

    @Test
    public void addAndCheckCart() {
        TempoElementsPage tempoElementsPage = new TempoElementsPage(driver);
        tempoElementsPage.clickPizzaTab();
        tempoElementsPage.clickMargaritaOrderButton();
        tempoElementsPage.clickPopupOrderButton();
        tempoElementsPage.clickCartButton();
        Assertions.assertTrue(tempoElementsPage.checkPositionInCartIsDisplayed());
    }
}
