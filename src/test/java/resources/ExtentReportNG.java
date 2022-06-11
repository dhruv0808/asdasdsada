package resources;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports extentReports;
	
	@BeforeTest
	public static ExtentReports getReportObject() {
		
		 String path = System.getProperty("user.dir")+"\\reports\\index.html";
		 ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		 reporter.config().setReportName("Web Automation results");
		 reporter.config().setDocumentTitle("Test results");
		 extentReports = new ExtentReports();
		 extentReports.attachReporter(reporter);
		 extentReports.setSystemInfo("Tester", "Dhruv");
		 return extentReports;
	}

}