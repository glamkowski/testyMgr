package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.WaitUtils;

public class HomePageTest extends BaseTest {

    @Test
    public void niePowinienSieZalogowacJakoKlient() {
        homePage.uzupelnijLogin("blednyLogin");
        homePage.uzupelnijHaslo("bledneHaslo");
        homePage.kliknijZaloguj();
        Assert.assertEquals(homePage.pobierzTekstTesktZLoginError(), "Błędne dane logowania!");
    }

    @Test
    public void powinienSieZalogowacJakoKlient() throws InterruptedException {
        homePage.uzupelnijLogin("Kowlaski");
        homePage.uzupelnijHaslo("CCC000000");
        homePage.kliknijZaloguj();
        Assert.assertEquals(homePage.pobierzTesktzLoginSukces(), "Zalogowany jako: Oskar Kowlaski");
    }

    @Test
    public void powinienWidziecNewsy() {
        Assert.assertTrue(homePage.zwrocLiczeNewsow() > 0);
    }

    @Test
    public void powinienPrzekierowacDoLogowaniaAdmina() {
        Assert.assertEquals(homePage.uruchomPanelLogowaniaAdmina().zwrocNaglowek(), "Logowanie do panelu admina");
    }

    @Test
    public void powinienUsunacNews() throws InterruptedException {
        int iloscNewsow = homePage.zwrocLiczeNewsow();
        homePage.uruchomPanelLogowaniaAdmina();
        adminPage.uzupelnijLoginHaslo("admin111", "admin1");
        adminPage.zalogujButton.click();
        adminPage.nowosci.click();
        homePage.usunNews();
        Assert.assertTrue(iloscNewsow != homePage.zwrocLiczeNewsow());
    }
}