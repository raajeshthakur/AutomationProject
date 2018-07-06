package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriversFactory {
	private WebDriversFactory(){};
	private static WebDriver getWebdriver = null;
	public static WebDriver getWebDriversInstance(String browser)
	{
	 if (getWebdriver == null)
		
	 {
		 switch (browser.toLowerCase())
		 {
		 case "firefox":firefoxDeriversetup();
		 getWebdriver= new FirefoxDriver();
		 break;
		 case "chrome": chromeDriversetup();
		 getWebdriver= new ChromeDriver();
		 break;
		 
		 default: firefoxDeriversetup();
		 }
	 }
	 return getWebdriver;
	}
	private static void chromeDriversetup() {
		System.setProperty("webdriver.chrome.driver", "/Volumes/D/SeleniumAutomation/src/main/resources/Drivers/chromedriver");
		//getWebdriver= new ChromeDriver();
	}
	private static void firefoxDeriversetup() {
		System.setProperty("webdriver.geckodriver.driver", "/Volumes/D/SeleniumAutomation/src/main/resources/Drivers/geckodriver");
		//getWebdriver= new FirefoxDriver();
	}
	
public static void killWebdriver()
{
if (getWebdriver!=null)
{
	getWebdriver.quit();
	getWebdriver=null;
}
	
}
}
