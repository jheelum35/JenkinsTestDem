package RegressionTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Test3 extends BaseTest {
	
	
	
	@Test
	public void test1_ToValidAuthentication()
	{
		getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String str=getDriver().findElement(By.xpath("//*[normalize-space(text()) = 'Congratulations! You must have the proper credentials.']")).getText();
		
	AssertJUnit.assertEquals(str, "Congratulations! You must have the proper credentials.");
	}
	

}
