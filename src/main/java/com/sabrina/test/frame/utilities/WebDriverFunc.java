package com.sabrina.test.frame.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFunc {

	public static WebDriver driver;
	
	public static void startBrowser(String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;
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
