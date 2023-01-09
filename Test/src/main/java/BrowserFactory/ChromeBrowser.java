package BrowserFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class ChromeBrowser implements IBrowser {
	protected  static ThreadLocal<WebDriver>  webdriver = new ThreadLocal<>();
	protected  static ThreadLocal<RemoteWebDriver>  remotewebdriver = new ThreadLocal<>();
	private WebDriver driver;
	DesiredCapabilities  dc= new DesiredCapabilities();
	
	public WebDriver getBrowser() {
	// usage of thread local
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeoptions = new ChromeOptions();
		//chromeoptions.addArguments("--headless");
		 webdriver.set(new ChromeDriver(chromeoptions));
		 return webdriver.get();
		  
	
		


}
	
	
	public  WebDriver  getBrowser(String grid_enabled,String BrowserName,String  ip,String port) {
		
		
		
		
			
		dc.setBrowserName("chrome");
		
			
		dc.setCapability("platformName", Platform.MAC);
			try {
			
			remotewebdriver.set(new RemoteWebDriver(new URL ("http://192.168.0.105:4444"),dc));
				//driver.manage().window().maximize();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return remotewebdriver.get();
		}
	
		


}

