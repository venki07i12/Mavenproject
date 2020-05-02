package mavenproject.packages;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentreportEx1 {

	
	@Test
	public static void extendreport() throws Exception
	{
		
		System.out.println("Lauch Google page");
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("D:\\Selenium Testing\\MindQ\\mavenproject\\ExtentReports\\samplereport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger1 = extent.createTest("Google");
		logger1.log(Status.INFO, "launch google");
		logger1.log(Status.PASS, "google Opened");
		extent.flush();
		
		ExtentTest logger2 = extent.createTest("Amazon");
		logger2.log(Status.INFO, "launch Amazon");
		logger2.log(Status.FAIL, "Amazon Opened");
		logger2.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("F:\\Eyevision\\Certificates\\Photo.JPG").build());
	//	logger2.addScreenCaptureFromPath("F:\\Eyevision\\Certificates\\Photo.JPG");
		extent.flush();
		
	}
	
}
