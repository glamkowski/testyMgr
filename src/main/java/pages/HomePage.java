package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

import java.util.List;

public class HomePage {

    public final WebDriver driver;

    @FindBy(name = "login")
    public WebElement loginInput;

    @FindBy(name = "haslo")
    public WebElement passwordInput;

    @FindBy(className = "button_log1")
    public WebElement loginButton;

    @FindBy (className = "e-login2")
    public WebElement loginError;

    @FindBy (xpath = "*//ul[@class='welcome']/li")
    public WebElement successLogin;

    @FindBy (xpath = "*//div[@id='zawartosc']/div[@class='post']")
    public List<WebElement> posts;

    @FindBy (xpath = "//a[@class='afooter2']")
    public WebElement loginAsAdminButton;

    @FindBy (xpath = "//a[text()='Usuń']")
    public List<WebElement> newsy;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String pobierzTekstTesktZLoginError() {
        WaitUtils.waitForVisible(driver, loginError, 5);
        return loginError.getText();

    }

    public void uzupelnijLogin(String login) {
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    public void uzupelnijHaslo(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void kliknijZaloguj() {
        loginButton.click();
    }

    public int zwrocLiczeNewsow () {
        return posts.size();
    }

    public AdminPage uruchomPanelLogowaniaAdmina () {
        loginAsAdminButton.click();
        AdminPage adminPage = new AdminPage(this.driver);
        return adminPage;
    }

    public void usunNews() {
        newsy.getFirst().click();
    }

    }