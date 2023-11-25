package by.itacademy.vorontsova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class KvitkiLoginPageTest {
    @Test
    public void testLoginEmptyEmailField() {
        WebDriver driver = new ChromeDriver();
        KvitkiLoginElementsPage kvitkiLoginElementsPage = new KvitkiLoginElementsPage(driver);
        driver.get("https://www.kvitki.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        kvitkiLoginElementsPage.acceptCookieButton();
        kvitkiLoginElementsPage.closeBannerPopup();
        kvitkiLoginElementsPage.clickUserAccountButton();
        Assertions.assertTrue(kvitkiLoginElementsPage.checkLoginPopup());
        kvitkiLoginElementsPage.clickEmailInput();
        kvitkiLoginElementsPage.clickPasswordInput();

        Assertions.assertEquals(kvitkiLoginElementsPage.expectedEmptyEmailWarning, kvitkiLoginElementsPage.getTextEmailEmptyWarning());

        driver.quit();
    }

    @Test
    public void testLoginEmptyPasswordField() {
        WebDriver driver = new ChromeDriver();
        KvitkiLoginElementsPage kvitkiLoginElementsPage = new KvitkiLoginElementsPage(driver);
        driver.get("https://www.kvitki.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        kvitkiLoginElementsPage.acceptCookieButton();
        kvitkiLoginElementsPage.closeBannerPopup();
        kvitkiLoginElementsPage.clickUserAccountButton();
        Assertions.assertTrue(kvitkiLoginElementsPage.checkLoginPopup());
        kvitkiLoginElementsPage.clickPasswordInput();
        kvitkiLoginElementsPage.clickEmailInput();

        Assertions.assertEquals(kvitkiLoginElementsPage.expectedEmptyPasswordWarning, kvitkiLoginElementsPage.getTextPasswordEmptyWarning());

        driver.quit();
    }

    @Test
    public void testLoginEmailIncorrect() {
        WebDriver driver = new ChromeDriver();
        KvitkiLoginElementsPage kvitkiLoginElementsPage = new KvitkiLoginElementsPage(driver);
        driver.get("https://www.kvitki.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        kvitkiLoginElementsPage.acceptCookieButton();
        kvitkiLoginElementsPage.closeBannerPopup();
        kvitkiLoginElementsPage.clickUserAccountButton();
        Assertions.assertTrue(kvitkiLoginElementsPage.checkLoginPopup());
        kvitkiLoginElementsPage.sendKeysIncorrectEmail();
        kvitkiLoginElementsPage.clickPasswordInput();
        Assertions.assertEquals(kvitkiLoginElementsPage.expectedWrongEmailFormatWarning, kvitkiLoginElementsPage.getTextWrongEmailFormatWarning());

        driver.quit();
    }

    @Test
    public void testLoginUserNotExists() {
        WebDriver driver = new ChromeDriver();
        KvitkiLoginElementsPage kvitkiLoginElementsPage = new KvitkiLoginElementsPage(driver);
        driver.get("https://www.kvitki.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        kvitkiLoginElementsPage.acceptCookieButton();
        kvitkiLoginElementsPage.closeBannerPopup();
        kvitkiLoginElementsPage.clickUserAccountButton();
        Assertions.assertTrue(kvitkiLoginElementsPage.checkLoginPopup());
        kvitkiLoginElementsPage.sendKeysCorrectEmail();
        kvitkiLoginElementsPage.sendKeysCorrectPassword();
        kvitkiLoginElementsPage.clickLoginButton();
        Assertions.assertEquals(kvitkiLoginElementsPage.expectedUserNotExistsWarning, kvitkiLoginElementsPage.getTextUserNotExists());

        driver.quit();
    }
}
