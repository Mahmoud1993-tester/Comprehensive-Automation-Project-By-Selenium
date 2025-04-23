package pom_for_login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    protected WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By accountMessage = By.xpath("//a[contains(text(), 'Logged in as')]");
    private final By logoutLink = By.xpath("//a[@href='/logout']");

    // --- Actions ----
    public boolean isUserLoggedIn() {
        return driver.findElement(accountMessage).isDisplayed();
    }

    public String getLoggedInMessage() {
        return driver.findElement(accountMessage).getText();
    }

    public void setLogoutLink() {
        driver.findElement(logoutLink).click();
    }
}
