package BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface IBrowser {
	
	
	public WebDriver getBrowser(String string, String string2, String string3, String string4);


	public WebDriver getBrowser();


}
