package com.zoroz.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.zoroz.base.TestBase;
import com.zoroz.utilities.TestUtil;

public class HomePage extends TestBase {
	
	public void doLogout() throws IOException {
		driver.findElement(By.id("welcome")).click();
		TestUtil.CaptureScreenshot();
		driver.findElement(By.xpath("//*[text()='Logout']")).click();
		TestUtil.CaptureScreenshot();
	}

}
