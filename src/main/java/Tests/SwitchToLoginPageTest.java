package Tests;

import Core.WebDriverRunner;
import Pages.LoginPage;
import Pages.RestorePasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchToLoginPageTest extends BaseTest {

    @Test(description = "Проверка перехода на страницу авторизации со страницы Восстановления пароля")
    public void switchToLoginPageTest() {
        LoginPage loginPage = new LoginPage(WebDriverRunner.getDriver());
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(WebDriverRunner.getDriver());
        restorePasswordPage.switchToLoginPageMethod();
        Assert.assertEquals(WebDriverRunner.getDriver().getTitle(), LoginPage.loginPageTitle);
    }
}
