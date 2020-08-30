package com.zoroz.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.zoroz.base.TestBase;

public class CustomListeners extends TestBase implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		logger.log(LogStatus.FAIL, "Test Failed and this message is coming from listeners");
		extent.endTest(logger);
		extent.flush();
		
	}

	public void onTestSkipped(ITestResult arg0) {
		logger.log(LogStatus.SKIP, "Test Skipped and this message is coming from listeners");
		extent.endTest(logger);
		extent.flush();
		
	}

	public void onTestStart(ITestResult arg0) {
		
		
	}

	public void onTestSuccess(ITestResult arg0) {
		logger.log(LogStatus.PASS, "Test Passed and this message is coming from listeners");
		extent.endTest(logger);
		extent.flush();
		
	}

}
