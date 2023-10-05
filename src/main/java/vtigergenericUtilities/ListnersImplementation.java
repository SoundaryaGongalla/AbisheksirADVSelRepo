package vtigergenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplementation  implements ITestListener{
	

	ExtentTest test;
	ExtentReports er;
	ExtentSparkReporter report;
	
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
	System.out.println("Test case started"+methodName);
test=er.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
	test.log(Status.PASS, "TestCaseSucess"+methodName);
	}

	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String path="C:\\Users\\admin\\Desktop\\Selenium\\soundarya\\Screenshots"+"/"+methodName+".png";
WebDriverutils wutil=new WebDriverutils();
WebDriverutils webDriverutils = new WebDriverutils();

try {
	webDriverutils.takesSceenShot(BaseClass.driver, path);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		test.log(Status.FAIL, "script failed"+methodName);
	}

	public void onTestSkipped(ITestResult result) {
	String methodname=	result.getMethod().getMethodName();
	
		test.log(Status.SKIP, methodname+"===Skipped-");
	}

	public void onStart(ITestContext context) {
		
		
		
		JavaFileutility jutil=new JavaFileutility();

		jutil.date();
		jutil.generatetime();
		 String path="C:\\Users\\admin\\Desktop\\Selenium\\soundarya\\Reports"+jutil.date()+jutil.generatetime();
		
		
			ExtentSparkReporter report=new ExtentSparkReporter(path+".html");
			ExtentReports er=new  ExtentReports();

		report.config().setReportName("AUTOMATION REPORT");
		report.config().setDocumentTitle("Vtiger");
		report.config().setTheme(Theme.DARK);
		er.attachReporter(report);
		er.setSystemInfo("window", "Win 10");
		er.setSystemInfo("system", "dell");
		er.setSystemInfo("bit", "64 bit");
		er.setSystemInfo("Reportername", "soundarya");
		System.out.println("--------------onstarts---------");
	}

	public void onFinish(ITestContext context) {
		
		
		er.flush();
		System.out.println("suite finished");
		
	}

	
	
	
}
