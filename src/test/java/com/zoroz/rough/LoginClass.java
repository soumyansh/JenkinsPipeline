package com.zoroz.rough;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.zoroz.base.TestBase;
import com.zoroz.utilities.ExcelReader;
import com.zoroz.utilities.TestUtil;



// [1][2] <1><2>
//[1][2]

public class LoginClass extends TestBase {

	@Test(dataProvider="dp",dataProviderClass=TestUtil.class)
	public void doLogin(Hashtable<String, String>data) {
		System.out.println(data.get("Username"));
		System.out.println(data.get("Password"));
		
	}
}
