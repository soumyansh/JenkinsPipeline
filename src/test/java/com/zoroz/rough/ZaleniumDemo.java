package com.zoroz.rough;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ZaleniumDemo {
	public WebDriver driver;
	@Parameters("browser")
	@Test
	public void abc(String browser) throws MalformedURLException {
	
		if (browser.equals("chrome")) {

			// //Chrome
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(BrowserType.CHROME);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
		} else {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(BrowserType.FIREFOX);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
		}

		// Firefox

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.quit();
	}

}
