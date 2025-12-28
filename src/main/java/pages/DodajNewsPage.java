package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DodajNewsPage extends BaseTest {

    @FindBy (xpath = "//input[@name='dodawany_tytul']")
    public WebElement tytulInput;

    @FindBy(xpath = "//textarea[@name='dodawany_tresc']")
    public WebElement trescInput;

    @FindBy (xpath = "//input[@class='button_send']")
    public WebElement dodajNewsButton;

    @FindBy (xpath = "//a[@class='informacja_dodanie']")
    public WebElement komunikatDodania;

    public DodajNewsPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void uzuplenijTytul(String tytul) {
        tytulInput.click();
        tytulInput.clear();
        tytulInput.sendKeys(tytul);
    }

    public void uzupelnijTresc (String tresc) {
        trescInput.click();
        trescInput.clear();
        trescInput.sendKeys(tresc);
    }

    public void kliknijDodajNewsButton() {
        dodajNewsButton.click();
    }

}
