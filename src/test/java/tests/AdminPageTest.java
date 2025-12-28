package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPageTest extends BaseTest {

    @Test
    public void powinienZalogowacSieJakoAdmin () throws InterruptedException {
        homePage.uruchomPanelLogowaniaAdmina();
        adminPage.uzupelnijLoginHaslo("admin111", "admin1");
        adminPage.zalogujButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(adminPage.welcomeArea.isDisplayed());
    }

    @Test
    public void niePowinienZalogowacSieJakoAdmin () throws InterruptedException {
        homePage.uruchomPanelLogowaniaAdmina();
        adminPage.uzupelnijLoginHaslo("admin", "admin");
        adminPage.zalogujButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(adminPage.loginError.getText(), "Błędne dane logowania!");
    }
}
