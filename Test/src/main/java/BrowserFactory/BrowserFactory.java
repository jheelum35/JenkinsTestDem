package BrowserFactory;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
	
	public IBrowser getBrowserType(String browserType){
	      if(browserType == null){
	         return null;
	      }		
	      if(browserType.equalsIgnoreCase("chrome")){
	         return new ChromeBrowser();
	         
	      } else if(browserType.equalsIgnoreCase("ff")){
	         return new FireFoxBrowser();
	         
	      } else if(browserType.equalsIgnoreCase("safari")){
	         return new SafariBrowser();
	      }
	      
	      return null;
	   }
	}