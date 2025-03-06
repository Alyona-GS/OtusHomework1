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
        findElement(By.xpath("//*[contains(@class, 'sticky-banner__close js-sticky-banner-close')]")).click();
        findElement(By.xpath("//button[contains(@class, 'sc-9a4spb-0 ckCZjI')]")).click();
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
        List<String> visibleCourseNames = driver.findElements(By.tagName("h6")).stream().map(WebElement::getText).toList();
        boolean courseNotVisible = true;
        while (buttonShowMore.isDisplayed() && (courseNotVisible)) {
            for (String course: visibleCourseNames) {
                if (course.equals(courseName)) {
                    courseNotVisible = false;
                    break;
                }
            }
            if (courseNotVisible) {
                buttonShowMore.click();
            } else {
                break;
            }
        }
        return this;
    }

    public AbsCoursePage clickCoursePlate(String courseName) {
        List<WebElement> plates = driver.findElements(By.xpath("//a[contains(@href, '/lessons/')]"));
        plates.forEach((plate) -> {
            if (plate.getText().contains(courseName) && plate.isDisplayed()) {
                plate.click();
            }
        });
        return new AbsCoursePage();
    }

    public CoursesCataloguePage findCourses() {
        List<WebElement> plates = driver.findElements(By.xpath("//a[contains(@href, '/lessons/')]"));
        WebElement buttonShowMore = findElement(By.xpath("//*[contains(@class, 'sc-mrx253-0 enxKCy sc-prqxfo-0 cXVWAS')]"));
        while (buttonShowMore.isDisplayed()) {
                waiters.waitForElementVisibleElement(buttonShowMore);
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
    };

    public CoursesCataloguePage checkCatalogueUrl() {
        if (category != null) {
            String param = "programming";
            switch (category) {
                case "Программирование":
                    param = "programming";
                    break;
                case "Архитектура":
                    param = "architecture";
                    break;
                case "Data Science":
                    param = "data-science";
                    break;
                case "Инфраструктура":
                    param = "operations";
                    break;
                case "GameDev":
                    param = "gamedev";
                    break;
                case "Безопасность":
                    param = "information-security-courses";
                    break;
                case "Управление":
                    param = "marketing-business";
                    break;
                case "Аналитика и анализ":
                    param = "analytics";
                    break;
                case "Тестирование":
                    param = "testing";
                    break;
                case "Корпоративные курсы":
                    param = "corporate";
                    break;
                case "IT без программирования":
                    param = "it-bez-programmirovanija";
                    break;
                case "OTUS Kids":
                    param = "kids";
                    break;
                case "Специализации":
                    param = "specialization";
                    break;
            }
            String urlShouldBe = String.format("https://otus.ru/catalog/courses?categories=%s", param);
            String urlBrowser = driver.getCurrentUrl();
            //assertThat(urlBrowser).isEquals(urlShouldBe); //проверить потом
        }
        return this;
    }
}
