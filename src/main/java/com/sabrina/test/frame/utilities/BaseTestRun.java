package com.sabrina.test.frame.utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTestRun {
	
//	public WebDriver driver = WebDriverFunc.driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setUpDriver(String browser) {
		WebDriverFunc.startBrowser(browser);
		
		Helper.logInfo("Web Driver has been set up!");
		Waiter.init(WebDriverFunc.driver, 30);
		
	}
	
	
	
	@AfterTest
	public void tearDownDriver() {
		WebDriverFunc.quitDriver();
	}
	

}
