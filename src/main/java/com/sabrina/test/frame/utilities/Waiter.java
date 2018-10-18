package com.sabrina.test.frame.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
	
	private static WebDriverWait waiter;
	public static void init(WebDriver driver, int timeout) {
		waiter = new WebDriverWait(driver, timeout);
	}
	
	public static WebElement waitElementPresent(By by) {
		WebElement we = null;
		try {
			we = waiter.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch(NoSuchElementException e) {
			Helper.logException("There is no such element with this locator <"+ by +">!", e);
		} catch (WebDriverException e) {
			Helper.logException("Web Driver Exception with this locator <"+ by +">!", e);
		}
		return we;
	}
	
	public static Alert waitAlertPresent() {
		Alert alert = null;
		try {
			alert = waiter.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			Helper.logException("There is no alert popping up!", e);
		}
		return alert;
	}
	

}
