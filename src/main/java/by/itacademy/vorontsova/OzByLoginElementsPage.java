package by.itacademy.vorontsova;

public class OzByLoginElementsPage {
    String loginButtonLocator = "//*[contains(@class, 'user-bar__title') and contains(text(), 'Войти')]";
    String emailLoginTabLocator = "//*[contains(@class, 'i-nav-tabs__link') and contains(text(), 'Электронная почта')]";
    String emailFieldLocator = "//input[@placeholder='Электронная почта']";
    String passwordFieldLocator = "//input[@placeholder='Пароль']";
    String loginWithEmailPasswordButtonLocator = "//*[@type = \"submit\" and contains(text(), 'Войти')]";
    String emptyEmailWarningLocator = "//*[contains(text(), 'Введите адрес электронной почты')]";
    String emptyPasswordWarningLocator = "//*[contains(text(), 'Введите пароль')]";
    String notRegisteredEmailLocator = "//*[contains(@class, 'i-popover__main') and contains(., 'Адрес электронной почты не зарегистрирован. ')]";
}
