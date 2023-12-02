package by.itacademy.vorontsova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TerraOrderTest extends BaseTest {

    @Test
    public void addPizzaAndCheckCart() {
        TerraElementsPage terraElementsPage = new TerraElementsPage(driver);
        driver.get("https://terrapizza.by/");

        terraElementsPage.closeCookies();
        terraElementsPage.clickPizzaTab();
        terraElementsPage.clickMargaritaOrderButton();
        terraElementsPage.clickBarTab();
        terraElementsPage.clickGluehweinOrderButton();
        terraElementsPage.clickCartButton();
        Assertions.assertTrue(terraElementsPage.isBeverageInCartDisplayed());
        Assertions.assertTrue(terraElementsPage.isPizzaInCartDisplayed());

    }
}
