package Pages;

import Core.PropertiesReader;
import Core.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

/**
 * Страница авторизации
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Введите ваш логин']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@placeholder='Введите ваш пароль']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//table[@class='links-container']/descendant::div[contains (text(), 'Забыли пароль')]")
    private WebElement restorePasswordButton;

    @FindBy(xpath = "//button[@id='show_password']")
    private WebElement showPasswordButton;

    public static String loginPageTitle = "Авторизация";

    private static final Path PROPERTIES = Paths.get("src/main/resources/auth_info.properties");
    PropertiesReader propertiesReader = PropertiesReader.readProperties(PROPERTIES);


    /**
     * Метод авторизации на странице входа
     *
     * @return - объект Главной страницы
     */
    public MainPage authorizationMethod() {
        new Actions(WebDriverRunner.getDriver()).sendKeys(loginInput, propertiesReader.getUser())
                .sendKeys(passwordInput, propertiesReader.getPassword())
                .click(loginButton).pause(Duration.ofMillis(2500)).build().perform();
        return new MainPage(WebDriverRunner.getDriver());
    }

    /**
     * Метод перехода на страницу восстановления пароля
     *
     * @return - объект страницы для восстановления пароля
     */
    public RestorePasswordPage switchToRestorePasswordPageMethod() {
        new Actions(WebDriverRunner.getDriver()).click(restorePasswordButton).build().perform();
        return new RestorePasswordPage(WebDriverRunner.getDriver());
    }

    /**
     * Метод ввода пароля и нажатия на кнопку "Показать пароль"
     *
     * @param password
     * @return - объект страницы авторизации с отображенным паролем
     */
    public String inputAndShowPasswordMethod(String password) {
        new Actions(WebDriverRunner.getDriver())
                .sendKeys(passwordInput, password)
                .click(showPasswordButton).build().perform();
        return passwordInput.getDomProperty("value");
    }

    /**
     * Метод ввода пароля и нажатия на кнопку "Показать пароль"
     *
     * @return - объект страницы авторизации с отображенным паролем
     */
    public void authorizationWithIncorrectConfigsMethod(String user, String password) {
        new Actions(WebDriverRunner.getDriver()).sendKeys(loginInput, user)
                .sendKeys(passwordInput, password)
                .click(loginButton).build().perform();
    }
}
