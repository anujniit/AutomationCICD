package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.ExtentReporterNG;
import Utils.ScreenshotUtility;

public class TestListeners extends ScreenshotUtility implements ITestListener {

	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result)
	{
		test=extent.createTest(result.getMethod().getMethodName());
		System.out.println(">> Test is started: " + result.getName());
		extentTest.set(test);// Unique thread id of the test
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		extentTest.get().log(Status.PASS, "Test Passed");
		System.out.println(">> On Test Success: " + result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		System.out.println(">> On Test Failure: " + result.getName());
		extentTest.get().addScreenCaptureFromPath(ScreenshotUtility.captureScreenshot(result.getName()), result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println(">> On test skipped: " + result.getName());
	}
	
	
	public void onTestFailureWithinSuccessPercentage(ITestResult result)
	{
		System.out.println("test failure within test success percentage" + result.getName());
	}
	
	
	public void onStart(ITestContext context) 
	{
		System.out.println("On stert" + context.getName());
	}
	
	
	public void onFinish(ITestContext context)
	{
		System.out.println("on finish" + context.getName());
		extent.flush();
	}
}
