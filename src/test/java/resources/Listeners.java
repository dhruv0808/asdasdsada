package resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	ExtentTest test; 
	ExtentReportNG extentreportng;
	ExtentReports extent =  extentreportng.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
	public static Logger log = LogManager.getLogger(base.class.getName());
	base base = new base();
	public void onTestStart(ITestResult result) {
		
		log.info(result);
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"Test passed");
		String testmethodname = result.getMethod().getMethodName();
		try {
			base.getScreenShotPath(testmethodname);
			log.info(result.getName());
			test.log(Status.PASS,"Test passed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeBrowserAndDriver();
	}

	
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		String testmethodname = result.getMethod().getMethodName();
		try {
			base.getScreenShotPath(testmethodname);
			log.info(result.getName());
			extentTest.get().addScreenCaptureFromPath(testmethodname,result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeBrowserAndDriver();
		
	}

	public void onTestSkipped(ITestResult result) {
		log.info(result);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		test = extent.createTest(context.getName());
		extentTest.set(test);
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		String testmethodname = context.getName();
		try {
			base.getScreenShotPath(testmethodname);
			log.info(context.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeBrowserAndDriver();
	}

}
