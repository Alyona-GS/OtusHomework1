import pages.MainPage;

public class MainPage_Test {

    MainPage mainPage = new MainPage();

    @Test
    public void CheckCategoryOpenedAfterCheckBoxClick() {
        mainPage
                .open()
                .clickMenuLearning()
                .clickRandomCategory()
                .checkCatalogue();
    }
}
