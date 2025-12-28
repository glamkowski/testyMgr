package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DodajRezerwacjeTest extends BaseTest {
    @Test
    public void dodajRezerwacje() throws InterruptedException {
        homePage.uruchomPanelLogowaniaAdmina();
        adminPage.uzupelnijLoginHaslo("admin111", "admin1");
        adminPage.zalogujButton.click();
        adminPage.dodajRezerwacjeBtn.click();
        dodajRezerwacjePage.wybierzApartament();
        dodajRezerwacjePage.dalejButton.click();
        dodajRezerwacjePage.wybierzIloscOsob();
        dodajRezerwacjePage.wybierzKlienta();
        dodajRezerwacjePage.wybierzDatePrzyjazdu();
        dodajRezerwacjePage.wybierzDateOdjazu();
        dodajRezerwacjePage.kliknijDodajRezerwacje();
        dodajRezerwacjePage.kliknijDalej();
        Assert.assertEquals(dodajRezerwacjePage.dodanoPomyslnieBar.getText(), "Dodano pomyślnie");
    }
}
