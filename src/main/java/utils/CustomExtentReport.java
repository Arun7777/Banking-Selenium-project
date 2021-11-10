package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomExtentReport {	
	static ExtentReports extent;
	
	public static ExtentReports getReports() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reports = new ExtentSparkReporter(path);
		reports.config().setReportName("Automation testing");
		reports.config().setDocumentTitle("Test result");
		reports.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reports);
		extent.setSystemInfo("os", "Window");
		extent.setSystemInfo("Tester", "Arun");
		return extent;
		
	}
}
