package RegressionTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.testng.annotations.Test;

import utils.BaseTest;



public class Test1 extends BaseTest {


	@Test
	public void Login()
	{
		
		
		List<WebElement>element=getDriver().findElements(By.xpath("//div[@class='category-cards']//child::h5"));
		
			for(WebElement ele:element)
			{ 
				String  srr= ele.getAttribute("outerText");
				 if(srr.equalsIgnoreCase("Elements"))
				 {
				 AssertJUnit.assertEquals("Elements", srr);
				 ele.click();
				break;
				 }
				 
				}
		
			System.out.println((getDriver().getTitle()));
	}

}
