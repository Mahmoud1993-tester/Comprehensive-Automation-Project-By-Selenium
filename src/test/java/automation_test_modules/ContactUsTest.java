package automation_test_modules;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom_for_contact_us_page.ContactUsPage;
import pom_for_contact_us_page.HomePage;

public class ContactUsTest {
    protected WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void openWebsite() {
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @Test(priority = 1)
    public void navigateTOContactSection() {
        HomePage homePage = new HomePage(driver);
        homePage.setContactUsLink();
    }
    @Test(priority = 2)
    public void enterPersonalInfo() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.setNameField("Mahmoud Saber");
        contactUsPage.setEmailField("engabosaber2014@gmail.com");
        contactUsPage.setSubjectField("Login Issues");
        contactUsPage.setMessageField("I'm Facing a problem during Logging in the Website");
    }
    @Test(priority = 3)
    public void uploadFile() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.setUploadFileButton("D:\\Programming\\Software Testing\\Automation Projects\\LoginProblem.txt");
    }
    @Test(priority = 4)
    public void clickSubmitButton() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.setSubmitButton();
    }
    @Test(priority = 5)
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test(priority = 6)
    public void successMessage() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        Assert.assertTrue(contactUsPage.setSuccessMessage(),
                "Success! Your details have been submitted successfully.");
        Assert.assertTrue(contactUsPage.setSuccessMessageGetText().trim().contains("Success! Your details have been submitted successfully."),
                "The Message is Displayed correctly!");
    }
    @Test(priority = 7)
    public void backToHomePage() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.setHomeButton();
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
