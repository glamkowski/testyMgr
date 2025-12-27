package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void niePowinienSieZalogowacJakoKlient(){
        homePage.uzupelnijLogin("blednyLogin");
        homePage.uzupelnijHaslo("bledneHaslo");
        homePage.kliknijZaloguj();
        Assert.assertEquals(homePage.loginError.getText(), "Błędne dane logowania!");
    }

    @Test
    public void powinienSieZalogowacJakoKlient(){
        homePage.uzupelnijLogin("Kowlaski");
        homePage.uzupelnijHaslo("CCC000000");
        homePage.kliknijZaloguj();
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
}