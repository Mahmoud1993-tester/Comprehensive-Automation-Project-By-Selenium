package pom_for_signup_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAndRegisterPage {
    protected WebDriver driver;
    public LoginAndRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    private final By signUpName = By.xpath("//*[@data-qa='signup-name']");
    private final By emailAddress = By.xpath("//*[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");

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
}
