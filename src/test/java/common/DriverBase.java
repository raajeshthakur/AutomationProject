package common;

/**
 * Created by Karan on 11/15/2015.
 */
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//import com.gargoylesoftware.htmlunit.javascript.host.Map;

/**
 * Base Class for all test cases. Test suites should extend this class
 *
 * This class will provide logging, execution on the TestNg grid
 */
public class DriverBase {

	private static WebDriver driver;
	private DesiredCapabilities capabilities;
	private URL url = null;
	private static String baseUrl = null;
	private static boolean standalone;
	private String refNumber;
	private String domain;
	private String organization;
	private String username_prefix;
	private String password;
	public static String OS;

	/**
	 * Defines if this test run is an offical run. If this is true then the
	 * results should be uploaded to the test result repository (Target Process)
	 */
	public boolean officalRun;

	/**
	 * Constants used to sleep for 2 seconds
	 */
	public final int VERY_SHORT_SLEEP = 2000;

	/**
	 * Constants used to sleep for 5 seconds
	 */
	public final int SHORT_SLEEP = 5000;

	/**
	 * Constants used to sleep for 8 seconds
	 */
	public final int MID_SLEEP = 8000;

	/**
	 * Constants used to sleep for 12 seconds
	 */
	public final int LONG_SLEEP = 12000;

	/**
	 * Starts the GridHost Session for a given platform, browser, system under
	 * test
	 *
	 * This is called internally by the framework and should not be called by
	 * the test
	 */
	@Parameters({ "GRIDHOST", "DOMAIN", "ORGANIZATION", "USERNAME_PREFIX",
			"PASSWORD", "REFNUMBER", "BROWSER", "PLATFORM", "VERSION",
			"SYSTEMUNDERTEST", "OFFICALRUN" })
	@BeforeClass
	protected void StartSession(ITestContext context,
			@Optional(" ") String GRIDHOST, @Optional(" ") String DOMAIN,
			@Optional(" ") String ORGANIZATION,
			@Optional(" ") String USERNAME_PREFIX,
			@Optional(" ") String PASSWORD, @Optional(" ") String REFNUMBER,
			@Optional(" ") String BROWSER, @Optional(" ") String PLATFORM,
			@Optional(" ") String VERSION,
			@Optional(" ") String SYSTEMUNDERTEST,
			@Optional(" ") String OFFICALRUN) {

		String gridHost = GRIDHOST;
		refNumber = REFNUMBER;
		domain = DOMAIN;
		organization = ORGANIZATION;
		username_prefix = USERNAME_PREFIX;
		password = PASSWORD;
		OS= "Windows";
		String browser = BROWSER;
		String version = VERSION;
		String platform = PLATFORM;
		String officalrun = OFFICALRUN;

		baseUrl = SYSTEMUNDERTEST;

		if (gridHost.equals(" "))
			gridHost = "standalone";
		if (browser.equals(" "))
			browser = "htmlunit";
		if (version.equals(" "))
			version = "ANY";
		if (platform.equals(" "))
			platform = "WINDOWS";
		if (baseUrl.equals(" "))
			baseUrl = "https://smbox:8080";
		if (officalrun.equals(" ")) {
			this.officalRun = false;
		}

		else {
			if (officalrun.equalsIgnoreCase("true")) {
				this.officalRun = true;
			} else {
				this.officalRun = false;
			}
		}

		if (!StartWebDriverSession(context, platform, browser, version,
				gridHost)) {
			System.out.println("Unable to initialize WebDriver");
			System.exit(-1);
		}

	}

	/**
	 * Closes the session
	 *
	 * This is called internally by the framework and should not be called by
	 * the test
	 */
	@AfterClass
	protected void CloseWebDriverSession() {
		try {
			// Calling quit since that will end the entire session and not just
			// a single window
			driver.quit();
		} catch (Exception e) {
			System.out.println("Exception Closing Session: " + e.toString());
		}
	}

