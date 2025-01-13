import org.junit.jupiter.api.Test;
import pages.CoursesCataloguePage;

public class CoursesCataloguePage_Test {

    CoursesCataloguePage coursesCataloguePage = new CoursesCataloguePage();

    @Test
    public void CheckCourseOpenedByCoursePlate() {
        coursesCataloguePage
                .open()
                .findCoursePlateByCourseName("course_name")
                .clickCoursePlate()
                .pageHeaderShouldBeSameAs("Делись знаниями");
    }

    @Test
    public void CheckNameAndDateOnCoursePlate() {
        coursesCataloguePage
                .open()
                .findTheOldestAndYoungestCoursesByApi()
                .NameAndDateOnPlateIsRight();
    }
}
