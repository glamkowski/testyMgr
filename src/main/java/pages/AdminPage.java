package pages;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    @FindBy (xpath = "//a[@class='ataskbar']")
    public WebElement bar1;

    public AdminPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String zwrocNaglowek() {
        return bar1.getText();
    }

}
