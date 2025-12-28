package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void niePowinienSieZalogowacJakoKlient() throws InterruptedException {
        homePage.uzupelnijLogin("blednyLogin");
        homePage.uzupelnijHaslo("bledneHaslo");
        homePage.kliknijZaloguj();
        Thread.sleep(3000);
        Assert.assertEquals(homePage.loginError.getText(), "Błędne dane logowania!");
    }

    @Test
    public void powinienSieZalogowacJakoKlient() throws InterruptedException {
        homePage.uzupelnijLogin("Kowlaski");
        homePage.uzupelnijHaslo("CCC000000");
        homePage.kliknijZaloguj();
        Thread.sleep(3000);
        Assert.assertEquals(homePage.successLogin.getText(), "Zalogowany jako: Oskar Kowlaski");
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
        Thread.sleep(3000);
        adminPage.nowosci.click();
        Thread.sleep(3000);
        homePage.usunNews();
        Thread.sleep(3000);
        Assert.assertTrue(iloscNewsow != homePage.zwrocLiczeNewsow());
    }
}