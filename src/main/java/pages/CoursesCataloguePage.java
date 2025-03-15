package pages;

import annotations.Path;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

@Path("/catalog/courses")
public class CoursesCataloguePage extends AbsBasePage<CoursesCataloguePage> {
    private String category;
    private List<String>  minDateCourse;
    private List<String>  maxDateCourse;

    public CoursesCataloguePage open() {

        String path = getPath();
        driver.get(baseUrl + path);
        driver.manage().window().maximize();
        By byBanner = By.xpath("//*[contains(@class, 'sticky-banner__close js-sticky-banner-close')]");
        By byBanner2 = By.xpath("//button[contains(@class, 'sc-9a4spb-0 ckCZjI')]");

        this.waiters.waitForElementVisible(driver.findElement(byBanner));
        this.waiters.waitForElementVisible(driver.findElement(byBanner2));

        findElement(byBanner).click();
        findElement(byBanner2).click();
        return this;
    }

    public CoursesCataloguePage(WebDriver driver) {
        super(driver);
    }

    public CoursesCataloguePage(String category, WebDriver driver) {
        super(driver);
        this.category = category;
    }

    public CoursesCataloguePage findCoursePlateByCourseName(String courseName) {
        WebElement buttonShowMore = findElement(By.xpath("//*[contains(@class, 'sc-mrx253-0 enxKCy sc-prqxfo-0 cXVWAS')]"));
        boolean courseNotVisible = true;
        while (courseNotVisible) {
            this.waiters.waitForElementVisible(driver.findElement(By.tagName("h6")));
            List<String> visibleCourseNames = driver.findElements(By.tagName("h6")).stream().map(WebElement::getText).toList();
            for (String course: visibleCourseNames) {
                if (course.equals(courseName)) {
                    courseNotVisible = false;
                    break;
                }
            }
            if (courseNotVisible) {
                this.waiters.waitForElementToBeClickable(buttonShowMore);
                buttonShowMore.click();
            } else {
                break;
            }
        }
        return this;
    }

    public AbsCoursePage clickCoursePlate(String courseName) {
        WebElement plate = driver.findElement(By.xpath("//section/div/div/a[contains(@class, 'sc-zzdkm7-0') and contains(.//h6, '"+courseName+"')]"));
        this.waiters.waitForElementToBeClickable(plate);
        plate.click();
        return new AbsCoursePage(driver);
    }

    public CoursesCataloguePage findMinMaxDateCourses() {
        WebElement buttonShowMore = findElement(By.xpath("//*[contains(@class, 'sc-mrx253-0 enxKCy sc-prqxfo-0 cXVWAS')]"));
        while (this.waiters.waitForElementToBeClickable(buttonShowMore)) {
                buttonShowMore.click();
        }
        List<String> plates = driver
            .findElements(By.xpath("//section/div/div/a[contains(@class, 'sc-zzdkm7-0')]"))
            .stream().map(WebElement::getText).toList();
//        minDateCourse = plates.reduce((a, b) -> {
//            String dataA = Arrays.stream(a.split("/n")).toList().get(3);
//            System.out.println(dataA);
//            String dataB = Arrays.stream(b.split("/n")).toList().get(3);
//            return Date.valueOf(dataA) - Date.valueOf(dataB);
//        });
//        maxDateCourse = plates.reduce((a, b) -> {
//            String dataA = Arrays.stream(a.split("/n")).toList().get(3);
//            System.out.println(dataA);
//            String dataB = Arrays.stream(b.split("/n")).toList().get(3);
//            return Date.valueOf(dataA) - Date.valueOf(dataB);
//        });
        return this;
    }

    public void nameAndDateOnMinMaxPlateCoursesIsRight() throws IOException {
        Document document = Jsoup.connect("https://otus.ru").get();
        minDateCourse.get(4);
        maxDateCourse.get(2);
//        document.
    }

    public CoursesCataloguePage checkCatalogueUrl() {
        if (category != null) {
            String param = switch (category) {
							case "Программирование" -> "programming";
							case "Архитектура" -> "architecture";
							case "Data Science" -> "data-science";
							case "Инфраструктура" -> "operations";
							case "GameDev" -> "gamedev";
							case "Безопасность" -> "information-security-courses";
							case "Управление" -> "marketing-business";
							case "Аналитика и анализ" -> "analytics";
							case "Тестирование" -> "testing";
							case "Корпоративные курсы" -> "corporate";
							case "IT без программирования" -> "it-bez-programmirovanija";
							case "OTUS Kids" -> "kids";
							case "Специализации" -> "specialization";
							default -> "programming";
						};
					String urlShouldBe = String.format("https://otus.ru/catalog/courses?categories=%s", param);
          String urlBrowser = driver.getCurrentUrl();
            //assertThat(urlBrowser).isEquals(urlShouldBe); //проверить потом
        }
        return this;
    }
}
