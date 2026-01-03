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
        WaitUtils.waitForVisible(driver, (By) adminPage.welcomeArea, 5);
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
