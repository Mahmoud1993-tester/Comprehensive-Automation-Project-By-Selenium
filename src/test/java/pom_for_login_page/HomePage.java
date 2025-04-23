package pom_for_login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By loginLink = By.xpath("//a[@href='/login']");

    // ---- Actions ----
    public void setLoginLink() {
        driver.findElement(loginLink).click();
    }
}
