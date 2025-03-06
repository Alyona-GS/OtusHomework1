import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MainPage_Test {

    MainPage mainPage = new MainPage();

    @Test
    public void CheckCategoryOpenedAfterCheckBoxClick() {
        mainPage
                .open()
                .clickMenuLearning()
                .clickRandomCategoryInMenu()
                .checkCatalogueUrl();
    }
}
