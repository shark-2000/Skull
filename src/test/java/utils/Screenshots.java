package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Screenshots {
	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
		String logfileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
		fileName =  fileName+"_"+logfileName;
		String directory  =  System.getProperty("user.dir")+"//screenshots//";
		File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory+fileName));
		String destination = directory+fileName;
		return destination;
		
		
		
	} 
	// new after method
	/*
	 * public void afterMethod(ITestResult testresult) throws IOException { if
	 * (testresult.getStatus() == ITestResult.FAILURE) { String path =
	 * Screenshots.takeScreenshot(driver, testresult.getName()); String imagePath =
	 * test.addScreenCapture(path); test.log(LogStatus.FAIL,
	 * "Verify Welcome Text Failed", imagePath);} }
	 */
	//Old After method
	public void Screenshot(WebDriver driver,ITestResult res) throws IOException {
		if(res.getStatus()==ITestResult.FAILURE) {
			  Screenshots.takeScreenshot(driver, res.getName());
		  }
		}


}

