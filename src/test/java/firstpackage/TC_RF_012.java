package firstpackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.liveProject.RegisterLocators;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_012 {

		WebDriver driver;
	    RegisterLocators registerPage;

	    @BeforeTest
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.manage().window().maximize();
	        driver.get("https://tutorialsninja.com/demo/");
	        registerPage = new RegisterLocators(driver);
	    }
	    
	    @Test
	    public void emailWrong() throws InterruptedException, IOException {
	    	
	    	registerPage.navigateToRegisterPage();
	    	registerPage.enterFirstName("sai");
	    	registerPage.enterLastName("teja");
	    	registerPage.enterEmail("saitejapuli");
	    	registerPage.enterTelephone("6309375689");
	    	registerPage.enterPassword("12345");
	    	registerPage.confirmPassword("abcde");
	    	registerPage.acceptTerms();
	    	registerPage.submitRegistration();
//	    	registerPage.passwordConfirmErrorMessage();
//    	registerPage.passwordConfirmErrorMessage();
	    	
	    	Thread.sleep(3000);
	    File screenS=driver.findElement(By.className("form-horizontal")).getScreenshotAs(OutputType.FILE);
	    FileHandler.copy(screenS,new File(System.getProperty("user.dir")+"\\ScreenShots\\imageAct.png"));
	    	
	   BufferedImage actualImage = ImageIO.read(new File(System.getProperty("user.dir")+"\\ScreenShots\\imageAct.png"));
	   BufferedImage excpectImage = ImageIO.read(new File(System.getProperty("user.dir")+"\\ScreenShots\\imageExc.png"));
	 
	   ImageDiffer imgD=new ImageDiffer();
	   ImageDiff imgDifference = imgD.makeDiff(excpectImage, actualImage);
	   
	  boolean b= imgDifference.hasDiff();
	  System.out.println(b);
	   
	   Assert.assertFalse(imgDifference.hasDiff()); 

	    }
}
