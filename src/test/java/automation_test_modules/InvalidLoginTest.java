package automation_test_modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom_for_login_page.HomePage;
import pom_for_login_page.LoginAndRegisterPage;

public class InvalidLoginTest {
    WebDriver driver;
    @BeforeTest
    public void homePage() {
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
    public void enterInvalidCredential() {
        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver);
        loginAndRegisterPage.setEmailAddressLogin("hifer81939@cxnlab.com");
        loginAndRegisterPage.setPasswordLogin("Pass@1993");
    }
    @Test(priority = 3)
    public void clickLoginButton() {
        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver);
        loginAndRegisterPage.setLoginButton();
    }
    @Test(priority = 4)
    public void checkMessage() {
        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver);
        Assert.assertTrue(loginAndRegisterPage.isInvalidMessageAppeared(), "Your email or password is incorrect!");
        Assert.assertTrue(loginAndRegisterPage.getInvalidMessage().trim().contains("Your email or password is incorrect"),
                "Message is displayed correctly!");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
