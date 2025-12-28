package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

public class DodajRezerwacjePage extends BaseTest {

    @FindBy(xpath = "//select")
    public WebElement listaApartamentow;

    @FindBy (xpath = "//input[@class='button_send']")
    public WebElement dalejButton;

    @FindBy (xpath = "//select[@name='apartamenty']")
    public WebElement dodajRezerwacjeButtton;

    @FindBy (xpath = "//select[@name='dane_klient']")
    public WebElement wybierzKlienta;

    @FindBy (xpath = "//input[@name='przyjazd']")
    public WebElement dataPrzyjazdu;

    @FindBy (xpath = "//input[@name='odjazd']")
    public WebElement dataOdjazdus;

    @FindBy (xpath = "//input[@class='button_send']")
    public WebElement dodajRezerwacjeButtton2;

    @FindBy (xpath = "//a[text()='Dalej']")
    public WebElement getDalejButton2;

    @FindBy (xpath = "//a[text()='Dodano pomyślnie']")
    public WebElement dodanoPomyslnieBar;

    public Select select;

    public DodajRezerwacjePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void wybierzApartament() {
        select = new Select(listaApartamentow);
        select.selectByIndex(4);
    }

    public void wybierzIloscOsob () {
        select = new Select(dodajRezerwacjeButtton);
        select.selectByIndex(2);
    }

    public void wybierzKlienta() {
        select = new Select(wybierzKlienta);
        select.selectByIndex(0);
    }

    public void wybierzDatePrzyjazdu() {
        dataPrzyjazdu.sendKeys("01.02.2026");
    }

    public void wybierzDateOdjazu() {
        dataOdjazdus.sendKeys("10.01.2026");
    }

    public void kliknijDodajRezerwacje() {
        dodajRezerwacjeButtton2.click();
    }

    public void kliknijDalej () {
        getDalejButton2.click();
    }

}
