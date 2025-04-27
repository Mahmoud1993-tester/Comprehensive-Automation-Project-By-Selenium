package pom_for_contact_us_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    protected WebDriver driver;
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By nameField = By.xpath("//input[@data-qa='name']");
    private final By emailField = By.xpath("//input[@data-qa='email']");
    private final By subjectField = By.xpath("//input[@data-qa='subject']");
    private final By messageField = By.xpath("//textarea[@data-qa='message']");
    private final By uploadFileButton = By.xpath("//input[@name='upload_file']");
    private final By submitButton = By.xpath("//input[@data-qa='submit-button']");
    private final By successMessage = By.xpath("//div[contains(text(), 'submitted successfully')]");
    private final By homeButton = By.xpath("//a[contains(@class, 'btn-success')]");

    /* ----- Actions ------ */

    // ----- Personal Info ------
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setSubjectField(String sub) {
        driver.findElement(subjectField).sendKeys(sub);
    }

    public void setMessageField(String msg) {
        driver.findElement(messageField).sendKeys(msg);
    }

    // ----- Upload File -----
    public void setUploadFileButton(String filePath) {
       driver.findElement(uploadFileButton).sendKeys(filePath);
    }

    // ----- Submit Button -----
    public void setSubmitButton() {
        WebElement submitElement = driver.findElement(submitButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitElement);
        submitElement.click();
    }

    // ------ Successful Message After Sending ----------
    public boolean setSuccessMessage() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public String setSuccessMessageGetText() {
        return driver.findElement(successMessage).getText();
    }

    // ------- Navigate to HomePage ----
    public void setHomeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement homeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButtonElement.click();
    }
}
