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
        driver.manage().window().maximize();

        ozByLoginElementsPage.clickLoginButton();
        ozByLoginElementsPage.clickEmailLoginTab();
        ozByLoginElementsPage.clickLoginWithEmailPasswordButton();

        Assertions.assertEquals(ozByLoginElementsPage.expectedEmptyEmailWarning, ozByLoginElementsPage.getTextEmptyEmailWarning());

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

        Assertions.assertEquals(ozByLoginElementsPage.expectedEmptyEmailWarning, ozByLoginElementsPage.getTextEmptyEmailWarning());

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
        ozByLoginElementsPage.clickLoginWithEmailPasswordButton();

        Assertions.assertEquals(ozByLoginElementsPage.expectedEmptyPasswordWarning, ozByLoginElementsPage.getTextEmptyPasswordWarning());

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
        ozByLoginElementsPage.clickLoginWithEmailPasswordButton();

        Assertions.assertEquals(ozByLoginElementsPage.expectedWrongUserDataWarning, ozByLoginElementsPage.getTextNotRegisteredEmail());

        Thread.sleep(2000);
        driver.quit();
    }
}
