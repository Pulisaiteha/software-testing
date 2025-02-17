package firstpackage;

import automation.liveProject.RegisterLocators;
import utilities.EmailFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class TC_001_POM {

    WebDriver driver;
    RegisterLocators registerPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        registerPage = new RegisterLocators(driver);
    }

    @Test
    public void RegisterVerify() {
        registerPage.navigateToRegisterPage();
        registerPage.enterFirstName("saii");
        registerPage.enterLastName("tejaa");
        registerPage.enterEmail(EmailFunction.generateUniqueEmail());
        registerPage.enterTelephone("9866061684");
        registerPage.enterPassword("Qwerty8@");
        registerPage.confirmPassword("Qwerty8@");
        registerPage.acceptTerms();
        registerPage.submitRegistration();

        Assert.assertTrue(registerPage.isLogoutDisplayed());

        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(registerPage.getAccountCreationMessage(), expectedMessage, "Account creation message mismatch");

        String content = registerPage.getContentText();
        Assert.assertTrue(content.contains("Congratulations! Your new account has been successfully created!"));
        Assert.assertTrue(content.contains("You can now take advantage of member privileges to enhance your online shopping experience with us."));
        Assert.assertTrue(content.contains("If you have ANY questions about the operation of this online shop, please e-mail the store owner."));

        registerPage.clickContinueAfterRegister();

        String editAccountText = registerPage.getEditAccountInfoText();
        Assert.assertEquals(editAccountText, "Edit your account information", "Edit account information text mismatch");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    
}