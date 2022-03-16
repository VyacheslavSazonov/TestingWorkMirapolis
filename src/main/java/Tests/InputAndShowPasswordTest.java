package Tests;

import Core.WebDriverRunner;
import Pages.BasePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputAndShowPasswordTest extends BaseTest {

    private final String TEST_PASSWORD = "password1234";

    @Test(description = "Проверка отображения введенного пароля после нажатия кнопки \"Показать пароль\"")
    public void inputAndShowPasswordTest() {
        LoginPage loginPage = new LoginPage(WebDriverRunner.getDriver());
        Assert.assertEquals(loginPage.inputAndShowPasswordMethod(TEST_PASSWORD), TEST_PASSWORD);
    }
}
