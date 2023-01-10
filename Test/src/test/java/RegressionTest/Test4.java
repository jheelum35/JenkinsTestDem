package RegressionTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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



public class Test4 extends BaseTest {


	@Test
	public void testFrame()
	{
		getDriver().get("https://demoqa.com/frames");
		
		getDriver().switchTo().frame("frame1");
		String text=getDriver().findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
	}

}
