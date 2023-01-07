package RegressionTest;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import utils.BaseTest;

public class Test2 extends BaseTest{

	@Test
	public void getData() throws IOException
	{
		Properties prop = new Properties();
		
		prop.load(Test2.class.getClassLoader().getResourceAsStream("Config.properties"));
		System.out.println(prop.getProperty("uname"));
		System.out.println(prop.getProperty("pword"));
	}
}
