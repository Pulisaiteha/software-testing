package firstpackage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.liveProject.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.EmailFunction;

public class TC_RF_18 {
	
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

       String height = driver.findElement(By.xpath("//input[@name='firstname']")).getCssValue("height");
       String width = driver.findElement(By.xpath("//input[@name='firstname']")).getCssValue("width");
        
System.out.println(height);
System.out.println(width);

Assert.assertEquals("34px", height);
Assert.assertEquals("701.25px", width);


        
        driver.quit();
    }

}
