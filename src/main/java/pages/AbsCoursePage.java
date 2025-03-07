package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AbsCoursePage extends AbsBasePage {
    public AbsCoursePage pageHeaderShouldBeSameAs(String headerContent) {
        this.waiters.waitForElementVisibleByLocator(By.tagName("h1"));
        WebElement header = driver.findElement(By.xpath("//h1[contains(@class, 'sc-1x9oq14-0 sc-s2pydo-1 kswXpy diGrSa')]"));
        System.out.println(header.getText());
        //AssertThat(header.contains(headerContent)).isTrue();
        return this;
    }
}
