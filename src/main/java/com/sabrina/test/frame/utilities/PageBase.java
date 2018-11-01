package com.sabrina.test.frame.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
