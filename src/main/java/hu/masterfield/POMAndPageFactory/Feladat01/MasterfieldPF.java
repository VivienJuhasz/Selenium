package hu.masterfield.POMAndPageFactory.Feladat01;

import hu.masterfield.POMAndPageFactory.Feladat01.pageFactory.HomePagePF;
import hu.masterfield.POMAndPageFactory.Feladat01.pageFactory.SearchResultPagePF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MasterfieldPF extends BaseTest {
    @Test
    public void testSearch() throws InterruptedException {
        HomePagePF home = new HomePagePF(driver);

        home.open();
        home.closeCookieAndPopup();

        SearchResultPagePF result = home.search("java");
        Thread.sleep(3000);
        assertTrue(result.isLoaded());

    }
}
