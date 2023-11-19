package by.itacademy.vorontsova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OzByLoginPageTest {
    @Test //Test 1 - Empty Fields
    public void testOzLoginEmptyFields() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        OzByLoginElementsPage ozByLoginElementsPage = new OzByLoginElementsPage(driver);
        driver.get("https://oz.by/");

        ozByLoginElementsPage.clickLoginButton();
        ozByLoginElementsPage.clickEmailLoginTab();
        ozByLoginElementsPage.loginWithEmailPasswordButton();

        Assertions.assertEquals(ozByLoginElementsPage.expectedEmptyEmailWarning, driver.findElement(By.xpath(ozByLoginElementsPage.emptyEmailWarningLocator)).getText());

        Thread.sleep(2000);
        driver.quit();
    }
    @Test //Test 2 - Empty email field
    public void testOzLoginEmptyEmailField() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        OzByLoginElementsPage ozByLoginElementsPage = new OzByLoginElementsPage(driver);
        driver.get("https://oz.by/");

        driver.findElement(By.xpath(ozByLoginElementsPage.loginButtonLocator)).click();
        driver.findElement(By.xpath(ozByLoginElementsPage.emailLoginTabLocator)).click();
        driver.findElement(By.xpath(ozByLoginElementsPage.passwordFieldLocator)).sendKeys("12345");
        driver.findElement(By.xpath(ozByLoginElementsPage.loginWithEmailPasswordButtonLocator)).click();

        Assertions.assertEquals(ozByLoginElementsPage.expectedEmptyEmailWarning, driver.findElement(By.xpath(ozByLoginElementsPage.emptyEmailWarningLocator)).getText());

        Thread.sleep(2000);
        driver.quit();
    }
    @Test //Test 3 - Empty password field
    public void testOzLoginEmptyPasswordField() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        OzByLoginElementsPage ozByLoginElementsPage = new OzByLoginElementsPage(driver);
        driver.get("https://oz.by/");

        ozByLoginElementsPage.clickLoginButton();
        ozByLoginElementsPage.clickEmailLoginTab();
        ozByLoginElementsPage.sendKeysEmailField("user@tut.by");
        ozByLoginElementsPage.loginWithEmailPasswordButton();

        Assertions.assertEquals(ozByLoginElementsPage.expectedEmptyPasswordWarning, driver.findElement(By.xpath(ozByLoginElementsPage.emptyPasswordWarningLocator)).getText());

        Thread.sleep(2000);
        driver.quit();
    }
    @Test //Test 4 - Wrong user data
    public void testOzLoginWrongUserData() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        OzByLoginElementsPage ozByLoginElementsPage = new OzByLoginElementsPage(driver);
        driver.get("https://oz.by/");

        ozByLoginElementsPage.clickLoginButton();
        ozByLoginElementsPage.clickEmailLoginTab();
        ozByLoginElementsPage.sendKeysEmailField("user@tut.by");
        ozByLoginElementsPage.sendKeysPasswordField("12345");
        ozByLoginElementsPage.loginWithEmailPasswordButton();

        Assertions.assertEquals(ozByLoginElementsPage.expectedWrongUserDataWarning, driver.findElement(By.xpath(ozByLoginElementsPage.notRegisteredEmailLocator)).getText());

        Thread.sleep(2000);
        driver.quit();
    }
}
