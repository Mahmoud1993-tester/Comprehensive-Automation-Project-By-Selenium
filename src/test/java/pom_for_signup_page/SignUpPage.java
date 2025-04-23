package pom_for_signup_page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
    protected WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    // locators

    // ----------- Personal Information ------------
    private final By titleButton = By.id("id_gender1");
    private final By passwordField = By.id("password");
    private final By daySelection = By.id("days");
    private final By monthSelection = By.id("months");
    private final By yearSelection = By.id("years");

    // ----------- Checkboxes ------------
    private final By checkBoxOne = By.id("newsletter");
    private final By checkBoxTwo = By.id("optin");

    // ----------- Address Information -----------
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By addressOne = By.xpath("//input[@data-qa='address']");
    private final By addressTwo = By.xpath("//input[@data-qa='address2']");
    private final By countrySelection = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");

    // ----------- Submit Button ------------
    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");


    // Actions

    // --------- Personal Section Actions -----------
    public void titleSelect() {
        driver.findElement(titleButton).click();
    }

    public void setPasswordField(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    public void setDaySelection(String day) {
        new Select(driver.findElement(daySelection)).selectByValue(day);
    }

    public void setMonthSelection(String month) {
        new Select(driver.findElement(monthSelection)).selectByValue(month);
    }

    public void setYearSelection(String year) {
        new Select(driver.findElement(yearSelection)).selectByValue(year);
    }

    // --------- Checkboxes Actions ---------------------------
    public void setCheckBoxOne() {
        WebElement elementOne = driver.findElement(checkBoxOne);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementOne);
        js.executeScript("arguments[0].click();", elementOne);
    }

    public void setCheckBoxTwo () {
        WebElement elementTwo = driver.findElement(checkBoxTwo);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementTwo);
        js.executeScript("arguments[0].click();", elementTwo);
    }

    // -------- Address Info Actions -----------------------
    public void setFirstName(String fName) {
        driver.findElement(firstName).sendKeys(fName);
    }

    public void setLastName(String lName) {
        driver.findElement(lastName).sendKeys(lName);
    }

    public void setCompany(String cName) {
        driver.findElement(company).sendKeys(cName);
    }

    public void setAddressOne(String addOne) {
        driver.findElement(addressOne).sendKeys(addOne);
    }

    public void setAddressTwo(String addTwo) {
        driver.findElement(addressTwo).sendKeys(addTwo);
    }

    public void setCountrySelection(String country) {
        new Select(driver.findElement(countrySelection)).selectByValue(country);
    }

    public void setState(String ste) {
        driver.findElement(state).sendKeys(ste);
    }

    public void setCity(String cty) {
        driver.findElement(city).sendKeys(cty);
    }

    public void setZipcode(String zCode) {
        driver.findElement(zipcode).sendKeys(zCode);
    }

    public void setMobileNumber(String mNumber) {
        driver.findElement(mobileNumber).sendKeys(mNumber);
    }

    // -------------- Submit Action --------------------
    public void setCreateAccountButton() {
        WebElement submitElement = driver.findElement(createAccountButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitElement);
        js.executeScript("arguments[0].click();", submitElement);
    }
}
