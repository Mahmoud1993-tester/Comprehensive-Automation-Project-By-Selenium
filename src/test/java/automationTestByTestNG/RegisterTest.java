package automationTestByTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


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
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("nocori5462@naobk.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
    }
    @Test(priority = 1)
    public void enterAccountInformation() {
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
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
        WebElement checkboxElement = driver.findElement(By.id("newsletter"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkboxElement);
        checkboxElement.click();
        driver.findElement(By.id("optin")).click();
    }
    @Test(priority = 2)
    public void enterAddressInformation() {

        // Enter name and address
        driver.findElement(By.id("first_name")).sendKeys("Mahmoud");
        driver.findElement(By.id("last_name")).sendKeys("Saber");
        driver.findElement(By.id("company")).sendKeys("Glass Tec");
        driver.findElement(By.id("address1")).sendKeys("Fifth Avenue");
        driver.findElement(By.id("address2")).sendKeys("NewYork");

        // Select Country
        WebElement countryElement = driver.findElement(By.id("country"));
        Select countryDropdown = new Select(countryElement);
        countryDropdown.selectByValue("Canada");

        // Enter state and city and other fields
        driver.findElement(By.id("state")).sendKeys("Sharqia");
        driver.findElement(By.id("city")).sendKeys("Zagazig");
        driver.findElement(By.id("zipcode")).sendKeys("445570");
        driver.findElement(By.id("mobile_number")).sendKeys("+2011547555");

    }
    @Test(priority = 3)
    public void clickCreateAccountButton() {
        WebElement createAccountButton = driver.findElement(By.xpath("//*[@data-qa='create-account']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", createAccountButton);
        createAccountButton.click();
    }

    @Test(priority = 4)
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @Test(priority = 5)
    public void backToHomePage() {
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
