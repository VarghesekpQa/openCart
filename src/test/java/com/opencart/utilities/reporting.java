package com.opencart.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.opencart.testcases.baseClass;

public class reporting extends baseClass implements ITestListener{

	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;
	
	public void onStart(ITestContext context) {
		
		/*
		SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String actualDate = fd.format(date);
		
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		*/
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String repPath = System.getProperty("user.dir")+ "/reports/extentReport_"+timeStamp+".html";
		
		spark = new ExtentSparkReporter(repPath);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		spark.config().setReportName("Opencart functional automation report");
		spark.config().setDocumentTitle("Opencart Project");
		spark.config().setTheme(Theme.DARK);
		
		extent.setSystemInfo("Os", "Windows 11");
		extent.setSystemInfo("Environment", "Qa");
		extent.setSystemInfo("User", "Varghese Kp");
	}
	
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(),ExtentColor.GREEN));
		
		
	}

	public void onTestFailure(ITestResult result) {
	
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - testcase failed",ExtentColor.RED));
		test.log(Status.FAIL, result.getThrowable());
	
		try {
				String path = helper.captureScreenshot(driver, result.getMethod().getMethodName());
				System.out.println(path);
				
				test.addScreenCaptureFromPath(path);

		} 
		catch (Exception e) 
				{
				e.printStackTrace();
			}	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
		test.log(Status.SKIP, result.getThrowable());
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
}
