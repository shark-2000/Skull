package utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport {
	public static ExtentReports reportInit() {
		ExtentReports extent;
		String Path = "./cust_rep//Extent.html";
		extent = new ExtentReports(Path, false);
		extent
		.addSystemInfo("Selenium Version", "2.52")
		.addSystemInfo("Platform", "Windows")
		.addSystemInfo("tester","Katyayan");
		return extent;	
		}
	
	

}
