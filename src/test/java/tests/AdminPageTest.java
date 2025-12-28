package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPageTest extends BaseTest {

    @Test
    public void powinienZalogowacSieJakoAdmin () {
        homePage.uruchomPanelLogowaniaAdmina();
        adminPage.uzupelnijLoginHaslo("admin111", "admin1");
        adminPage.zalogujButton.click();
        Assert.assertTrue(adminPage.welcomeArea.isDisplayed());
    }

    @Test
    public void niePowinienZalogowacSieJakoAdmin () {
        homePage.uruchomPanelLogowaniaAdmina();
        adminPage.uzupelnijLoginHaslo("admin", "admin");
        adminPage.zalogujButton.click();
        Assert.assertEquals(adminPage.loginError.getText(), "Błędne dane logowania!");
    }
}
