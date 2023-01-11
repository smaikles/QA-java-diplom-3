package yandex.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {

    public static final String PATH_DRIVER_CHROME = "src/main/resources/driver/chromedriver.exe";
    public static final String PATH_DRIVER_YANDEX = "src/main/resources/driver/yandexdriver.exe";

    /**
     * метод которым можно выбрать активный браузер
     **/

    public static void setSettings() {
        Configuration.baseUrl = "https://stellarburgers.nomoreparties.site";
        Configuration.holdBrowserOpen = true;
        //Configuration.browser = "chrome";
        //Configuration.browser = "firefox";

        System.setProperty("webdriver.chrome.driver", PATH_DRIVER_YANDEX); //Для браузера Yandex
        WebDriverRunner.setWebDriver(new ChromeDriver());

    }
}



