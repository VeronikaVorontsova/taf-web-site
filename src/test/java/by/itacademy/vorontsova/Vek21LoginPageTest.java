package by.itacademy.vorontsova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vek21LoginPageTest {
    @Test //Test1 - All fields are empty
    public void testLoginEmptyFields() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage(driver);
        driver.get("https://www.21vek.by/");

        vek21LoginElementsPage.cookieRejectButton();
        vek21LoginElementsPage.accountButtonMain();
        vek21LoginElementsPage.accountEnterButton();
        vek21LoginElementsPage.popupLoginButton();

        Assertions.assertEquals(vek21LoginElementsPage.expectedEmailWarning, driver.findElement(By.xpath(vek21LoginElementsPage.emailEmptyErrorLocator)).getText());
        Assertions.assertEquals(vek21LoginElementsPage.expectedPasswordWarning, driver.findElement(By.xpath(vek21LoginElementsPage.passwordEmptyErrorLocator)).getText());

        Thread.sleep(2000);
        driver.quit();
    }

    @Test //Test2 - Email field is empty
    public void testLoginEmptyEmail() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage(driver);
        driver.get("https://www.21vek.by/");

        vek21LoginElementsPage.cookieRejectButton();
        vek21LoginElementsPage.accountButtonMain();
        vek21LoginElementsPage.accountEnterButton();
        vek21LoginElementsPage.emailField("user@tut.by");
        vek21LoginElementsPage.popupLoginButton();

        Assertions.assertEquals(vek21LoginElementsPage.expectedPasswordWarning, driver.findElement(By.xpath(vek21LoginElementsPage.passwordEmptyErrorLocator)).getText());

        Thread.sleep(2000);
        driver.quit();
    }

    @Test //Test3 - Password field is empty
    public void testLoginEmptyPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage(driver);
        driver.get("https://www.21vek.by/");

        vek21LoginElementsPage.cookieRejectButton();
        vek21LoginElementsPage.accountButtonMain();
        vek21LoginElementsPage.accountEnterButton();
        vek21LoginElementsPage.passwordField("12345");
        vek21LoginElementsPage.popupLoginButton();

        Assertions.assertEquals(vek21LoginElementsPage.expectedEmailWarning, driver.findElement(By.xpath(vek21LoginElementsPage.emailEmptyErrorLocator)).getText());

        Thread.sleep(3000);
        driver.quit();
    }

    @Test //Test 4 - User data is not correct
    public void testLoginWrongUserData() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage(driver);
        driver.get("https://www.21vek.by/");

        vek21LoginElementsPage.cookieRejectButton();
        vek21LoginElementsPage.accountButtonMain();
        vek21LoginElementsPage.accountEnterButton();

        vek21LoginElementsPage.emailField("user@tut.by");
        vek21LoginElementsPage.passwordField("12345");

        vek21LoginElementsPage.popupLoginButton();

        Assertions.assertEquals(vek21LoginElementsPage.expectedWrongUserDataWarning, driver.findElement(By.xpath(vek21LoginElementsPage.wrongPasswordLocator)).getText());

        Thread.sleep(3000);
        driver.quit();
    }
}

