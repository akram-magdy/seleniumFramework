package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase{
	
	public static WebDriver driver;
	
	
	@BeforeSuite
	@Parameters ({"browser"})
	public void StartDriver(@Optional("chrome") String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			String Pathchrome = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", Pathchrome);
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			String PathFireFox = System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driverr", PathFireFox);
		}
		
		else if (browserName.equalsIgnoreCase("ie")) {
			String Pathie = System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driverr", Pathie);
		}
			
			
			else if (browserName.equalsIgnoreCase("phantomJS")) {
				
				DesiredCapabilities caps =new DesiredCapabilities();
				caps.setJavascriptEnabled(true);
				caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
						System.getProperty("user.dir")+"\\drivers\\phantomjs.exe");
				String[] phantomJsArgs = {"--web-security=no","--ignore-ssl-error=yes"};
				caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, phantomJsArgs);
				driver = new PhantomJSDriver();
		}
		
		String Pathchrome = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Pathchrome);
		driver = new ChromeDriver();
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
		
		@AfterSuite
		public void StopDriver() {
			
			driver.quit();
		}
		
		@AfterMethod
		public void screenshotOnFailure(ITestResult result) 
		{
			if (result.getStatus() == ITestResult.FAILURE)
			{
				System.out.println("Failed!");
				System.out.println("Taking Screenshot....");
				Helper.captureScreenshot(driver, result.getName());
			}
		}
		
	}
	
