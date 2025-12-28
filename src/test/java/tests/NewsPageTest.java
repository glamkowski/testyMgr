package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsPageTest extends BaseTest {

    @Test
    public void powinienDodacNews () throws InterruptedException {
        homePage.uruchomPanelLogowaniaAdmina();
        adminPage.uzupelnijLoginHaslo("admin111", "admin1");
        adminPage.zalogujButton.click();
        Thread.sleep(3000);
        adminPage.dodajNewsBtn.click();
        dodajNewsPage.uzuplenijTytul("Testowy123");
        dodajNewsPage.uzupelnijTresc("testowy komentarz...");
        dodajNewsPage.kliknijDodajNewsButton();
        Thread.sleep(3000);
        Assert.assertEquals(dodajNewsPage.komunikatDodania.getText(), "Dodano news pomyślnie!");
    }

}
