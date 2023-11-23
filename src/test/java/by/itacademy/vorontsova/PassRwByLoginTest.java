package by.itacademy.vorontsova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PassRwByLoginTest {
    @Test //Test 1 - empty fields
    public void testLoginEmptyFields() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        PassRwByElementsPage passRwByElementsPage = new PassRwByElementsPage(driver);
        driver.get("https://pass.rw.by/ru/");
        driver.manage().window().maximize();

        passRwByElementsPage.clickProfileButton();
        Assertions.assertTrue(passRwByElementsPage.checkAuthorizationPopupIsDisplayed());
        passRwByElementsPage.clickLoginButton();
        Assertions.assertEquals(passRwByElementsPage.expectedEmptyInputWarning, passRwByElementsPage.getTextEmailEmptyWarning());
        Assertions.assertEquals(passRwByElementsPage.expectedEmptyInputWarning, passRwByElementsPage.getTextPasswordEmptyWarning());

        driver.quit();
    }

    @Test //Test 2 - empty email field
    public void testLoginEmptyEmailField() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        PassRwByElementsPage passRwByElementsPage = new PassRwByElementsPage(driver);
        driver.get("https://pass.rw.by/ru/");
        driver.manage().window().maximize();

        passRwByElementsPage.clickProfileButton();
        Assertions.assertTrue(passRwByElementsPage.checkAuthorizationPopupIsDisplayed());
        passRwByElementsPage.sendKeysPasswordInput();
        passRwByElementsPage.clickLoginButton();

        Assertions.assertEquals(passRwByElementsPage.expectedEmptyInputWarning, passRwByElementsPage.getTextEmailEmptyWarning());

        driver.quit();
    }

    @Test //Test 3 - empty password field
    public void testLoginEmptyPasswordField() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        PassRwByElementsPage passRwByElementsPage = new PassRwByElementsPage(driver);
        driver.get("https://pass.rw.by/ru/");
        driver.manage().window().maximize();

        passRwByElementsPage.clickProfileButton();
        Assertions.assertTrue(passRwByElementsPage.checkAuthorizationPopupIsDisplayed());
        passRwByElementsPage.sendKeysEmailInput();
        passRwByElementsPage.clickLoginButton();

        Assertions.assertEquals(passRwByElementsPage.expectedEmptyInputWarning, passRwByElementsPage.getTextPasswordEmptyWarning());

        driver.quit();
    }

    @Test //Test 4 - wrong user data
    public void testLoginWrongUserData() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        PassRwByElementsPage passRwByElementsPage = new PassRwByElementsPage(driver);
        driver.get("https://pass.rw.by/ru/");
        driver.manage().window().maximize();

        passRwByElementsPage.clickProfileButton();
        Assertions.assertTrue(passRwByElementsPage.checkAuthorizationPopupIsDisplayed());
        passRwByElementsPage.sendKeysEmailInput();
        passRwByElementsPage.sendKeysPasswordInput();
        passRwByElementsPage.clickLoginButton();

        Assertions.assertEquals(passRwByElementsPage.expectedWrongUserWarning, passRwByElementsPage.getTextWrongUserWarning());

        driver.quit();
    }

}

