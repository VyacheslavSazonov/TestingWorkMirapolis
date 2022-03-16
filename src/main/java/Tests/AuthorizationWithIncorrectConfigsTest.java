package Tests;

import Core.WebDriverRunner;
import Pages.LoginPage;
import Pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationWithIncorrectConfigsTest extends BaseTest {

    private final String USER = "";
    private final String PASSWORD = "";
    private final String EXPECTED_ALERT_TEXT = "Неверные данные для авторизации.";

    @Test(description = "Проверка авторизации с некорректными логином и паролем")
    public void authorizationWithIncorrectConfigsTest() {
        LoginPage loginPage = new LoginPage(WebDriverRunner.getDriver());
        loginPage.authorizationWithIncorrectConfigsMethod(USER, PASSWORD);
        Assert.assertEquals(WebDriverRunner.getDriver().switchTo().alert().getText(), EXPECTED_ALERT_TEXT);
    }
}

