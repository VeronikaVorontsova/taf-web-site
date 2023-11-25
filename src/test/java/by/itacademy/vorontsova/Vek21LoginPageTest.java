package by.itacademy.vorontsova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vek21LoginPageTest {
    @Test //Test1 - All fields are empty
    public void testLoginEmptyFields() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage(driver);
        driver.get("https://www.21vek.by/");
        driver.manage().window().maximize();

        vek21LoginElementsPage.clickCookieRejectButton();
        vek21LoginElementsPage.clickAccountButtonMain();
        vek21LoginElementsPage.clickAccountEnterButton();
        vek21LoginElementsPage.clickPopupLoginButton();

        Assertions.assertEquals(vek21LoginElementsPage.expectedEmailWarning, vek21LoginElementsPage.getTextEmailEmptyError());
        Assertions.assertEquals(vek21LoginElementsPage.expectedPasswordWarning, vek21LoginElementsPage.getTextPasswordEmptyError());

        Thread.sleep(2000);
        driver.quit();
    }

    @Test //Test2 - Email field is empty
    public void testLoginEmptyEmail() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage(driver);
        driver.get("https://www.21vek.by/");

        vek21LoginElementsPage.clickCookieRejectButton();
        vek21LoginElementsPage.clickAccountButtonMain();
        vek21LoginElementsPage.clickAccountEnterButton();
        vek21LoginElementsPage.sendKeysEmailField();
        vek21LoginElementsPage.clickPopupLoginButton();

        Assertions.assertEquals(vek21LoginElementsPage.expectedPasswordWarning, vek21LoginElementsPage.getTextPasswordEmptyError());

        Thread.sleep(2000);
        driver.quit();
    }

    @Test //Test3 - Password field is empty
    public void testLoginEmptyPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage(driver);
        driver.get("https://www.21vek.by/");

        vek21LoginElementsPage.clickCookieRejectButton();
        vek21LoginElementsPage.clickAccountButtonMain();
        vek21LoginElementsPage.clickAccountEnterButton();
        vek21LoginElementsPage.sendKeysPasswordField();
        vek21LoginElementsPage.clickPopupLoginButton();

        Assertions.assertEquals(vek21LoginElementsPage.expectedEmailWarning, vek21LoginElementsPage.getTextEmailEmptyError());

        Thread.sleep(3000);
        driver.quit();
    }

    @Test //Test 4 - User data is not correct
    public void testLoginWrongUserData() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Vek21LoginElementsPage vek21LoginElementsPage = new Vek21LoginElementsPage(driver);
        driver.get("https://www.21vek.by/");

        vek21LoginElementsPage.clickCookieRejectButton();
        vek21LoginElementsPage.clickAccountButtonMain();
        vek21LoginElementsPage.clickAccountEnterButton();

        vek21LoginElementsPage.sendKeysEmailField();
        vek21LoginElementsPage.sendKeysPasswordField();

        vek21LoginElementsPage.clickPopupLoginButton();

        Assertions.assertEquals(vek21LoginElementsPage.expectedWrongUserDataWarning, vek21LoginElementsPage.getTextWrongPassword());

        Thread.sleep(3000);
        driver.quit();
    }
}

