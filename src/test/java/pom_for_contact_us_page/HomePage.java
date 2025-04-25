package pom_for_contact_us_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private final By contactUsLink = By.xpath("//a[@href='/contact_us']");

    // --- Actions ----
    public void setContactUsLink() {
        driver.findElement(contactUsLink).click();
    }
}
