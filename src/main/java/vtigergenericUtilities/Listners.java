package vtigergenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listners implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"------Test script execution started-------");
		// create a test in Extend report
		test=report.createTest(methodName);
		
		
	}

	public void onTestSuccess(ITestResult result) {

		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"------PASS------");
			
	}

	public void onTestFailure(ITestResult result) {
		WebDriverutils wutil=new WebDriverutils();
		JavaFileutility jutil=new JavaFileutility();
		String methodName=result.getMethod().getMethodName();
	String	path="./Screenshots/screenshot"+methodName+jutil.date()+"-"+jutil.generatetime();
	test.log(Status.FAIL, methodName+"-----FAil------");
	test.log(Status.INFO, result.getThrowable());
try {
	wutil.takesSceenShot(BaseClass.sdriver,path+".png" );

} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		test.log(Status.FAIL, "-script failes--------");
	}

	public void onTestSkipped(ITestResult result) {
String  methodName=result.getMethod().getMethodName();
test.log(Status.SKIP, methodName+"------skipped");
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		JavaFileutility jutil=new JavaFileutility();
	
		String path="./ExtendReports/report-"+jutil.date()+"-"+jutil.generatetime();
		//configure the extent reports
	ExtentSparkReporter esr=new ExtentSparkReporter(path+".html");
		esr.config().setDocumentTitle("Vtiger Execution Report");
		esr.config().setReportName("Automation Execution report");
		esr.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Platform", "Windows");
		report.setSystemInfo("brower", "chrome");
		report.setSystemInfo("url", "Windows");
		report.setSystemInfo("Platform", "https://localhost:8888");
		report.setSystemInfo("Reporter", "soundarya");

		
		
	}

	public void onFinish(ITestContext context) {

		System.out.println("------suite execution finished-----");
		
		report.flush();
	}

}
