package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/** Базовая страница для UI страниц*/
public class BasePage {

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
