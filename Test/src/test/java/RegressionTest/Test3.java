package RegressionTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utils.BaseTest;

public class Test3 extends BaseTest {
	
	
	
	@Test
	public void test1_ToValidAuthentication()
	{
		getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String str=getDriver().findElement(By.xpath("//*[normalize-space(text()) = 'Congratulations! You must have the proper credentials.']")).getText();
		
	Assert.assertEquals(str, "Congratulations! You must have the proper credentials.");
	}
	

}
