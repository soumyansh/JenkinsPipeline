package com.zoroz.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.zoroz.base.TestBase;
import com.zoroz.pages.HomePage;
import com.zoroz.pages.LoginPage;
import com.zoroz.utilities.TestUtil;

public class LoginTest extends TestBase {

	HomePage hp = new HomePage();
	LoginPage lp = new LoginPage();

	@Test(dataProvider = "dp", dataProviderClass = TestUtil.class)
	public void doLogin(Hashtable<String, String> data) throws InterruptedException, IOException {

		try {
			System.out.println("Hello World");
			logger = extent.startTest("Login Test" + data.get("UserID"));
			lp.doLogin(data.get("Username"), data.get("Password"));
			hp.doLogout();
			System.out.println("Hello ");
			Thread.sleep(3000);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed with reason:" + e.getMessage());
			TestUtil.CaptureScreenshot();
		}

	}

}
