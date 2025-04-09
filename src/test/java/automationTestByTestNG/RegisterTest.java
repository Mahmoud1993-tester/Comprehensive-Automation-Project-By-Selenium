package automationTestByTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RegisterTest {
    WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void openWebsite () {
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/login");
    }
    @Test(priority = 0)
    public void navigateToSignUpPage() {
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mahmoud Saber");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("sixoxav885@movfull.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
    }
}
