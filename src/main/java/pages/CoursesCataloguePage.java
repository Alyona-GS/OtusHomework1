package pages;

import annotations.Path;
import models.Course;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Path("/catalog/courses")
public class CoursesCataloguePage extends AbsBasePage {
    private String category;

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

    public CoursesCataloguePage() {
        super();
    }

    public CoursesCataloguePage(String category) {
        super();
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
        this.waiters.waitForElementVisible(driver.findElement(By.xpath("//div/a[last()]")));
        List<WebElement> plates = driver.findElements(By.xpath("//div/a[contains(@href, '/lessons/')]"));
        List<String> plateTexts = plates.stream().map(WebElement::getText).toList();
        plateTexts.forEach((i) -> System.out.println("qwe" + i));
        plates.forEach((plate) -> {
            String text = plate.getText();
            if (text.contains(courseName)) {
                this.waiters.waitForElementToBeClickable(plate);
                plate.click();
            }
        });
        return new AbsCoursePage();
    }

    public CoursesCataloguePage findCourses() {
        List<WebElement> plates = driver.findElements(By.xpath("//a[contains(@href, '/lessons/')]"));
        WebElement buttonShowMore = findElement(By.xpath("//*[contains(@class, 'sc-mrx253-0 enxKCy sc-prqxfo-0 cXVWAS')]"));
        while (buttonShowMore.isDisplayed()) {
            this.waiters.waitForElementToBeClickable(buttonShowMore);
                buttonShowMore.click();
        }
        List<Course> courses = new ArrayList<>();
        plates.forEach((plate) -> {
            String plateText = plate.getText();
            System.out.println(plateText);
            String[] splittedText = plateText.split("/n");
            courses.add(new Course(splittedText[0], Date.valueOf(splittedText[2])));
        });
//        Date youngestCourseDate = courses.stream().reduce();
//        Date oldestCourseDate = courses.stream().reduce();
//        Course[] youngestCourses = courses.stream().reduce();
//        Course[] oldestCourses = courses.stream().reduce();

        //взять курсы по порядку, проверить, что наверху нужные курсы, первые и также внизу
        List<String> visibleCourses = driver.findElements(By.tagName("h6")).stream().map(WebElement::getText).toList();
        return this;
    }
    public CoursesCataloguePage nameAndDateOnPlateIsRight() {

        return this;
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
