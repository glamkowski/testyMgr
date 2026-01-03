package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.WaitUtils;

public class AdminPageTest extends BaseTest {

    @Test
    public void powinienZalogowacSieJakoAdmin () throws InterruptedException {
        homePage.uruchomPanelLogowaniaAdmina();
        adminPage.uzupelnijLoginHaslo("admin111", "admin1");
        adminPage.zalogujButton.click();
        Assert.assertTrue(adminPage.zweryfikujCzyWelcomeAreaDostepne());

    }

    @Test
    public void niePowinienZalogowacSieJakoAdmin () throws InterruptedException {
        homePage.uruchomPanelLogowaniaAdmina();
        adminPage.uzupelnijLoginHaslo("admin", "admin");
        adminPage.zalogujButton.click();
        Assert.assertEquals(adminPage.pobierzTesktZloginError(), "Błędne dane logowania!");
    }
}
