package firstpackage;

import java.time.Duration;
import automation.liveProject.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import utilities.EmailFunction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_RF_17 {
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
    
    @Test(dataProvider="passwords")
    public void verifyPassword(String pass) {
    	
    	registerPage.navigateToRegisterPage();
    	registerPage.enterFirstName("sai");
    	registerPage.enterLastName("teja");
    	registerPage.enterEmail(EmailFunction.generateUniqueEmail());
    	registerPage.enterTelephone("6309375689");
    	registerPage.enterPassword(pass);
    	registerPage.confirmPassword(pass);
    	registerPage.acceptTerms();
    	registerPage.submitRegistration();
    	
     String success = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
        System.out.println(success);
  Assert.assertTrue(!success.contains("Your Account Has Been Created!"));
    }
  
    @DataProvider(name="passwords")
    public Object[][] datas() {
    	
    	Object[][] data= { 
    			       {"12345"},{"abcdefghi"},{"abcd1234"},{"abcd123$"},{"abcd1234#"},{"ABCD1234$"}
    			       
    			       
    	}; 
    	return data;
    }
}
    

