package com.sabrina.test.frame.utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTestRun {
		
	@BeforeTest
	@Parameters("browser")
	public void setUpDriver(String browser) {
		WebDriverFunction.startRemoteBrowser(browser);
		
		Helper.logInfo("Web Driver has been set up!");
		Waiter.init(WebDriverFunction.driver, 30);
		
	}
	
	@AfterTest
	public void tearDownDriver() {
		WebDriverFunction.quitDriver();
	}
	

}
