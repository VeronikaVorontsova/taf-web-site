package by.itacademy.vorontsova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TempoElementsPage {
    private String pizzaSection = "//span[text() ='Пицца']";
    private String margaritaOrderButton = "//*[@id=1]//button[contains(.,\"Заказ\")]";
    private String popUpOrderButton = "//*[@class='popupContent']//button[contains(.,\"Заказ\")]";
    private String cartButton = "//*[@id=\"basket_placeholder\"]/div/div/div[1]/div[1]/a/span/span";
    private String positionInCart = "//*[@id=\"basket_expand\"]//*[contains(text(), 'Маргарита')]";

    private WebDriver driver;

    public TempoElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPizzaTab() {
        driver.findElement(By.xpath(pizzaSection)).click();
    }

    public void clickMargaritaOrderButton() {
        driver.findElement(By.xpath(margaritaOrderButton)).click();
    }

    public void clickPopupOrderButton() {
        driver.findElement(By.xpath(popUpOrderButton)).click();
    }

    public void clickCartButton() {
        driver.findElement(By.xpath(cartButton)).click();
    }

    public boolean checkPositionInCartIsDisplayed() {
        return driver.findElement(By.xpath(positionInCart)).isDisplayed();
    }
}
