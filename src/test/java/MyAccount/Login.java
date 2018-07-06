package MyAccount;

import org.testng.annotations.Test;

import common.WebDriversFactory;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;


public class Login 
{
	
	WebDriver driver;

@BeforeTest
	  public void beforeTest() {
	
	this.driver=WebDriversFactory.getWebDriversInstance("firefox");
	driver.manage().window().maximize();
	//driver = new FirefoxDriver();
    //System.setProperty("webdriver.geckodriver.driver", "/Volumes/D/selenium/com.onekingslane.automation/src/test/resources/Drivers/geckodriver");
    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

	  }
  @Test
  public void f() throws InterruptedException {
	  //driver.get("http://onekingslane-v162-rev3.aws.marketlive.com/");
	  	driver.get("https://onekingslane.com");

		}
 
  @AfterMethod	
	public void tearDown()
	{
	driver.manage().deleteAllCookies();
	//WebDriversFactory.killWebdriver();
	}
		}


