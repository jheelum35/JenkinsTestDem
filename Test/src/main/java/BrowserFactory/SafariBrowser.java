package BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SafariBrowser implements  IBrowser{

		private WebDriver driver;
		
		@Override
		public WebDriver getBrowser(String string, String string2, String string3, String string4) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public WebDriver getBrowser() {
			// TODO Auto-generated method stub
			return null;
		}

}
