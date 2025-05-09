package pom_for_login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    protected WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By accountMessage = By.xpath("//li//a[contains(text(), 'Logged in as')]");
    private final By logoutLink = By.xpath("//a[@href='/logout']");

    // --- Actions ----
    public boolean isUserLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loggedInMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountMessage));
        return loggedInMessageElement.isDisplayed();
    }

    public String getLoggedInMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountMessage));
        return accountMessageElement.getText();
    }

    public void setLogoutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
        logoutLinkElement.click();
    }
}
