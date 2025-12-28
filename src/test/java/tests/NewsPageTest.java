package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsPageTest extends BaseTest {

    @Test
    public void powinienDodacNews () {
        homePage.uruchomPanelLogowaniaAdmina();
        adminPage.uzupelnijLoginHaslo("admin111", "admin1");
        adminPage.zalogujButton.click();
        adminPage.dodajNewsBtn.click();
        dodajNewsPage.uzuplenijTytul("Testowy123");
        dodajNewsPage.uzupelnijTresc("testowy komentarz...");
        dodajNewsPage.kliknijDodajNewsButton();
        Assert.assertEquals(dodajNewsPage.komunikatDodania.getText(), "Dodano news pomyślnie!");
    }

}
