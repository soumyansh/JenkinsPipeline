package com.zoroz.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.LogStatus;




public class TestUtil extends com.zoroz.base.TestBase {

	public static String screenshotPath;
	public static String screenshotName;

	public static String ScreenShotName;
	public static void CaptureScreenshot() throws IOException {
		try {
			Date d = new Date();
			String d1 = d.toString().replace(":", "_").replace(" ", "_");

			ScreenShotName = "Screen_" + d1 + ".jpg";
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destpath = System.getProperty("user.dir") + "//Screenshots//" + ScreenShotName;
			File dest = new File(destpath);
			FileUtils.copyFile(scr, dest);
			logger.log(LogStatus.INFO, logger.addScreenCapture(destpath));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}
	
	
	public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
	
}
