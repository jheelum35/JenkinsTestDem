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
	
	private WebDriver driver;
	DesiredCapabilities  dc= new DesiredCapabilities();
	
	public WebDriver getBrowser() {
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeoptions = new ChromeOptions();
		//chromeoptions.addArguments("--headless");
		
		return  new ChromeDriver(chromeoptions);
	
		


}
	@Override
	public WebDriver getBrowser(String grid_enabled,String BrowserName,String  ip,String port) {
		
		
		
		
			
		dc.setBrowserName("chrome");
		
			
		dc.setCapability("platformName", Platform.MAC);
			try {
			new RemoteWebDriver(new URL ("http://localhost:4444"),dc);
				driver.manage().window().maximize();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return driver;
		}
	
		


}

