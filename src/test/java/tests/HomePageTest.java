package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void shouldOpenHomePageAndHaveProperTitle() {
        HomePage homePage = new HomePage(driver);

        String title = homePage.getTitle();
    }
}