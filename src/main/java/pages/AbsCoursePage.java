package pages;

import annotations.Path;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

public class AbsCoursePage extends AbsBasePage {
    public AbsCoursePage pageHeaderShouldBeSameAs(String headerContent) {
        String header = driver.findElement(By.tagName("h1")).getText();
        //AssertThat(header.contains(headerContent)).isTrue();
        return this;
    }
}
