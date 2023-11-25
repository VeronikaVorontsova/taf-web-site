package by.itacademy.vorontsova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassRwByElementsPage {
    public String profileButtonLocator = "//span[contains(., 'Личный кабинет')]";
    public String authorizationPopupLocator = "//div[contains(@class, 'auth-modal__header')]";
    public String emailInputLocator = "//input[@name='login']";
    public String passwordInputLocator = "//input[@name='password']";
    public String loginButtonLocator = "//input[@name='dologin']";
    public String emptyLoginErrorLocator = "//label[@id='login-error' and contains(text(), 'Заполните поле')]";
    public String emptyPasswordErrorLocator = "//label[@id='password-error' and contains(text(), 'Заполните поле')]";
    public String userIsNotFoundErrorLocator = "//*[contains(text(), 'Пользователь не найден')]";

    public String expectedEmptyInputWarning = "Заполните поле";
    public String expectedWrongUserWarning = "Пользователь не найден";

    WebDriver driver;

    public PassRwByElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfileButton() throws InterruptedException {
        driver.findElement(By.xpath(profileButtonLocator)).click();
        Thread.sleep(500);
    }

    public boolean checkAuthorizationPopupIsDisplayed() {
        return driver.findElement(By.xpath(authorizationPopupLocator)).isDisplayed();
    }

    public void clickLoginButton() throws InterruptedException {
        driver.findElement(By.xpath(loginButtonLocator)).click();
        Thread.sleep(500);
    }

    public String getTextEmailEmptyWarning() {
        return driver.findElement(By.xpath(emptyLoginErrorLocator)).getText();
    }

    public String getTextPasswordEmptyWarning() {
        return driver.findElement(By.xpath(emptyPasswordErrorLocator)).getText();
    }

    public void sendKeysEmailInput() {
        driver.findElement(By.xpath(emailInputLocator)).sendKeys("123@mail.ru");
    }

    public void sendKeysPasswordInput() {
        driver.findElement(By.xpath(passwordInputLocator)).sendKeys("12345");
    }

    public String getTextWrongUserWarning() {
        return driver.findElement(By.xpath(userIsNotFoundErrorLocator)).getText();
    }
}
