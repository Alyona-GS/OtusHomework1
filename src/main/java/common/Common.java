package common;

import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Common {
    protected WebDriver driver;
    WebDriverFactory factory = new WebDriverFactory();
    protected Waiters waiters;

    public Common() {
        this.driver = factory.create();
        this.waiters = new Waiters(driver);
        PageFactory.initElements(driver, this);
    }
}
