package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    @Name("Превью видео при наводке в центр видео")
    @Parametrizated("координаты центра", "координаты угла")
    public static void main() {
        driver.get("https://www.youtube.com/");
        ElementsCollection videos = Selenide.$$(By.tagName("ytd-rich-item-renderer tag"));
        video.getCoord(videos.stream().findFirst());
        System.out.println(video.size());
        for (int i = 0; i < 2; i++) {
            //передвинуть курсор в центр видео (и тест на край потом), и потом короткие
            video.stream().findFirst();.get().
                    screenshoots = video.stream().findFirst().
        }

    }

    @Test
    @Name("Превью видео при наводке в углу видео")

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}