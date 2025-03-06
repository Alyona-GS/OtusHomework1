import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MainPageTest {

    MainPage mainPage = new MainPage();

    @Test
    public void CheckCategoryOpenedAfterCheckBoxClickTest() {
        mainPage
                .open()
                .clickMenuLearning()
                .clickRandomCategoryInMenu()
                .checkCatalogueUrl();
    }
}
