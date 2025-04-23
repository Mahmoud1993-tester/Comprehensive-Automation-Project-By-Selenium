package pom_for_signup_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    protected WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // -------- Logout Button -----------
    private final By logoutButton = By.xpath("//a[@href='/logout']");

    public void setLogoutButton() {
        driver.findElement(logoutButton).click();
    }

}
