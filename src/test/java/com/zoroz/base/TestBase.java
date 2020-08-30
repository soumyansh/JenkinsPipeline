package com.zoroz.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.zoroz.utilities.ExcelReader;

public class TestBase {

	public static WebDriver driver;
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExcelReader excel;
	@BeforeSuite
	public void setup() throws IOException {
		excel=new ExcelReader("C:\\Users\\Soumyansh\\eclipse-workspace\\DemoMaven\\src\\test\\resources\\excel\\testData.xlsx");
		
		extent=new ExtentReports("C:\\Users\\Soumyansh\\eclipse-workspace\\DemoMaven\\src\\test\\resources\\Reports\\AutomationReport.html",true);
		extent.loadConfig(new File(
				"C:\\Users\\Soumyansh\\eclipse-workspace\\DemoMaven\\src\\test\\resources\\Reports\\ReportsConfig.xml"));
		
		if (driver==null) {
			
			Properties config = new Properties();
			FileInputStream fis = new FileInputStream(new File(
					"C:\\Users\\Soumyansh\\eclipse-workspace\\DemoMaven\\src\\test\\resources\\Properties\\config.properties"));
			
			config.load(fis);
			
			
			if(config.get("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Soumyansh\\eclipse-workspace\\DemoMaven\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			}else {
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\Soumyansh\\eclipse-workspace\\DataDriven_Maven\\src\\test\\resources\\executables\\msedgedriver.exe");
				driver = new EdgeDriver();
					
			}
			driver.get(config.get("testurl").toString());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	}
	
	@AfterSuite
	public void tearDown() {
		if (driver!=null) {
			driver.quit();
		}
	}

}
