package pom_for_signup_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    protected WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;

    }

    // locators
    // --------- Check Message --------
    private final   By successMessage = By.xpath("//h2//b[contains(text(), 'Account Created!')]");

    public boolean isAccountCreatedMessage() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    // -------- Continue Button ----------------
    private final By continueButton = By.xpath("//a[@data-qa='continue-button']");

    // -------- Continue Button Actions --------
    public void setContinueButton() {
        driver.findElement(continueButton).click();
    }
}


