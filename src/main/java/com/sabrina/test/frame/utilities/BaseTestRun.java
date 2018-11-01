package com.sabrina.test.frame.utilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTestRun {
	
	WebDriverFunction driver = new WebDriverFunction();
		
	public WebDriverFunction getDriver() {
		return driver;
	}

	public void setDriver(WebDriverFunction driver) {
		this.driver = driver;
	}

	@BeforeClass
	@Parameters("browser")
	public void setUpDriver(String browser) {
		driver.startRemoteBrowser(browser);
		Helper.logInfo(browser.toUpperCase() + " Driver has been set up!");
		Helper.setWebDriver(driver);
		Waiter.init(driver, 30);
	}
	
	@AfterClass
	public void tearDownDriver() {
		driver.quitDriver();
	}

}
