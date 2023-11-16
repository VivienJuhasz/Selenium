package hu.masterfield.POM.Feladat01;

import hu.masterfield.POM.Feladat01.pom.HomePagePOM;
import hu.masterfield.POM.Feladat01.pom.SearchResultPagePOM;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MasterfieldPOM extends BaseTest {
    @Test
    public void testSearch() {
        HomePagePOM home = new HomePagePOM(driver);

        home.open();
        home.closeCookieAndPopup();

        SearchResultPagePOM result = home.search("java");
        assertTrue(result.isLoaded());
    }
}