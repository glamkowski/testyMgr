package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.AdminPage;
import pages.DodajNewsPage;
import pages.DodajRezerwacjePage;
import pages.HomePage;

@Listeners(ExtentTestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected AdminPage adminPage;
    protected DodajNewsPage dodajNewsPage;
    protected DodajRezerwacjePage dodajRezerwacjePage;

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get("http://host.docker.internal");
        this.homePage = new HomePage(driver);
        this.adminPage = new AdminPage(driver);
        this.dodajNewsPage = new DodajNewsPage(driver);
        this.dodajRezerwacjePage = new DodajRezerwacjePage(driver);
    }

    @AfterMethod
    public void cleanUp() {
        DriverFactory.quitDriver();
    }
}
