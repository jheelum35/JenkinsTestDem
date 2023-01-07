package utils;

import java.io.IOException;
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
	private Properties prop ;
	private Properties prop2;
	

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	public Properties getProp2() {
		return prop2;
	}

	public void setProp2(Properties prop2) {
		this.prop2 = prop2;
	}

	@BeforeMethod
	public void setup() throws IOException {

		prop2 = new Properties();
		
		prop2.load(BaseTest.class.getClassLoader().getResourceAsStream("Config.properties"));
		//Properties prop = IOUtils
			//	.loadProperties("//Users//anirban//Documents//JenkinsTestDem//Test//Config.properties");
		BrowserFactory browserFactory = new BrowserFactory();
		IBrowser browser = browserFactory.getBrowserType(prop2.getProperty("Browser"));
		driver = browser.getBrowser();
		System.out.println("Build Number is ------>"+prop2.getProperty("jenkins.build.number"));
				System.out.println(prop2.getProperty("URL"));
		driver.manage().window().maximize();
		driver.get(prop2.getProperty("URL"));

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