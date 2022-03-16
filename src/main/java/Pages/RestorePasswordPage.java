package Pages;

import Core.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

/**
 * Страница восстановления пароля
 */
public class RestorePasswordPage extends BasePage {

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Введите логин или email']")
    private WebElement emailOrLoginInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement sendRestoreInfoButton;

    @FindBy(xpath = "//table[@class='links-container']/descendant::div[contains (text(), 'Назад к входу в систему')]")
    private WebElement returnToLoginPageButton;

    public static String restorePasswordPageTitle = "Восстановление пароля";

    /**
     * Метод перехода на страницу авторизации
     *
     * @return - объект страницы авторизации
     */
    public LoginPage switchToLoginPageMethod() {
        new Actions(WebDriverRunner.getDriver()).click(returnToLoginPageButton)
                .pause(Duration.ofMillis(500)).build().perform();
        return new LoginPage(WebDriverRunner.getDriver());
    }
}
