package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BrowserFactory.BrowserFactory;
import BrowserFactory.IBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	private WebDriver driver;
	private RemoteWebDriver remoteWebdriver;
	
	private   Properties properties;
	
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	private  Properties getProperty()
	{
		 final Properties properties = new Properties();
			final InputStream in = this.getClass().getClassLoader().getResourceAsStream("Config.properties");
	        try {
				properties.load(in);
			}  catch (FileNotFoundException ex) {
				ex.printStackTrace();
	            //TestProperties.log.error(this.getClass().getName() + " property file not found in the classpath");
	        }
	        catch (IOException ex2) {
	        	ex2.printStackTrace();
	            //TestProperties.log.error(this.getClass().getName() + " Error reading file");
	        }
			return properties;
	}
	@BeforeMethod
	public void setup() throws IOException {
		
		
		
		Properties properties =getProperty();
		BrowserFactory browserFactory = new BrowserFactory();
		IBrowser browser = browserFactory.getBrowserType(properties.getProperty("Browser"));
		if(properties.getProperty("GRID_ENABLED").equals("N"))
		{
		
		driver = browser.getBrowser();
		System.out.println("-----Starting a Local Server------------");
		}
		else 
		{	
			System.out.println("user name  is ------>"+properties.getProperty("GRID_ENABLED"));
		
			driver=browser.getBrowser(properties.getProperty("GRID_ENABLED"), 
					properties.getProperty("Browser"), "", "4444");
			System.out.println("-----Startinng a Remote Server------------");
			
		}
		
		System.out.println(properties.getProperty("URL"));
		driver.manage().window().maximize();
		//driver.get(properties.getProperty("URL"));
		
		
		System.out.println("user name  is ------>"+properties.getProperty("pword"));
		

	}
	
	
	//@Test
	public void test1()
	{
		System.out.println("this is a sucess");
		
	}
@AfterClass
public void Endsetup()
{
	
}
@AfterMethod
	public void teardown() {
		getDriver().quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}