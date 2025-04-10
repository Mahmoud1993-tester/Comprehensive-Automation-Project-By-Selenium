package automationTestByTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class RegisterTest {
    public WebDriver driver;
    @BeforeTest
    public void openWebsite () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/login");
    }
    @Test(priority = 1)
    public void navigateToSignUpPage() {
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mahmoud Saber");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("vahik97219@naobk.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
    }
    @Test(priority = 2)
    public void enterAccountInformation() {
        WebDriverWait waitTitleRadioButton = new WebDriverWait(driver, Duration.ofSeconds(6));
        waitTitleRadioButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Mr']")));
        driver.findElement(By.xpath("//input[@value='Mr']")).click();
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("Pass@1993");
        // day selection
        WebElement dropElementDay = driver.findElement(By.id("days"));
        Select daysDropdown = new Select(dropElementDay);
        daysDropdown.selectByValue("29");

        // month selection
        WebElement dropElementMonth = driver.findElement(By.id("months"));
        Select monthsDropdown = new Select(dropElementMonth);
        monthsDropdown.selectByVisibleText("September");

        // year selection
        WebElement dropElementYear = driver.findElement(By.id("years"));
        Select yearsDropdown = new Select(dropElementYear);
        yearsDropdown.selectByValue("1993");

        // scroll and check boxes selection
        WebElement newsLetterCheckBox = driver.findElement(By.id("newsletter"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", newsLetterCheckBox);
        newsLetterCheckBox.click();
        driver.findElement(By.id("optin")).click();
    }
}
