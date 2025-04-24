package pom_for_login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginAndRegisterPage {
    protected WebDriver driver;
    public LoginAndRegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    // Locators
    private final By emailAddressLogin = By.xpath("//input[@data-qa='login-email']");
    private final By passwordLogin = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By invalidLoginMessage = By.xpath("//p[contains(text(),'Your email')]");

    // -- Actions ---
    public void setEmailAddressLogin(String email) {
        driver.findElement(emailAddressLogin).sendKeys(email);
    }

    public void setPasswordLogin(String passLogin) {
        driver.findElement(passwordLogin).sendKeys(passLogin);
    }

    public void setLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isInvalidMessageAppeared() {
        return driver.findElement(invalidLoginMessage).isDisplayed();
    }

    public String getInvalidMessage() {
        return driver.findElement(invalidLoginMessage).getText();
    }

}
