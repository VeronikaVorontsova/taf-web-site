package by.itacademy.vorontsova;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class KvitkiLoginElementsPage {
    private String acceptCookieLocator = "//*[contains(text(), 'Разрешить все cookie-файлы и принять Политику обработки персональных данных')]";
    private String popupBannerCloseButtonLocator = "//div[contains(@class, 'popupbanner_close')]";
    private String userAccountButtonLocator = "//*[contains(@class, 'user-account-icon')]";
    private String loginPopupLocator = "//div[contains(@class, 'mat-mdc-dialog-surface mdc-dialog__surface')]";
    private String emailInputLocator = "//input[contains(@type, 'email')]";
    private String passwordInputLocator = "//input[contains(@type, 'password')]";
    private String emptyEmailWarningLocator = "//*[contains(text(), 'Пожалуйста, заполните поле (Эл. почта)')]";
    private String emptyPasswordWarningLocator = "//*[contains(text(), 'Пожалуйста, заполните поле (Пароль)')]";
    private String wrongEmailFormatWarningLocator = "//*[contains(text(), 'Пожалуйста, введите адрес электронной почты в правильном формате: name@example.com')]";
    private String userNotExistsWarningLocator = "//div[contains(@class, 'info-text')]";
    private String popupLoginButtonLocator = "//button[contains(text(), 'Войти')]";

    public String expectedEmptyEmailWarning = "Пожалуйста, заполните поле (Эл. почта)";
    public String expectedEmptyPasswordWarning = "Пожалуйста, заполните поле (Пароль)";
    public String expectedWrongEmailFormatWarning = "Пожалуйста, введите адрес электронной почты в правильном формате: name@example.com";
    public String expectedUserNotExistsWarning = "Электронная почта или пароль недействительны. Система была обновлена, и в связи с этим мы перешли на вход по электронной почте.";


    WebDriver driver;
    public KvitkiLoginElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookieButton() {
        driver.findElement(By.xpath(acceptCookieLocator)).click();
    }

    public void closeBannerPopup() {
        try {
            if (driver.findElement(By.xpath(popupBannerCloseButtonLocator)).isDisplayed()) {
                 driver.findElement(By.xpath(popupBannerCloseButtonLocator)).click();
            }
        } catch(NoSuchElementException e){
            System.out.println("Popup is not displayed");
        }
    }
    public void clickUserAccountButton() {
        driver.findElement(By.xpath(userAccountButtonLocator)).click();
    }
    public boolean checkLoginPopup() {
        return driver.findElement(By.xpath(loginPopupLocator)).isDisplayed();
    }
    public void clickEmailInput() {
        driver.findElement(By.xpath(emailInputLocator)).click();
    }
    public void clickPasswordInput() {
        driver.findElement(By.xpath(passwordInputLocator)).click();
    }
    public String getTextEmailEmptyWarning() {
        return driver.findElement(By.xpath(emptyEmailWarningLocator)).getText();
    }
    public String getTextPasswordEmptyWarning() {
        return driver.findElement(By.xpath(emptyPasswordWarningLocator)).getText();
    }

    public void sendKeysIncorrectEmail() {
        driver.findElement(By.xpath(emailInputLocator)).sendKeys("123");
    }

    public String getTextWrongEmailFormatWarning() {
       return driver.findElement(By.xpath(wrongEmailFormatWarningLocator)).getText();
    }

    public void sendKeysCorrectEmail() {
        driver.findElement(By.xpath(emailInputLocator)).sendKeys("123@gmail.com");
    }

    public void sendKeysCorrectPassword() {
        driver.findElement(By.xpath(passwordInputLocator)).sendKeys("123");
    }

    public void clickLoginButton()  {
        driver.findElement(By.xpath(popupLoginButtonLocator)).click();
    }

    public String getTextUserNotExists() {
        return driver.findElement(By.xpath(userNotExistsWarningLocator)).getText();
    }

}