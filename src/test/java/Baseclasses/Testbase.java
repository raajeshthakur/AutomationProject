package Baseclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.WebDriversFactory;

public class Testbase {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setup ()
	{
		this.driver=WebDriversFactory.getWebDriversInstance("chrome");
		driver.manage().window().maximize();
		//driver.get("http://onekingslane-v162-rev2.aws.marketlive.com/");
		driver.get("http://onekingslane.com/");
		
		
	}
	/**@AfterMethod	
	public void tearDown()
	{
	//driver.manage().deleteAllCookies();
	driver.manage().getCookies();
	//WebDriversFactory.killWebdriver();
	}**/
		}

