package Tests;

import Core.WebDriverRunner;
import Pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

/** Базовый класс для тестов*/
public class BaseTest {

    /** Метод закрывающий браузер после теста*/
    @AfterSuite
    public void quitBrowser() {
        WebDriverRunner.getDriver().close();
    }
}
