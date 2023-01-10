package RegressionTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ToolTipValidation  extends BaseTest{
	
	
	@Test
	public void ToolTip_example()
	{	
		getDriver().get("https://jqueryui.com/tooltip/");
		
		for(WebElement ele:getDriver().findElements(By.tagName("iframe"))) {
			getDriver().switchTo().frame(ele);
			WebElement ageTextBox = 	getDriver().findElement(By.id("age"));
			if(ageTextBox.isDisplayed())
			{
			System.out.println(getDriver().findElement(By.id("age")).getAttribute("title"));
			getDriver().findElement(By.id("age")).sendKeys("23");
			
		}
			
		}
	}

}
