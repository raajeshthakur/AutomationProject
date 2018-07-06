package STLlessions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Navharwaynorman 
{
WebDriver driver;

@Test
public void hnfggggg()  
{
		
	
	System.setProperty("webdriver.chrome.driver", "/Volumes/D/selenium/com.onekingslane.automation/src/test/resources/Drivers/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    

    //driver.get("http://onekingslane-v162-rev3.aws.marketlive.com/");;
    driver.get("https://www.harveynorman.com.au");
}}
