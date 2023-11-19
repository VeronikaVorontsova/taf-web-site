package by.itacademy.vorontsova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Vek21LoginElementsPage {
    public String cookieRejectButtonLocator = "//*[@type='button' and contains(.,'Отклонить')]";
    public String accountButtonMainLocator = "//*[@class='userToolsText']";
    public String accountEnterButtonLocator = "//*[@type='button' and contains(.,'Войти')]";
    public String popupLoginButtonLocator = "//*[contains(@class, 'Button-module__buttonText') and contains(text(),'Войти')]";
    public String emailFieldLocator = "//input[@id='login-email']";
    public String passwordFieldLocator = "//*[@id=\"login-password\"]";
    public String emailEmptyErrorLocator = "//*[contains(@class, 'ErrorMessage-module__message') and contains(text(), 'Электронная почта не указана')]";
    public String passwordEmptyErrorLocator = "//*[contains(@class, 'ErrorMessage-module__message') and contains(text(), 'Пароль не указан')]";
    public String wrongPasswordLocator = "//*[contains(@class, 'styles_errorText__LEN7M')]";

    String expectedEmailWarning = "Электронная почта не указана";
    String expectedPasswordWarning = "Пароль не указан";
    String expectedWrongUserDataWarning = "Неправильный пароль. \n" + "Сбросить пароль?";


    WebDriver driver;
    public Vek21LoginElementsPage(WebDriver driver){
        this.driver=driver;
    }
    public void cookieRejectButton() throws InterruptedException {
        driver.findElement(By.xpath(cookieRejectButtonLocator)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(cookieRejectButtonLocator)).click();
        Thread.sleep(500);
    }
    public void accountButtonMain() throws InterruptedException {
        driver.findElement(By.xpath(accountButtonMainLocator)).click();
        Thread.sleep(500);
    }
    public void accountEnterButton() throws InterruptedException {
        driver.findElement(By.xpath(accountEnterButtonLocator)).click();
        Thread.sleep(500);
    }
    public void popupLoginButton() throws InterruptedException{
        driver.findElement(By.xpath(popupLoginButtonLocator)).click();
        Thread.sleep(500);
    }
    public void emailField(String newEmail) throws InterruptedException {
        driver.findElement(By.xpath(emailFieldLocator)).sendKeys("user@gmail.com");
        Thread.sleep(1000);
    }
    public void passwordField(String newPassword) throws InterruptedException {
        driver.findElement(By.xpath(passwordFieldLocator)).sendKeys("12345");
        Thread.sleep(1000);
    }

}
