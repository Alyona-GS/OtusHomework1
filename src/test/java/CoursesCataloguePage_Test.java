import org.junit.jupiter.api.Test;
import pages.CoursesCataloguePage;

public class CoursesCataloguePage_Test {

    CoursesCataloguePage coursesCataloguePage = new CoursesCataloguePage();

    @Test
    public void checkCourseOpenedByCoursePlate() {
        coursesCataloguePage
                .open()
                .findCoursePlateByCourseName("Symfony Framework")
                .clickCoursePlate("Symfony Framework")
                .pageHeaderShouldBeSameAs("Symfony Framework");
    }

    @Test
    public void checkNameAndDateOnCoursePlate() {
        coursesCataloguePage
                .open()
                .findCourses()
                .nameAndDateOnPlateIsRight();
    }
}
