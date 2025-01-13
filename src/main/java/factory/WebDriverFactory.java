package factory;

import exceptions.BrowserNotFoundException;
import factory.settings.ChromeSettings;
import factory.settings.FirefoxSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

public class WebDriverFactory {

    private final String browserName = System.getProperty("browser.name");

    public WebDriver create() {
        return switch (browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver((ChromeOptions) new ChromeSettings().settings());
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver((FirefoxOptions) new FirefoxSettings().settings());
            }
            default -> throw new BrowserNotFoundException();
        };
    }
}
