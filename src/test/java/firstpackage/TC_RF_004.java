package firstpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

@Test
public class TC_RF_004 {

	public void NullRegister() {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        // Navigate to website
        driver.get("https://tutorialsninja.com/demo/");

        // Navigate to registration form
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Register']")).click();
//  driver.findElement(By.id("input-firstname")).sendKeys("something");

       
        // Submit the form
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        // Validate error messages
       Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and')]")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and')]")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be')]")).isDisplayed());;
       Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and')]")).isDisplayed());

       Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and')]")).isDisplayed());
       Assert.assertTrue(driver.findElement(By.xpath("//div[@id='account-register']//following-sibling::div/i")).isDisplayed());

        // Cleanup
        driver.quit();
    }
}
