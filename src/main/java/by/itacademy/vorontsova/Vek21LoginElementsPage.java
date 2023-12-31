package by.itacademy.vorontsova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Vek21LoginElementsPage {
    private String cookieRejectButtonLocator = "//*[@type='button' and contains(.,'Отклонить')]";
    private String accountButtonMainLocator = "//*[@class='userToolsText']";
    private String accountEnterButtonLocator = "//*[@type='button' and contains(.,'Войти')]";
    private String popupLoginButtonLocator = "//*[contains(@class, 'Button-module__buttonText') and contains(text(),'Войти')]";
    private String emailFieldLocator = "//input[@id='login-email']";
    private String passwordFieldLocator = "//*[@id='login-password']";
    private String emailEmptyErrorLocator = "//*[contains(@class, 'ErrorMessage-module__message') and contains(text(), 'Электронная почта не указана')]";
    private String passwordEmptyErrorLocator = "//*[contains(@class, 'ErrorMessage-module__message') and contains(text(), 'Пароль не указан')]";
    private String wrongPasswordLocator = "//*[contains(@class, 'styles_errorText__LEN7M')]";

    String expectedEmailWarning = "Электронная почта не указана";
    String expectedPasswordWarning = "Пароль не указан";
    String expectedWrongUserDataWarning = "Неправильный пароль. \n" + "Сбросить пароль?";


    WebDriver driver;
    public Vek21LoginElementsPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickCookieRejectButton() throws InterruptedException {
        driver.findElement(By.xpath(cookieRejectButtonLocator)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(cookieRejectButtonLocator)).click();
        Thread.sleep(500);
    }
    public void clickAccountButtonMain() throws InterruptedException {
        driver.findElement(By.xpath(accountButtonMainLocator)).click();
        Thread.sleep(500);
    }
    public void clickAccountEnterButton() throws InterruptedException {
        driver.findElement(By.xpath(accountEnterButtonLocator)).click();
        Thread.sleep(500);
    }
    public void clickPopupLoginButton() throws InterruptedException{
        driver.findElement(By.xpath(popupLoginButtonLocator)).click();
        Thread.sleep(500);
    }
    public void sendKeysEmailField() throws InterruptedException {
        driver.findElement(By.xpath(emailFieldLocator)).sendKeys("user@gmail.com");
        Thread.sleep(1000);
    }
    public void sendKeysPasswordField() throws InterruptedException {
        driver.findElement(By.xpath(passwordFieldLocator)).sendKeys("12345");
        Thread.sleep(1000);
    }
    public String getTextEmailEmptyError() throws InterruptedException {
        Thread.sleep(500);
        return driver.findElement(By.xpath(emailEmptyErrorLocator)).getText();
    }
    public String getTextPasswordEmptyError() {
        return driver.findElement(By.xpath(passwordEmptyErrorLocator)).getText();
    }

    public String getTextWrongPassword() {
        return driver.findElement(By.xpath(wrongPasswordLocator)).getText();
    }

}
