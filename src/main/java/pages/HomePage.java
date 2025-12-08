package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    // lokatory
    private final By loginButton = By.id("login-btn");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}