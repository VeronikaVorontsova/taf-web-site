package by.itacademy.vorontsova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TempoElementsPage {

    private String pizzaSection = "//span[text() ='Пицца']";
    private String margaritaOrderButton = "//*[@id=1]//button";
    private String beverageSection = "//a[contains(.,'Напитки')]";
    private String colaOrderButton = "//div[contains(@class,'item_product')][.//span[contains(text(),'Кока-Кола')]]//span[text()='Заказ']";
    private String popUpOrderButton = "//*[@class='popupContent']//button[contains(.,\"Заказ\")]";
    private String cartButton = "//*[@id=\"basket_placeholder\"]/div/div/div[1]/div[1]/a/span/span";
    private String pizzaInCart = "//*[@id=\"basket_expand\"]//*[contains(text(), 'Маргарита')]";
    private String beverageInCart = "//*[@id=\"basket_expand\"]//*[contains(text(), 'Кока-Кола')]";

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

    public void clickColaOrderButton() {
        driver.findElement(By.xpath(colaOrderButton)).click();
    }

    public void clickPopupOrderButton() {
        driver.findElement(By.xpath(popUpOrderButton)).click();
    }

    public void clickBeverageTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        WebElement beverage = driver.findElement(By.xpath(beverageSection));
        wait.until(ExpectedConditions.visibilityOf(beverage));
        driver.findElement(By.xpath(beverageSection)).click();
    }

    public void clickCartButton() {
        driver.findElement(By.xpath(cartButton)).click();
    }

    public boolean isPizzaInCartDisplayed() {
        return driver.findElement(By.xpath(pizzaInCart)).isDisplayed();
    }

    public boolean isBeverageInCartDisplayed() {
        return driver.findElement(By.xpath(beverageInCart)).isDisplayed();
    }
}
