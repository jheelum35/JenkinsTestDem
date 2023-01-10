package Reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListeners implements ITestListener	{
	
	
	public ExtentReports  extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> extentTest =new  ThreadLocal<ExtentTest>();
	 @Override		
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	      		
		 if(extent !=null)
		 {
			 extent.flush();
		 }
		 
	    }		

	    @Override		
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailure(ITestResult result) {					
	        // TODO Auto-generated method stub	

	    	String LogText ="<b> Test Method"+result.getMethod().getMethodName()+"Failed</b>";
	    	Markup m = MarkupHelper.createLabel(LogText, ExtentColor.RED);
	    	extentTest.get().log(Status.FAIL, m);
	        		
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult result) {					
	        // TODO Auto-generated method stub				
	    	String LogText ="<b> Test Method"+result.getMethod().getMethodName()+"Skipped</b>";
	    	Markup m = MarkupHelper.createLabel(LogText, ExtentColor.AMBER);
	    	extentTest.get().log(Status.FAIL, m);  		
	    }		

	    @Override		
	    public void onTestStart(ITestResult result) {					
	    	ExtentTest test =extent.createTest(result.getClass().getName()+
	    			"::"+result.getMethod().getMethodName());  
	    	extentTest.set(test);
	    }		

	    @Override		
	    public void onTestSuccess(ITestResult result) {	
	    	
	    	String LogText ="<b> Test Method"+result.getMethod().getMethodName()+"Sucessfull</b>";
	    	Markup m = MarkupHelper.createLabel(LogText, ExtentColor.GREEN);
	    	extentTest.get().log(Status.PASS, m);
	      

}
	    
	    

		public static void Info(String strAction,final String strExpected) {
			
			final StringBuilder strbStepDetails = new StringBuilder();
	        strbStepDetails.append("<FONT COLOR='BLUE'><b>Action := </b>");
	        strbStepDetails.append(strAction + "</FONT>");
	        strbStepDetails.append((strExpected != null && !strExpected.equals("")) ? ("<br><FONT COLOR='GREEN'><b>Result := </b>" + strExpected + "</FONT>") : "");
	        extentTest.get().log(Status.PASS, strbStepDetails.toString());
	       
			
		}

}
