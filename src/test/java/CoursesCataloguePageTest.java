import org.junit.jupiter.api.Test;
import pages.CoursesCataloguePage;

public class CoursesCataloguePageTest {

    CoursesCataloguePage coursesCataloguePage = new CoursesCataloguePage();

    @Test
    public void checkCourseOpenedByCoursePlateTest() {
        coursesCataloguePage
                .open()
                .findCoursePlateByCourseName("Symfony Framework")
                .clickCoursePlate("Symfony Framework");
                //.pageHeaderShouldBeSameAs("Symfony Framework");
    }

    @Test
    public void checkNameAndDateOnCoursePlateTest() {
        coursesCataloguePage
                .open()
                .findCourses()
                .nameAndDateOnPlateIsRight();
    }
}
