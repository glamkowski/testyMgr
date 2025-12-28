package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AdminPage;
import pages.DodajNewsPage;
import pages.DodajRezerwacjePage;
import pages.HomePage;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public AdminPage adminPage;
    public DodajNewsPage dodajNewsPage;
    public DodajRezerwacjePage dodajRezerwacjePage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("user-data-dir=C:/selenium/chrome-profile-test");
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://localhost");
        this.homePage = new HomePage(this.driver);
        this.adminPage = new AdminPage(this.driver);
        this.dodajNewsPage = new DodajNewsPage(this.driver);
        this.dodajRezerwacjePage = new DodajRezerwacjePage(this.driver);
    }

    @AfterMethod
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}