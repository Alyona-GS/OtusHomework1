package pages;

import annotations.Path;
import org.openqa.selenium.WebDriver;

public class AbsBasePage<T> {
    private String baseUrl = System.getProperty("base.url");

    public AbsBasePage(WebDriver driver) {
        driver = ;
        baseUrl = baseUrl;
    }

   public T open() {
    String path = getPath();
    driver.get(baseUrl + path);

    return (T)this;
    }

    private String getPath() {
        Class<? extends AbsBasePage> clazz = this.getClass();

        if(clazz.isAnnotationPresent(Path.class)) {
            Path path = clazz.getDeclaredAnnotation(Path.class);
            return path.value();
        }
    }
}