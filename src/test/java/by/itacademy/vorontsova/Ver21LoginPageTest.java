package by.itacademy.vorontsova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ver21LoginPageTest {
    @Test //Test1 - All fields are empty
    public void testLoginEmptyFields() throws InterruptedException {
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.21vek.by/");

        driver.findElement(By.xpath(vek21LoginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(vek21LoginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(vek21LoginElementsPage.accountButtonLocator)).click();

        driver.findElement(By.xpath(vek21LoginElementsPage.accountLoginButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(vek21LoginElementsPage.popupLoginButtonLocator)).click();

        String expectedEmailWarning = "Электронная почта не указана";
        String actualEmailWarning = driver.findElement(By.xpath(vek21LoginElementsPage.emailEmptyErrorLocator)).getText();
        String expectedPasswordWarning = "Пароль не указан";
        String actualPasswordWarning = driver.findElement(By.xpath(vek21LoginElementsPage.passwordEmptyErrorLocator)).getText();

        Assertions.assertEquals(expectedEmailWarning, actualEmailWarning);
        Assertions.assertEquals(expectedPasswordWarning, actualPasswordWarning);

        Thread.sleep(3000);
        driver.quit();
    }

    @Test //Test2 - Email field is empty
    public void testLoginEmptyEmail() throws InterruptedException {
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.21vek.by/");

        driver.findElement(By.xpath(vek21LoginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(vek21LoginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(vek21LoginElementsPage.accountButtonLocator)).click();

        driver.findElement(By.xpath(vek21LoginElementsPage.accountLoginButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(vek21LoginElementsPage.emailFieldLocator)).sendKeys("user@gmail.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath(vek21LoginElementsPage.popupLoginButtonLocator)).click();

        String expectedPasswordWarning = "Пароль не указан";
        String actualPasswordWarning = driver.findElement(By.xpath(vek21LoginElementsPage.passwordEmptyErrorLocator)).getText();

        Assertions.assertEquals(expectedPasswordWarning, actualPasswordWarning);

        Thread.sleep(3000);
        driver.quit();
    }

    @Test //Test3 - Password field is empty
    public void testLoginEmptyPassword() throws InterruptedException {
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.21vek.by/");

        driver.findElement(By.xpath(vek21LoginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(vek21LoginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(vek21LoginElementsPage.accountButtonLocator)).click();

        driver.findElement(By.xpath(vek21LoginElementsPage.accountLoginButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(vek21LoginElementsPage.passwordFieldLocator)).sendKeys("12345");

        driver.findElement(By.xpath(vek21LoginElementsPage.popupLoginButtonLocator)).click();

        String expectedEmailWarning = "Электронная почта не указана";
        String actualEmailWarning = driver.findElement(By.xpath(vek21LoginElementsPage.emailEmptyErrorLocator)).getText();

        Assertions.assertEquals(expectedEmailWarning, actualEmailWarning);

        Thread.sleep(3000);
        driver.quit();
    }

    @Test //Test 4 - User data is not correct
    public void testLoginWrongUserData() throws InterruptedException {
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.21vek.by/");

        driver.findElement(By.xpath(vek21LoginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(vek21LoginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(vek21LoginElementsPage.accountButtonLocator)).click();

        driver.findElement(By.xpath(vek21LoginElementsPage.accountLoginButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(vek21LoginElementsPage.emailFieldLocator)).sendKeys("user@gmail.com");
        driver.findElement(By.xpath(vek21LoginElementsPage.passwordFieldLocator)).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.xpath(vek21LoginElementsPage.popupLoginButtonLocator)).click();
        Thread.sleep(1000);

        String expectedWrongUserDataWarning = "Неправильный пароль. \n" + "Сбросить пароль?";
        String actualWrongUserDataWarning = driver.findElement(By.xpath(vek21LoginElementsPage.wrongPasswordLocator)).getText();

        Assertions.assertEquals(expectedWrongUserDataWarning, actualWrongUserDataWarning);

        Thread.sleep(3000);
        driver.quit();
    }
}

