package automation_test_modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom_for_login_page.AccountPage;
import pom_for_login_page.HomePage;
import pom_for_login_page.LoginAndRegisterPage;

import java.time.Duration;

public class LoginTest {
    protected WebDriver driver;
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
    public void enterLoginValues() {
        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver);
        loginAndRegisterPage.setEmailAddressLogin("vonito2871@miracle3.com");
        loginAndRegisterPage.setPasswordLogin("Pass@445500");
    }
    @Test(priority = 3)
    public void clickLoginButton() {
        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver);
        loginAndRegisterPage.setLoginButton();
    }
    @Test(priority = 5)
    public void accountLoggedMessage() {
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isUserLoggedIn(), "Logged in as");
        Assert.assertTrue(accountPage.getLoggedInMessage().trim().contains("Logged in as"),
                "Logged In Message Appeared");
    }
    @Test(priority = 6)
    public void clickLogout() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.setLogoutLink();
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
