import com.google.inject.Inject;
import extensions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;

@ExtendWith(UIExtensions.class)
public class MainPageTest {
    @Inject
    MainPage mainPage;

    @Test
    public void CheckCategoryOpenedAfterCheckBoxClickTest() {
        mainPage
                .open()
                .clickMenuLearning()
                .clickRandomCategoryInMenu()
                .checkCatalogueUrl();
    }
}
