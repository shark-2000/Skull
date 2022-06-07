package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.BrowserMgr;
import utils.Constant;
import utils.ExtentReport;
import utils.Screenshots;

public class Base {
	private String baseURL;
	private static WebDriver driver;
	private ExtentReports report;
	private ExtentTest test;
	private String actual;
	private String expected;

	
  
  	  

  @BeforeTest
  public void beforeClass() {
	  baseURL ="https://www.amazon.in";
	  String browser="Chrome";
	  if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(Constant.ChromeDriverKey, Constant.ChromeDriverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(baseURL);

			
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty(Constant.EdgeDriverKey, Constant.EdgeDriverPath);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(baseURL);

			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(Constant.FirefoxDriverKey, Constant.FirefoxDriverPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(baseURL);

			
		}
	  
	  report = ExtentReport.reportInit();
	  test = report.startTest("Demo ");
	  
	  
	  
  }
  @Test
  public void f() {
	  actual=driver.getTitle();
	  expected="";
	  Assert.assertEquals(actual, expected);
	  
	  
  }
  @AfterMethod
  public void afterMethod(ITestResult testresult) throws IOException { if
	  (testresult.getStatus() == ITestResult.FAILURE) { String path =
	  Screenshots.takeScreenshot(driver, testresult.getName()); 
	  String imagePath =  test.addScreenCapture(path); test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
	 
  report.endTest(test);
  report.flush();
  driver.close();
  }
}

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
