package by.itacademy.vorontsova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TerraElementsPage {
    private String closeCookies = "//*[contains(@class, 'close-icon')]";
    private String pizzaSection = "//*[contains(@class, 'menu-navigation__item') and contains(.,'Пицца')]";
    private String margaritaOrderButton = "//*[contains(@class, 'menu-card__info-wrap') and contains(.,'Маргарита')]//div[contains(@class, 'cart-button')]";
    private String barSection = "//*[contains(@class, 'menu-navigation__item') and contains(.,'Бар')]";
    private String gluehweinOrderButton = "//*[contains(@class, 'menu-card__info-wrap') and contains(.,'Вишневый глинтвейн')]//button[contains(@class, 'menu-card__footer-btn add-basket-btn')]";
    private String cartButton = "//div[@class=\"basket__btn-top basket__top basket__btn-top--sm\"]";
    private String pizzaInCart = "//*[contains(@class,\"basket__products-item-name\") and contains(., 'Пицца Маргарита')]";
    private String drinkInCart = "//*[contains(@class,'basket__products-item-name') and contains(., 'Вишневый глинтвейн')]";

    private WebDriver driver;

    public TerraElementsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void closeCookies() {
        driver.findElement(By.xpath(closeCookies)).click();
    }

    public void clickPizzaTab() {
        driver.findElement(By.xpath(pizzaSection)).click();
    }

    public void clickMargaritaOrderButton() {
        driver.findElement(By.xpath(margaritaOrderButton)).click();
    }

    public void clickBarTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        WebElement beverage = driver.findElement(By.xpath(barSection));
        wait.until(ExpectedConditions.visibilityOf(beverage));
        driver.findElement(By.xpath(barSection)).click();
    }

    public void clickGluehweinOrderButton() {
        driver.findElement(By.xpath(gluehweinOrderButton)).click();
    }

    public void clickCartButton() {
        driver.findElement(By.xpath(cartButton)).click();
    }

    public boolean isPizzaInCartDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        WebElement pizza = driver.findElement(By.xpath(pizzaInCart));
        wait.until(ExpectedConditions.visibilityOf(pizza));
        return driver.findElement(By.xpath(pizzaInCart)).isDisplayed();
    }

    public boolean isBeverageInCartDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        WebElement beverage = driver.findElement(By.xpath(drinkInCart));
        wait.until(ExpectedConditions.visibilityOf(beverage));
        return driver.findElement(By.xpath(drinkInCart)).isDisplayed();
    }
}

