package Tools;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import utils.TestClassUtils;
import utils.TestUtils;

public class UITools  extends  Tool{
	
	
	protected WebDriver webDriver;
    protected int nImplicitTimeOut;
    
    
    public UITools() {
        this.nImplicitTimeOut = 15;
    }
    
    public void accessURL(final String strURL) {
        int nCounter = 0;
        while (nCounter < 3) {
            try {
                this.webDriver.navigate().to(strURL);
            }
            catch (Exception ex) {
                TestUtils.sleep(5000);
                ++nCounter;
                continue;
            }
            break;
        }
    }
	public void back()
	{
		 this.webDriver.navigate().back();
	}
	public void forward()
	{
		this.webDriver.navigate().forward();
		
	}
	
	public void refresh()
	{
		this.webDriver.navigate().refresh();
	}
    public void closeDriver() {
        if (this.webDriver != null) {
            this.webDriver.close();
        }
    }
    
    public void quitDriver() {
        if (this.webDriver != null) {
            this.webDriver.quit();
            this.webDriver = null;
        }
    }
    
    public WebDriver getWebDriver() {
        return this.webDriver;
    }
    
    
    public boolean isDisplayed(final WebElement we) {
        try {
            TestClassUtils.assertNotNull(we);
            return we.isDisplayed();
        }
        catch (Exception ex) {
            return false;
        }
    }
   public boolean isEnabled1(final WebElement we)
   { 
	   try 
	   {
	   TestClassUtils.assertNotNull(we);
	   return we.isEnabled();
   }
   catch (Exception ex) {
       return false;
   }
	   
	   
}
   public boolean isDisplayed(final By by) {
       try {
           TestClassUtils.assertNotNull(by);
          
           final WebElement we = this.webDriver.findElement(by);
           return this.isDisplayed(we);
       }
       catch (Exception ex) {
           return false;
       }
   }
   

   
   public boolean isEnabled(final By by) {
       try {
           TestClassUtils.assertNotNull(by);
              final WebElement we = this.webDriver.findElement(by);
           return this.isEnabled1(we);
       }
       catch (Exception ex) {
           return false;
       }
   }
   
   public boolean isEnabled(final WebElement we) {
       try {
           TestClassUtils.assertNotNull(we);
           return we.isEnabled();
       }
       catch (Exception ex) {
           return false;
       }
   }
   
   public boolean isNotEnabled(final By by) {
       return !this.isEnabled(by);
   }
   
   public boolean isNotEnabled(final WebElement we) {
       return !this.isEnabled1(we);
   }
   
   public String getText(final WebElement we) {
       TestClassUtils.assertNotNull(we);
       return we.getText();
   }
  
   public String getText(final By by) {
       TestClassUtils.assertNotNull(by);
       return this.webDriver.findElement(by).getText();
   }
   
   public boolean isSelected(final WebElement we) {
       try {
           TestClassUtils.assertNotNull(we);
           return we.isSelected();
       }
       catch (Exception ex) {
           return false;
       }
   }

   public WebElement findElement(final By by) {
       TestClassUtils.assertNotNull(by);
       return this.webDriver.findElement(by);
   }
   
   public List<WebElement> findElements(final By by) {
       TestClassUtils.assertNotNull(by);
       return (List<WebElement>)this.webDriver.findElements(by);
   }
   
   private WebElement findAndFocusOn(final By by) {
       return this.webDriver.findElement(by);
   }
   public void waitAjaxLoaded() {
       final JavascriptExecutor ajaxExe = (JavascriptExecutor)this.webDriver;
       Boolean loading = true;
       int counter = 1;
       TestUtils.sleep(1000);
       if (ajaxExe == null) {
           return;
       }
       while (loading) {
           try {
               loading = (Boolean)ajaxExe.executeScript("return Ext.Ajax.isLoading();", new Object[0]);
               Thread.sleep(500L);
           }
           catch (InterruptedException ex) {}
           catch (WebDriverException e) {
               return;
           }
           if (++counter == 90) {
               loading = false;
               //UITools.log.error("Wait threshold for Ajax scripts was exceeded.");
           }
       }
   }
   
   
   public void selectOptionByText(final WebElement we, final String strText) {
       TestClassUtils.assertNotNull(we);
         final Select objSelect = new Select(we);
       final List<WebElement> list = (List<WebElement>)objSelect.getOptions();
       for (int i = 0; i < list.size(); ++i) {
           if (list.get(i).getText().trim().equals(strText)) {
               objSelect.selectByIndex(i);
               break;
           }
       }
   }
   
   public void selectOptionByValue(final By by, final String strValue) {
       TestClassUtils.assertNotNull(by);
       final WebElement we = this.webDriver.findElement(by);
       this.selectOptionByValue(we, strValue);
   }
   
   public void selectOptionByValue(final WebElement we, final String strValue) {
       TestClassUtils.assertNotNull(we);
      final Select objSelect = new Select(we);
       objSelect.selectByValue(strValue);
   }
   
   public void scrollToElement(final By by) {
       TestClassUtils.assertNotNull(by);
       final WebElement we = this.webDriver.findElement(by);
        ((JavascriptExecutor)this.webDriver).executeScript("arguments[0].scrollIntoView(true);", new Object[] { we });
       TestUtils.sleep(500);
   }
   
   public void scrollToElement(final WebElement we) {
       TestClassUtils.assertNotNull(we);
        ((JavascriptExecutor)this.webDriver).executeScript("arguments[0].scrollIntoView(true);", new Object[] { we });
       TestUtils.sleep(500);
   }
   
   public String getAttribute(final By by, final String strAttributeName) {
       TestClassUtils.assertNotNull(by);
       final WebElement we = this.webDriver.findElement(by);
       return this.getAttribute(we, strAttributeName);
   }
   
   public String getAttribute(final WebElement we, final String strAttributeName) {
       TestClassUtils.assertNotNull(we);
       return we.getAttribute(strAttributeName);
   }
   
 
   
}
