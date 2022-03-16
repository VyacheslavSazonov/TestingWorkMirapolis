package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverRunner {

    private static WebDriver instance;
    private static final String PATH_TO_DRIVER = "./src/main/resources/chromedriver.exe";
    private static final String WEB_DRIVER_NAME = "webdriver.chrome.driver";
    public static final String URL = "https://lmslite47vr.demo.mirapolis.ru/mira";

    public static WebDriver getDriver() {
        if (instance == null) {
            System.setProperty(WEB_DRIVER_NAME,
                    PATH_TO_DRIVER);
            instance = new ChromeDriver();
            instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            instance.manage().window().maximize();
            instance.get(URL);
        }
        return instance;
    }
}
