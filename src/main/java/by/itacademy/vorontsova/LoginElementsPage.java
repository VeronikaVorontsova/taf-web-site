package by.itacademy.vorontsova;

public class LoginElementsPage {
    public String cookieRejectButtonLocator = "//*[@type='button' and contains(.,'Отклонить')]";
    public String accountButtonLocator = "//*[@class='userToolsText']";
    public String accountLoginButtonLocator = "//*[@type='button' and contains(.,'Войти')]";
    public String popupLoginButtonLocator = "//*[contains(@class, 'Button-module__buttonText') and contains(text(),'Войти')]";
    public String emailFieldLocator = "//input[@id='login-email']";
    public String passwordFieldLocator = "//*[@id=\"login-password\"]";
    public String emailEmptyErrorLocator = "//*[contains(@class, 'ErrorMessage-module__message') and contains(text(), 'Электронная почта не указана')]";
    public String passwordEmptyErrorLocator = "//*[contains(@class, 'ErrorMessage-module__message') and contains(text(), 'Пароль не указан')]";
    public String wrongPasswordLocator = "//*[contains(@class, 'styles_errorText__LEN7M')]";
//*[contains(text(), 'Неправильный пароль.') and contains(text(), 'Сбросить пароль?')]
}