	/**
	 * Starts the GridHost Session for a given platform, browser, system under
	 * test
	 *
	 * This is called internally by the framework and should not be called by
	 * the test
	 */
	public boolean StartWebDriverSession(ITestContext context, String platform,
			String browser, String version, String host) {

		standalone = false;
		if (host.equalsIgnoreCase("standalone"))
			standalone = true;
		String hostStr = "http://" + host + ":4444/wd/hub";
		// String hostStr = "http://127.0.0.1:4444/wd/hub";

		try {
			switch (browser) {

			case "iexplorer":
				if (standalone) {
					System.setProperty("webdriver.ie.driver","D:\\selenium\\com.onekingslane.automation\\src\\test\\resources\\Drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
					WaitForAction.Sleep(3000);
				} else {
					capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setBrowserName("internet explorer");
					capabilities.setVersion(version);
					capabilities.setPlatform(Platform.valueOf(platform));
					url = new URL(hostStr);
					driver = new RemoteWebDriver(url, capabilities);
					driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
				}
				break;

			case "chrome":
				if (standalone) {
					ChromeOptions options = new ChromeOptions();
					options.addArguments("chrome.switches","--disable-extensions");
					options.addArguments("start-maximized");
					System.setProperty("webdriver.chrome.driver",
							"D:\\selenium\\com.onekingslane.automation\\src\\test\\resources\\Drivers\\chromedriver.exe");
					driver = new ChromeDriver(options);
				} else {
					capabilities = DesiredCapabilities.chrome();
					capabilities.setBrowserName("chrome");
					capabilities.setVersion(version);
					capabilities.setPlatform(Platform.valueOf(platform));
					url = new URL(hostStr);
					driver = new RemoteWebDriver(url, capabilities);
				}
				break;

			case "firefox":
				if (standalone) {
					driver = new FirefoxDriver();
				} else {
					capabilities = DesiredCapabilities.firefox();
					capabilities.setBrowserName("firefox");
					capabilities.setPlatform(Platform.valueOf(platform));
					url = new URL(hostStr);
					driver = new RemoteWebDriver(url, capabilities);
				}
				break;
				
			case "opera":
				if (standalone) {
					/*ChromeOptions options = new ChromeOptions();
					options.addArguments("chrome.switches","--disable-extensions");
					System.out.println("Opening Opera");
					System.setProperty("webdriver.chrome.driver",
							"C:\\operadriver_win32\\operadriver.exe");
					driver = new ChromeDriver();*/
					/*
					System.setProperty("webdriver.opera.driver", "C:\\operadriver_win32\\operadriver.exe");
					driver = new OperaDriver();*/
					
					capabilities = DesiredCapabilities.opera();

					ChromeOptions options = new ChromeOptions();
					options.setBinary("C:\\operadriver_win32\\operadriver.exe");
					System.setProperty("webdriver.chrome.driver",
							"C:\\operadriver_win32\\operadriver.exe");
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					driver = new ChromeDriver(capabilities);
					
				} else {
					capabilities = DesiredCapabilities.chrome();
					capabilities.setBrowserName("opera");
					capabilities.setVersion(version);
					capabilities.setPlatform(Platform.valueOf(platform));
					url = new URL(hostStr);
					driver = new RemoteWebDriver(url, capabilities);
				}
				break;
				
			case "safari":
				if (standalone) {
					
					
					driver = new SafariDriver();
				} else {
					capabilities = DesiredCapabilities.safari();
					capabilities.setBrowserName("safari");
					capabilities.setVersion(version);
					capabilities.setPlatform(Platform.valueOf(platform));
					url = new URL(hostStr);
					driver = new RemoteWebDriver(url, capabilities);
				}
				break;

			default:
				if (standalone) {
					driver = new HtmlUnitDriver();
				} else {
					capabilities = DesiredCapabilities.htmlUnit();
					capabilities.setBrowserName("htmlunit");
					capabilities.setPlatform(Platform.valueOf(platform));

					url = new URL(hostStr);
					driver = new RemoteWebDriver(url, capabilities);
					DesiredCapabilities.htmlUnit();
				}

			}
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println("Exception Loading Driver: " + e.toString());
			return false;
		}

		context.setAttribute("driver", driver);
		context.setAttribute("standalone", standalone);
		context.setAttribute("browser", browser);
		context.setAttribute("version", version);

		if (!browser.contentEquals("htmlunit")) {
			driver.get(baseUrl);
		}
		return true;
	}	

	/**
	 * Gets the Web Driver object used for the test
	 *
	 * @return the web driver object
	 */
	public WebDriver GetDriver() {
		return driver;
	}
	
	/**
	 * Sets the Web Driver object used for the test
	 *
	 */
	public void SetDriver(WebDriver driver) {
		this.driver = driver; 
	}

	/**
	 * Gets the Ref Number used for the test
	 *
	 * @return String
	 */
	public String getRefNumber() {
		return refNumber;
	}

	/**
	 * Gets the Domain name used for the Login
	 *
	 * @return String
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * Gets the Organization name used for the Login
	 *
	 * @return String
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * Gets the Username Prefix used for the Login
	 *
	 * @return String
	 */
	public String getUsernamePrefix() {
		return username_prefix;
	}

	/**
	 * Gets the Password used for the Login
	 *
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the base URL of the system under test
	 *
	 * This is defined in the testng XML file defined for this test.
	 *
	 * @return The base url
	 */
	public String GetBaseUrl() {
		return baseUrl;
	}

	/**
	 * Sleeps for the specified milliseconds
	 *
	 * @param milliseconds
	 *            The time to sleep
	 */
	public void sleep(long milliseconds) {
		WaitForAction.Sleep(milliseconds);
	}

}