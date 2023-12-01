package by.itacademy.vorontsova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassRwByElementsPage {

    private String profileButtonLocator = "//span[contains(., 'Личный кабинет')]";
    private String authorizationPopupLocator = "//*[contains(@class, 'auth-modal__header')]";
    private String emailInputLocator = "//input[@name='login']";
    private String passwordInputLocator = "//input[@name='password']";
    private String loginButtonLocator = "//input[@name='dologin']";
    private String emptyLoginErrorLocator = "//label[@id='login-error' and contains(text(), 'Заполните поле')]";
    private String emptyPasswordErrorLocator = "//label[@id='password-error' and contains(text(), 'Заполните поле')]";
    private String userIsNotFoundErrorLocator = "//*[contains(text(), 'Пользователь не найден')]";

    String expectedEmptyInputWarning = "Заполните поле";
    String expectedWrongUserWarning = "Пользователь не найден";

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
