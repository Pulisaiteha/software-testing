package firstpackage;

import java.time.Duration;
import utilities.EmailFunction;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.liveProject.RegisterLocators;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_RF_12 {


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
    public void Tab() {
    	
    	registerPage.navigateToRegisterPage();
    	
    	Actions act=new Actions(driver);
    	
    	for(int i=1;i<=23;i++) {
    	act.sendKeys(Keys.TAB).perform();
    	}
    	act.sendKeys("sai").perform();
    	act.sendKeys(Keys.TAB).perform();
    	
    	act.sendKeys("teja").perform();
    	act.sendKeys(Keys.TAB).perform();
    	
    	act.sendKeys(EmailFunction.generateUniqueEmail()).perform();
    	act.sendKeys(Keys.TAB).perform();

    	act.sendKeys("9866061684").perform();
    	act.sendKeys(Keys.TAB).perform();

    	act.sendKeys("Qwerty8@").perform();
    	act.sendKeys(Keys.TAB).perform();

    	act.sendKeys("Qwerty8@").perform();
    	act.sendKeys(Keys.TAB).perform();
    	
    	act.sendKeys(Keys.LEFT).perform();
    	
    	act.sendKeys(Keys.TAB).perform();
    	act.sendKeys(Keys.TAB).perform();
    	
    	act.sendKeys(Keys.SPACE).perform();
    	act.sendKeys(Keys.TAB).perform();

    	act.sendKeys(Keys.ENTER).perform();




    	
    }
    
   
}
