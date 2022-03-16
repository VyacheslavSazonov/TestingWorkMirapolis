package Pages;

import org.openqa.selenium.WebDriver;

/** Главная страница*/
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static String mainPageTitle = "Главная страница";
}
