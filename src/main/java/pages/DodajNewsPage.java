package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DodajNewsPage extends BaseTest {

    public DodajNewsPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
