package automationTestByTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    @BeforeTest
    public void openWebsite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @Test(priority = 0)
    public void navigateToLoginPage() {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
    }
    @Test(priority = 1)
    public void enterLoginValues() {
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("namosos608@mobilesm.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Pass@1993");
    }
    @Test(priority = 2)
    public void clickLoginButton() {
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
    }
    @Test(priority = 3)
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }
    @Test(priority = 4)
    public void clickLogout() {
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }
    @Test(priority = 5)
    public void closeBrowser() {
        driver.quit();
    }

}
