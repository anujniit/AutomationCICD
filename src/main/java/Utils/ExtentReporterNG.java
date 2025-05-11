package Utils;

import org.slf4j.helpers.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import anujpal.PurchaseAProductEnd_To_End.BaseTest;

public class ExtentReporterNG extends BaseTest{

	public static ExtentReports getReportObject() {
		
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Anuj Pal");
		return extent;
	
	
	}
}
