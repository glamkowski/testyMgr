package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class AdminPage {

    public WebDriver driver;

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

    @FindBy (xpath = "//a[text()='Dodaj rezerwacje']")
    public WebElement dodajRezerwacjeBtn;

    @FindBy (xpath = "//*[text()='Nowości']")
    public WebElement nowosci;

    public AdminPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

public String pobierzTesktZloginError () {
        WaitUtils.waitForVisible(this.driver, this.loginError, 5);
        return loginError.getText();
    }

    public String zwrocNaglowek() {
        return bar1.getText();
    }

    public void kliknijWnowosci() {
        nowosci.click();
    }

    public boolean zweryfikujCzyWelcomeAreaDostepne () {
        WaitUtils.waitForVisible(this.driver, this.welcomeArea, 5);
        return welcomeArea.isDisplayed();
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
