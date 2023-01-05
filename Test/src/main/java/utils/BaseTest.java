package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import BrowserFactory.BrowserFactory;
import BrowserFactory.IBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;
	private Properties prop ;
	

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	@BeforeMethod
	public void setup() {
		
		Properties prop = IOUtils
				.loadProperties("//Users//anirban//Documents//JenkinsTestDem//Test//Config.properties");
		BrowserFactory browserFactory = new BrowserFactory();
		IBrowser browser = browserFactory.getBrowserType(prop.getProperty("Browser"));
		driver = browser.getBrowser();

				System.out.println(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

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