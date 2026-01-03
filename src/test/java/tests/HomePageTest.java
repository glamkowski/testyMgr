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
        WaitUtils.waitForVisible(driver, (By) homePage.loginError, 5);
        Assert.assertEquals(homePage.loginError.getText(), "Błędne dane logowania!");
    }

    @Test
    public void powinienSieZalogowacJakoKlient() throws InterruptedException {
        homePage.uzupelnijLogin("Kowlaski");
        homePage.uzupelnijHaslo("CCC000000");
        homePage.kliknijZaloguj();
        WaitUtils.waitForVisible(driver, (By) homePage.successLogin, 5);
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
        WaitUtils.waitForVisible(driver, (By) adminPage.nowosci, 5);
        adminPage.nowosci.click();
        WaitUtils.waitForVisible(driver, (By) homePage.newsy, 5);
        homePage.usunNews();
        WaitUtils.waitForVisible(driver, (By) homePage.posts, 5);
        Assert.assertTrue(iloscNewsow != homePage.zwrocLiczeNewsow());
    }
}