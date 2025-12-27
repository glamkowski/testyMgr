package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    @FindBy (xpath = "//a[@class='ataskbar']")
    public WebElement bar1;

    @FindBy (xpath = "//input[@class='input_log1']")
    public WebElement loginInput;

    @FindBy (xpath = "//input[@class='input_log1' and @type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@class='button_log1']")
    public WebElement zalogujButton;

    @FindBy(className = "welcome")
    public WebElement welcomeArea;

    @FindBy (xpath = "//a[@class='e-login']")
    public WebElement loginError;

    @FindBy (xpath = "//*[text()='Dodaj Nowość']")
    public WebElement dodajNewsBtn;

    public AdminPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String zwrocNaglowek() {
        return bar1.getText();
    }

    public void uzupelnijLoginHaslo (String login, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(login);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

}
