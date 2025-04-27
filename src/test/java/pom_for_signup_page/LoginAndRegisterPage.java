package pom_for_signup_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAndRegisterPage {
    protected WebDriver driver;
    public LoginAndRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    private final By signUpName = By.xpath("//*[@data-qa='signup-name']");
    private final By emailAddress = By.xpath("//*[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private final By registerMessage = By.xpath("//form//p[contains(text(), 'Email Address already')]");

    // ------ SignUp Actions ----------
    public void setSignUpName(String name) {
        driver.findElement(signUpName).sendKeys(name);
    }

    public void setEmailAddress(String email) {
        driver.findElement(emailAddress).sendKeys(email);
    }

    public void setSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public boolean isRegisterMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement isMessageDisplayedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(registerMessage));
        return isMessageDisplayedElement.isDisplayed();
    }

    public String getRegisterMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement getMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(registerMessage));
        return getMessageElement.getText();
    }
}
