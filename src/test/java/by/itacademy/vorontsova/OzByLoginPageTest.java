package by.itacademy.vorontsova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OzByLoginPageTest {
    @Test //Test 1 - Empty Fields
    public void testOzLoginEmptyFields() throws InterruptedException {
        OzByLoginElementsPage ozByLoginElementsPage = new OzByLoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://oz.by/");

        driver.findElement(By.xpath(ozByLoginElementsPage.loginButtonLocator)).click();
        Thread.sleep(500);

        driver.findElement(By.xpath(ozByLoginElementsPage.emailLoginTabLocator)).click();
        driver.findElement(By.xpath(ozByLoginElementsPage.loginWithEmailPasswordButtonLocator)).click();

        String expectedEmptyEmailWarning = "Введите адрес электронной почты";
        String actualEmptyEmailWarning = driver.findElement(By.xpath(ozByLoginElementsPage.emptyEmailWarningLocator)).getText();

        Assertions.assertEquals(expectedEmptyEmailWarning, actualEmptyEmailWarning);

        Thread.sleep(2000);
        driver.quit();
    }
    @Test //Test 2 - Empty email field
    public void testOzLoginEmptyEmailField() throws InterruptedException {
        OzByLoginElementsPage ozByLoginElementsPage = new OzByLoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://oz.by/");

        driver.findElement(By.xpath(ozByLoginElementsPage.loginButtonLocator)).click();
        Thread.sleep(500);

        driver.findElement(By.xpath(ozByLoginElementsPage.emailLoginTabLocator)).click();

        driver.findElement(By.xpath(ozByLoginElementsPage.passwordFieldLocator)).sendKeys("12345");
        driver.findElement(By.xpath(ozByLoginElementsPage.loginWithEmailPasswordButtonLocator)).click();

        String expectedEmptyEmailWarning = "Введите адрес электронной почты";
        String actualEmptyEmailWarning = driver.findElement(By.xpath(ozByLoginElementsPage.emptyEmailWarningLocator)).getText();

        Assertions.assertEquals(expectedEmptyEmailWarning, actualEmptyEmailWarning);

        Thread.sleep(2000);
        driver.quit();
    }
    @Test //Test 3 - Empty password field
    public void testOzLoginEmptyPasswordField() throws InterruptedException {
        OzByLoginElementsPage ozByLoginElementsPage = new OzByLoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://oz.by/");

        driver.findElement(By.xpath(ozByLoginElementsPage.loginButtonLocator)).click();
        Thread.sleep(500);

        driver.findElement(By.xpath(ozByLoginElementsPage.emailLoginTabLocator)).click();

        driver.findElement(By.xpath(ozByLoginElementsPage.emailFieldLocator)).sendKeys("user@tut.by");
        driver.findElement(By.xpath(ozByLoginElementsPage.loginWithEmailPasswordButtonLocator)).click();

        String expectedEmptyPasswordWarning = "Введите пароль";
        String actualEmptyPasswordWarning = driver.findElement(By.xpath(ozByLoginElementsPage.emptyPasswordWarningLocator)).getText();

        Assertions.assertEquals(expectedEmptyPasswordWarning, actualEmptyPasswordWarning);

        Thread.sleep(2000);
        driver.quit();
    }
    @Test //Test 4 - Wrong user data
    public void testOzLoginWrongUserData() throws InterruptedException {
        OzByLoginElementsPage ozByLoginElementsPage = new OzByLoginElementsPage();
        WebDriver driver = new ChromeDriver();
        driver.get("https://oz.by/");

        driver.findElement(By.xpath(ozByLoginElementsPage.loginButtonLocator)).click();
        Thread.sleep(500);

        driver.findElement(By.xpath(ozByLoginElementsPage.emailLoginTabLocator)).click();

        driver.findElement(By.xpath(ozByLoginElementsPage.emailFieldLocator)).sendKeys("user@tut.by");
        driver.findElement(By.xpath(ozByLoginElementsPage.passwordFieldLocator)).sendKeys("12345");
        driver.findElement(By.xpath(ozByLoginElementsPage.loginWithEmailPasswordButtonLocator)).click();
        Thread.sleep(1000);

        String expectedWrongUserDataWarning = "Адрес электронной почты не зарегистрирован. "+"Зарегистрироваться";
        String actualWrongUserDataWarning = driver.findElement(By.xpath(ozByLoginElementsPage.notRegisteredEmailLocator)).getText();

        Assertions.assertEquals(expectedWrongUserDataWarning, actualWrongUserDataWarning);

        Thread.sleep(2000);
        driver.quit();
    }
}
