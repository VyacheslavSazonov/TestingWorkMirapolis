package Tests;

import Core.WebDriverRunner;
import Pages.LoginPage;
import Pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest {

    @Test(description = "Проверка авторизации с корректными логином и паролем")
    public void authorizationTest() {
        LoginPage loginPage = new LoginPage(WebDriverRunner.getDriver());
        loginPage.authorizationMethod();
        Assert.assertEquals(WebDriverRunner.getDriver().getTitle(), MainPage.mainPageTitle);
    }
}
