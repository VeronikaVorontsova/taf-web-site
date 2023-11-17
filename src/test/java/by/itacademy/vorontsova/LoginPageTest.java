package by.itacademy.vorontsova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {
    @Test //Test1 - All fields are empty
    public void testLoginEmptyFields() throws InterruptedException {
        LoginElementsPage loginElementsPage = new LoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.21vek.by/");

        driver.findElement(By.xpath(loginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(loginElementsPage.accountButtonLocator)).click();

        driver.findElement(By.xpath(loginElementsPage.accountLoginButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(loginElementsPage.popupLoginButtonLocator)).click();

        String expectedEmailWarning = "Электронная почта не указана";
        String actualEmailWarning = driver.findElement(By.xpath(loginElementsPage.emailEmptyErrorLocator)).getText();
        String expectedPasswordWarning = "Пароль не указан";
        String actualPasswordWarning = driver.findElement(By.xpath(loginElementsPage.passwordEmptyErrorLocator)).getText();

        Assertions.assertEquals(expectedEmailWarning, actualEmailWarning);
        Assertions.assertEquals(expectedPasswordWarning, actualPasswordWarning);

        Thread.sleep(3000);
        driver.quit();
    }

    @Test //Test2 - Email field is empty
    public void testLoginEmptyEmail() throws InterruptedException {
        LoginElementsPage loginElementsPage = new LoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.21vek.by/");

        driver.findElement(By.xpath(loginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(loginElementsPage.accountButtonLocator)).click();

        driver.findElement(By.xpath(loginElementsPage.accountLoginButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(loginElementsPage.emailFieldLocator)).sendKeys("user@gmail.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath(loginElementsPage.popupLoginButtonLocator)).click();

        String expectedPasswordWarning = "Пароль не указан";
        String actualPasswordWarning = driver.findElement(By.xpath(loginElementsPage.passwordEmptyErrorLocator)).getText();

        Assertions.assertEquals(expectedPasswordWarning, actualPasswordWarning);

        Thread.sleep(3000);
        driver.quit();
    }

    @Test //Test3 - Password field is empty
    public void testLoginEmptyPassword() throws InterruptedException {
        LoginElementsPage loginElementsPage = new LoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.21vek.by/");

        driver.findElement(By.xpath(loginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(loginElementsPage.accountButtonLocator)).click();

        driver.findElement(By.xpath(loginElementsPage.accountLoginButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(loginElementsPage.passwordFieldLocator)).sendKeys("12345");

        driver.findElement(By.xpath(loginElementsPage.popupLoginButtonLocator)).click();

        String expectedEmailWarning = "Электронная почта не указана";
        String actualEmailWarning = driver.findElement(By.xpath(loginElementsPage.emailEmptyErrorLocator)).getText();

        Assertions.assertEquals(expectedEmailWarning, actualEmailWarning);

        Thread.sleep(3000);
        driver.quit();
    }

    @Test //Test 4 - User data is not correct
    public void testLoginWrongUserData() throws InterruptedException {
        LoginElementsPage loginElementsPage = new LoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.21vek.by/");

        driver.findElement(By.xpath(loginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loginElementsPage.cookieRejectButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(loginElementsPage.accountButtonLocator)).click();

        driver.findElement(By.xpath(loginElementsPage.accountLoginButtonLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(loginElementsPage.emailFieldLocator)).sendKeys("user@gmail.com");
        driver.findElement(By.xpath(loginElementsPage.passwordFieldLocator)).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.xpath(loginElementsPage.popupLoginButtonLocator)).click();
        Thread.sleep(1000);

        String expectedWrongUserDataWarning = "Неправильный пароль. \n" + "Сбросить пароль?";
        String actualWrongUserDataWarning = driver.findElement(By.xpath(loginElementsPage.wrongPasswordLocator)).getText();

        Assertions.assertEquals(expectedWrongUserDataWarning, actualWrongUserDataWarning);

        Thread.sleep(3000);
        driver.quit();
    }
}

