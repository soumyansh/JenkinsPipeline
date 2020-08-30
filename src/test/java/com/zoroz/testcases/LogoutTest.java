package com.zoroz.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.zoroz.base.TestBase;

public class LogoutTest extends TestBase {

	@Test
	public void doLogout() {
		logger=extent.startTest("Logout Test");
		logger.log(LogStatus.INFO, "Clicking on logout");
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();
		logger.log(LogStatus.PASS, "Logout Successful");
		extent.endTest(logger);
		extent.flush();
	}
}
