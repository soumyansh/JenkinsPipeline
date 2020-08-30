package com.zoroz.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import org.testng.annotations.Test;

import com.zoroz.base.TestBase;
import com.zoroz.utilities.TestUtil;

public class Rough extends TestBase {

	@Test(dataProvider="dp",dataProviderClass=TestUtil.class)
	public void doxyz(Method m,Hashtable<String, String>data) {
	System.out.println("1st table---------------------");
	System.out.println("YourHashtable 1st Key is:"+"Key1");
	System.out.println("Your Hashtable Value is:" +data.get("Key1"));
	System.out.println("2nd table--------------------------");
	System.out.println("YourHashtable 2nd Key is:"+"Key2");
	System.out.println("Your Hashtable Value is:" +data.get("Key2"));
		
	}

}
