package com.zoroz.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;
import com.zoroz.base.TestBase;
import com.zoroz.utilities.TestUtil;

public class LoginPage extends TestBase {
	
	public void doLogin(String username,String Password) throws IOException {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		TestUtil.CaptureScreenshot();
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		TestUtil.CaptureScreenshot();
		
		driver.findElement(By.id("btnLogin")).click();
	}

}
