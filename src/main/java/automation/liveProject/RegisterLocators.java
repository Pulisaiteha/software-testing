package automation.liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterLocators {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public RegisterLocators(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By myAccount = By.xpath("//span[text()='My Account']");
    private By registerLink = By.xpath("//a[text()='Register']");
    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");
    private By email = By.name("email");
    private By telephone = By.id("input-telephone");
    private By password = By.name("password");
    private By confirmPassword = By.name("confirm");
    private By subscribe  =By.xpath("//input[@name='newsletter'][@value='1']");
    private By agreeCheckbox = By.name("agree");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By accountCreatedMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created')]");
    private By contentSection = By.id("content");
    private By continueAfterRegister = By.xpath("//a[text()='Continue']");
    private By editAccountInfo = By.linkText("Edit your account information");
    private By logoutLink = By.linkText("Logout");
    private By errorMessage=By.xpath("//div[contains(text(),'Password confirmation does not match password')]");

    // Methods for actions
    public void navigateToRegisterPage() {
        driver.findElement(myAccount).click();
        driver.findElement(registerLink).click();
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailId) {
        driver.findElement(email).sendKeys(emailId);
    }

    public void enterTelephone(String phone) {
        driver.findElement(telephone).sendKeys(phone);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void confirmPassword(String confirmPwd) {
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
    }
    
    public void subscribe() {
    	driver.findElement(subscribe).click();
    }

    public void acceptTerms() {
        driver.findElement(agreeCheckbox).click();
    }

    public void submitRegistration() {
        driver.findElement(continueButton).click();
    }

    public boolean isLogoutDisplayed() {
        WebElement logoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
        return logoutElement.isDisplayed();
    }

    public String getAccountCreationMessage() {
        return driver.findElement(accountCreatedMessage).getText();
    }

    public String getContentText() {
        return driver.findElement(contentSection).getText();
    }

    public void clickContinueAfterRegister() {
        driver.findElement(continueAfterRegister).click();
    }

    public String getEditAccountInfoText() {
        return driver.findElement(editAccountInfo).getText();
    }
    
    public String passwordConfirmErrorMessage() {
    	return driver.findElement(errorMessage).getText();
    	
    }
    
   
}