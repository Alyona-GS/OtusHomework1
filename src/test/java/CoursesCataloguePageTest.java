import com.google.inject.Inject;
import extensions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CoursesCataloguePage;

@ExtendWith(UIExtensions.class)
public class CoursesCataloguePageTest {
    @Inject
    CoursesCataloguePage coursesCataloguePage;

    @Test
    public void checkCourseOpenedByCoursePlateTest() {
        coursesCataloguePage
                .open()
                .findCoursePlateByCourseName("Алгоритмы и структуры данных")
                .clickCoursePlate("Алгоритмы и структуры данных")
                .pageHeaderShouldBeSameAs("Алгоритмы и структуры данных");
    }

    @Test
    public void checkNameAndDateOnCoursePlateTest() {
        coursesCataloguePage
                .open()
                .findMinMaxDateCourses();
                //.nameAndDateOnMinMaxPlateCoursesIsRight();
    }
}
