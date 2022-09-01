package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepoterNG {
   public static	ExtentReports extent;
	
	public static ExtentReports getreportobject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter	esr=new ExtentSparkReporter(path);
	esr.config().setDocumentTitle("Test Results");
	esr.config().setReportName("Automation Framework Report");
	
	
	 extent=new ExtentReports();
	 extent.attachReporter(esr);
	 extent.setSystemInfo("Tester", "Mahesh Gavade");
	return extent;
	}

}
