package Reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	public static String UTF="utf-8";
	public static String  TITLE="Automation Reports";
	public static String REPORTNAME="Automation Test Result";
	public static String COMPANYNAME="JheelumAutomationReport";
	public static String Enviornments="Production";
	
	public  static ExtentReports createInstance()
	{
		String fileName = getReportName();
		String directory = System.getProperty("user.dir")+"/reports/";
		
		new File(directory).mkdir();
		String path = directory+fileName;
		
		
		//ExtentHtmlReporter htmlReporter  = new ExtentHtmlReporter(path);
		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter(path);
		htmlReporter.config().setEncoding(UTF);
		htmlReporter.config().setDocumentTitle(TITLE);
		htmlReporter.config().setReportName(REPORTNAME);
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent= new ExtentReports();
		extent.setSystemInfo(COMPANYNAME, Enviornments);
		extent.attachReporter(htmlReporter);
		return extent;
	}
	
	public static String getReportName()
	{
		Date d= new Date ();
		
		String filename="APIAutomationReport_"+d.toString().replace(":","_" ).replace(" ", "_")+".html";
		return filename;
		
	}

}
