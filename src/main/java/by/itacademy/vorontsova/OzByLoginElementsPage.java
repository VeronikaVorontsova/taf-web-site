package by.itacademy.vorontsova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OzByLoginElementsPage {
    String loginButtonLocator = "//*[contains(@class, 'user-bar__title') and contains(text(), 'Войти')]";
    String emailLoginTabLocator = "//*[contains(@class, 'i-nav-tabs__link') and contains(text(), 'Электронная почта')]";
    String emailFieldLocator = "//input[@placeholder='Электронная почта']";
    String passwordFieldLocator = "//input[@placeholder='Пароль']";
    String loginWithEmailPasswordButtonLocator = "//*[@type = \"submit\" and contains(text(), 'Войти')]";
    String emptyEmailWarningLocator = "//*[contains(text(), 'Введите адрес электронной почты')]";
    String emptyPasswordWarningLocator = "//*[contains(text(), 'Введите пароль')]";
    String notRegisteredEmailLocator = "//*[contains(@class, 'i-popover__main') and contains(., 'Адрес электронной почты не зарегистрирован. ')]";

    String expectedEmptyEmailWarning = "Введите адрес электронной почты";
    String expectedEmptyPasswordWarning = "Введите пароль";
    String expectedWrongUserDataWarning = "Адрес электронной почты не зарегистрирован. "+"Зарегистрироваться";

    WebDriver driver;
    public OzByLoginElementsPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickLoginButton() throws InterruptedException {
        driver.findElement(By.xpath(loginButtonLocator)).click();
        Thread.sleep(1000);
    }
    public void clickEmailLoginTab() throws InterruptedException {
        driver.findElement(By.xpath(emailLoginTabLocator)).click();
        Thread.sleep(1000);
    }

    public void sendKeysEmailField() {
        driver.findElement(By.xpath(emailFieldLocator)).sendKeys("user@tut.by");

    }
    public void sendKeysPasswordField() {
        driver.findElement(By.xpath(passwordFieldLocator)).sendKeys("12345");
    }
    public void clickLoginWithEmailPasswordButton() throws InterruptedException {
        driver.findElement(By.xpath(loginWithEmailPasswordButtonLocator)).click();
        Thread.sleep(1000);
    }
    public String getTextNotRegisteredEmail() {

        return driver.findElement(By.xpath(notRegisteredEmailLocator)).getText();
    }
    public String getTextEmptyEmailWarning() {

        return driver.findElement(By.xpath(emptyEmailWarningLocator)).getText();

    }
    public String getTextEmptyPasswordWarning() throws InterruptedException {
        Thread.sleep(500);

        return driver.findElement(By.xpath(emptyPasswordWarningLocator)).getText();
    }

}
