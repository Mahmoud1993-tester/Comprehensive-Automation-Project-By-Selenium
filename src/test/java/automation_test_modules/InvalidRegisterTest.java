package automation_test_modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom_for_login_page.HomePage;
import pom_for_signup_page.LoginAndRegisterPage;

public class InvalidRegisterTest {
    WebDriver driver;
    @BeforeTest
    public void openWebsite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @Test(priority = 1)
    public void navigateToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.setLoginLink();
    }
    @Test(priority = 2)
    public void enterRegisterValues() {
        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver);
        loginAndRegisterPage.setSignUpName("Ali Mahmoud");
        loginAndRegisterPage.setEmailAddress("user_2025@gmail.com");
    }
    @Test(priority = 3)
    public void clickRegisterButton() {
        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver);
        loginAndRegisterPage.setSignUpButton();
    }
    @Test(priority = 4)
    public void checkRegisterMessage() {
        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver);
        Assert.assertTrue(loginAndRegisterPage.isRegisterMessageDisplayed(), "Email Address already exist!");
        Assert.assertTrue(loginAndRegisterPage.getRegisterMessageText().trim().contains("Email Address already exist!"),
                "This Email already Exist is Displayed");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
