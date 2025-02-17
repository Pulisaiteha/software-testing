package firstpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 {
	
	WebDriver driver=new ChromeDriver();

	@Test(priority=0)
	public void RegisterWays() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("https://tutorialsninja.com/demo/");
	}
	
	@Test(priority=1)
	public void assertOne() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();	
		String regVer=driver.findElement(By.xpath("//div[@id='content']//child::p")).getText();
		String dataVer="If you already have an account with us, please login at the login page.";
		Assert.assertEquals(regVer, dataVer);
		System.out.println(regVer);
		}
		
		@Test(priority=2)
		public void assertTwo() {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
    String loginPageVer=driver.findElement(By.xpath("//div[@class='well']/h2")).getText();
		System.out.println(loginPageVer);
		
		String dataVer2="New Customer";		
		Assert.assertEquals(loginPageVer,dataVer2 );
		
//		driver.close();
		}

		@Test(priority=3)
		public void assetThree() {
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
			
			String dataVer3="If you already have an account with us, please login at the login page.";
			String regVer3=driver.findElement(By.xpath("//div[@id='content']//child::p")).getText();
			System.out.print(regVer3);
			Assert.assertEquals(regVer3,dataVer3);
			

		}
		
		@Test(priority=4)
		public void assertFour() {
			
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/ul/li[2]/a")).click();
			String loginPageVer=driver.findElement(By.xpath("//div[@class='well']/h2")).getText();
			System.out.println(loginPageVer);
			
			String dataVer2="New Customer";		
			Assert.assertEquals(loginPageVer,dataVer2 );
			
			
		}
		@Test(priority=5)
		public void assertFive() {
			driver.findElement(By.xpath("//div[@class='list-group']/a[2]")).click();

			String dataVer3="If you already have an account with us, please login at the login page.";
			String regVer3=driver.findElement(By.xpath("//div[@id='content']//child::p")).getText();
			System.out.print(regVer3);
			Assert.assertEquals(regVer3,dataVer3);
			
		}
		

	

}
