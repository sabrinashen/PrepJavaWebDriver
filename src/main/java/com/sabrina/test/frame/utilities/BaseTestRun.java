package com.sabrina.test.frame.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTestRun {

	protected WebDriverFunction driverFunc = new WebDriverFunction();
	protected WebDriver driver;
		
//	public WebDriver getDriver() {
//		return driverFunc.getDriver();
//	}
//
//	public void setDriver(WebDriverFunction driverFunc) {
//		this.driver = driverFunc.getDriver();
//	}

	@BeforeClass
	@Parameters("browser")
	public void setUpDriver(String browser, ITestContext context) {
		driverFunc.startRemoteBrowser(browser);
		driver = driverFunc.getDriver();
		Helper.logInfo(browser.toUpperCase() + " Driver has been set up!");
		Helper.setWebDriver(driver);
		Helper.setITestContext(context);
		Waiter.init(driverFunc, 10);
	}
	
	@AfterClass
	public void tearDownDriver() {
		driverFunc.quitDriver();
	}

}
