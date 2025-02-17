package firstpackage;

import org.testng.Assert;
import utilities.EmailFunction;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_RF_005 {
	
   @Test
   public void verifyRegister()  {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
         driver.findElement(By.xpath("//a[text()='Register']")).click();
         
     driver.findElement(By.name("firstname")).sendKeys("saii");
     driver.findElement(By.name("lastname")).sendKeys("tejaa");
     driver.findElement(By.name("email")).sendKeys(EmailFunction.generateUniqueEmail());
     driver.findElement(By.id("input-telephone")).sendKeys("9866061684");
     driver.findElement(By.name("password")).sendKeys("Qwerty8@");
     driver.findElement(By.name("confirm")).sendKeys("Qwerty8@");
     
     driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
     
     driver.findElement(By.name("agree")).click();
     
     driver.findElement(By.xpath("//input[@value='Continue']")).click();
    
//     assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     WebElement logoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
     Assert.assertTrue(logoutElement.isDisplayed());
     
     String accsuc="Your Account Has Been Created!";
     String ele=driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created')]")).getText();
    
    Assert.assertEquals(ele,accsuc);
         
    String info1="Congratulations! Your new account has been successfully created!";
    String info2="You can now take advantage of member privileges to enhance your online shopping experience with us.";
    String info3="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
    		
  String allinfo=  driver.findElement(By.id("content")).getText();
  
  Assert.assertTrue(allinfo.contains(info1));
  Assert.assertTrue(allinfo.contains(info2));
  Assert.assertTrue(allinfo.contains(info3));
  
  driver.findElement(By.xpath("//a[text()='Continue']")).click();
  
 String data= driver.findElement(By.linkText("Edit your account information")).getText();
 Assert.assertEquals(data,"Edit your account information");   
 
 driver.findElement(By.xpath("//div[@id='content']//child::ul[last()]//child::a")).click();
 
 
 Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected(),"yes checkbox selected");
	
   }
}
