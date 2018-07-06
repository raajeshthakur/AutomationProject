package UserInformation;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Baseclasses.Testbase;
import common.WebDriversFactory;
import common.WaitForAction;

public class AccountInformation
{
	
	WebDriver driver;

@Test
 public void  AccountInformation() throws InterruptedException
    	
    {
	 	this.driver= WebDriversFactory.getWebDriversInstance("firefox");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
		driver.get("http://onekingslane.com/");
	 	WaitForAction.Sleep(1000);
	 	driver.findElement(By.cssSelector("span.ml-topnav-identity-link")).click();
	 	WaitForAction.Sleep(1000);
	    driver.findElement(By.name("loginEmail")).sendKeys("344@test.com");
	    System.out.println("344@test.com");
	    WaitForAction.Sleep(1000);
	    driver.findElement(By.name("loginPassword2")).sendKeys("344@test.com");

		System.out.println("344@test.com");

		driver.findElement(By.id("btnContinueAccountSetupFormLogin")).click();
	  	
		WaitForAction.Sleep(1000);
    	WebElement el;
		el=driver.findElement(By.xpath("/html/body/header/nav/div[4]/div/div/div/div[2]/div[6]/div/div[1]/div[1]/div/span/span/a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].move", el);
		Actions action = new Actions(driver);
		action.moveToElement(el).moveToElement(driver.findElement(By.xpath("/html/body/header/nav/div[4]/div/div/div/div[2]/div[6]/div/div[1]/div[1]/div/span/span/a[1]"))).build().perform();
		driver.findElement(By.xpath("/html/body/header/nav/div[4]/div/div/div/div[2]/div[6]/div/div[1]/div[1]/div/span/span/a[1]")).click();
    	
    	//driver.findElement(By.xpath("//div[@class='ml-header-link-item']//span[@class='ml-topnav-identity']//span[@class='ml-myaccount-pulldown']")).click();
       
		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].move", el);**/
	  
    } 
  
}
