package firstpackage;

import java.time.Duration;
import automation.liveProject.RegisterLocators;
import utilities.EmailFunction;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.liveProject.RegisterLocators;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_RF_008_POM {

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
    
    @Test(priority=0)
    public void testfunction() {

    	registerPage.navigateToRegisterPage();
    	registerPage.enterFirstName("sai");
    	registerPage.enterLastName("teja");
    	registerPage.enterEmail(EmailFunction.generateUniqueEmail());
    	registerPage.enterTelephone("6309375689");
    	registerPage.enterPassword("12345");
    	registerPage.confirmPassword("abcde");
    	registerPage.acceptTerms();
    	registerPage.submitRegistration();
    	registerPage.passwordConfirmErrorMessage();
    	registerPage.passwordConfirmErrorMessage();
    	String actualMessage="Password confirmation does not match password!";
		
  	Assert.assertTrue(registerPage.passwordConfirmErrorMessage().contains(actualMessage));
    }    
}
