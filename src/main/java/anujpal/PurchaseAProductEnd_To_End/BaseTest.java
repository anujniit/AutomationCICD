package anujpal.PurchaseAProductEnd_To_End;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

//	WebDriver localDriver;
//	WebDriverWait localWait;
	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	private static ThreadLocal<WebDriverWait> wait=new ThreadLocal<WebDriverWait>();
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	public WebDriverWait getWait() 
	{
		return wait.get();
	}
	
	@BeforeTest
	public void launchDriver()
	{
		String browser=ConfigReader.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			WebDriver localDriver=new ChromeDriver();
			WebDriverWait localWait = new WebDriverWait(localDriver, Duration.ofSeconds(30));
			
			driver.set(localDriver);
			wait.set(localWait);
			
			localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			localDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			localDriver.navigate().to(ConfigReader.getProperty("url"));
			localDriver.manage().window().maximize();
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		getDriver().quit();
		driver.remove();
		wait.remove();
		
	}
}
