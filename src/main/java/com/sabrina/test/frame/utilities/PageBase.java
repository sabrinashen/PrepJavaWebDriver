package com.sabrina.test.frame.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sabrina.test.frame.elements.ElementBase;

public class PageBase {
	
	WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement findElement(ElementBase eb) {
		return driver.findElement(Helper.getByMechanism(eb));
	}
	
	

}
