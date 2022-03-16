package Tests;

import Core.WebDriverRunner;
import Pages.LoginPage;
import Pages.RestorePasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchToRestorePasswordPageTest extends BaseTest {

    @Test(description = "Проверка перехода на страницу Восстановления пароля")
    public void restorePasswordTest() {
        LoginPage loginPage = new LoginPage(WebDriverRunner.getDriver());
        loginPage.switchToRestorePasswordPageMethod();
        Assert.assertEquals(WebDriverRunner.getDriver().getTitle(), RestorePasswordPage.restorePasswordPageTitle);
    }
}
