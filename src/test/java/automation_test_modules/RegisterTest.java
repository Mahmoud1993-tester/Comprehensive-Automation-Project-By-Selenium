package automation_test_modules;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom_for_signup_page.AccountCreatedPage;
import pom_for_signup_page.AccountPage;
import pom_for_signup_page.LoginAndRegisterPage;
import pom_for_signup_page.SignUpPage;

import java.time.Duration;


public class RegisterTest {
    WebDriver driver;
    @BeforeTest
    public void openWebsite () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/login");
    }
    @Test(priority = 1)
    public void navigateToSignUpPage() {
        LoginAndRegisterPage registerPage = new LoginAndRegisterPage(driver);
        registerPage.setSignUpName("Saber");
        registerPage.setEmailAddress("hedire2249@ingitel.com");
        registerPage.setSignUpButton();
    }
    @Test(priority = 2)
    public void enterAccountInformation() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.titleSelect();
        signUpPage.setPasswordField("Pass@445500");
        signUpPage.setDaySelection("29");
        signUpPage.setMonthSelection("9");
        signUpPage.setYearSelection("1993");
    }

    @Test(priority = 3)
    public void selectCheckboxes() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setCheckBoxOne();
        signUpPage.setCheckBoxTwo();
    }


    @Test(priority = 4)
    public void enterAddressInformation() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setFirstName("Mahmoud");
        signUpPage.setLastName("Saber");
        signUpPage.setCompany("Glass Tec");
        signUpPage.setAddressOne("Egypt");
        signUpPage.setAddressTwo("Cairo");
        signUpPage.setCountrySelection("India");
        signUpPage.setState("Sharqia");
        signUpPage.setCity("Zagazig");
        signUpPage.setZipcode("445582");
        signUpPage.setMobileNumber("0111669210");
    }

    @Test(priority = 5)
    public void clickCreateAccountButton() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setCreateAccountButton();
    }

    @Test(priority = 6)
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @Test(priority = 7)
    public void accountCreatedPage() {
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        Assert.assertTrue(accountCreatedPage.isAccountCreatedMessage(), "ACCOUNT CREATED!");
        Assert.assertTrue(accountCreatedPage.getSuccessMessage().trim().contains("ACCOUNT CREATED!"),
                "Success message is displayed correctly!");
        accountCreatedPage.setContinueButton();

    }

    @Test(priority = 7)
    public void backToAccountPage() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.setLogoutButton();

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
