package com.sabrina.test.frame.utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFunction {

	public static RemoteWebDriver driver;
	
	public static void startBrowser(String browser) {
		if (browser.equals("chrome") || browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox") || browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void startRemoteBrowser(String browser) {
		try {
			DesiredCapabilities capabillities = null;
			if (browser.equals("chrome") || browser.equals("Chrome")) {
				capabillities = DesiredCapabilities.chrome();
				capabillities.setBrowserName("chrome"); 
			} else if (browser.equals("firefox") || browser.equals("Firefox")) {
				capabillities = DesiredCapabilities.firefox();
				capabillities.setBrowserName("firefox"); 
			} else {
				capabillities = DesiredCapabilities.chrome();
			    capabillities.setBrowserName("chrome"); 
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabillities);
		} catch(MalformedURLException e) {
			Helper.logException("Failed to Start Remote Driver with exectption", e);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
			Helper.logInfo("Web Driver has been quit!");
		} else {
			Helper.logInfo("Web Driver has already been quit!");
		}
	}
	
	public static void get(String url) {
		driver.get(url);
		Helper.logInfo("Open URL - " + url);
	}
	
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		Helper.logInfo("Get Current URL is " + currentUrl);
		return currentUrl;
	}
	
	public static WebElement findElement(By by) {
		WebElement we = null;
		try {
			we = driver.findElement(by);
		} catch (NoSuchElementException e) {
			Helper.logException("There is no such element with this locator <"+ by +">!", e);
		} catch (WebDriverException e) {
			Helper.logException("Web Driver Exception with this locator <"+ by +">!", e);
		}
		return we;
	}
	
	

}
