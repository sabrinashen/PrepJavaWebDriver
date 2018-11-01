package com.sabrina.test.frame.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sabrina.test.frame.elements.ElementBase;

public class Helper {

	private static Logger log = LogManager.getLogger(Helper.class);
	private static WebDriver driver;
	
	public static void setWebDriver(WebDriver d) {
		driver = d;
	}

	public static void logInfo(String msg) {
		log.info("INFO - " + msg);
	}

	public static void logException(String msg, Throwable t) {
		log.error("ERROR with EXCEPTION - " + msg, t);
		Helper.takeScreenshot(Helper.driver, "");
		Assert.fail(msg, t);
	}

	public static void logError(String msg) {
		log.error(msg);
		Helper.takeScreenshot(Helper.driver, "");
		Assert.fail(msg);
	}
	
	public static String getPath() {
		return System.getProperty("user.dir");
		
	}

	public enum ByTypeEnum {
		name, xpath, id, className, cssSelector, linkText, partialLinkText, tagName
	}

	public static By getByMechanism(ElementBase eb) {
		By byWhat = null;
		try {
			String byValue = eb.getValue();
			ByTypeEnum byType = ByTypeEnum.valueOf(eb.getType());
			switch (byType) {
			case name:
				byWhat = By.name(byValue);
				break;
			case xpath:
				byWhat = By.xpath(byValue);
				break;
			case id:
				byWhat = By.id(byValue);
				break;
			case className:
				byWhat = By.className(byValue);
				break;
			case cssSelector:
				byWhat = By.cssSelector(byValue);
				break;
			case linkText:
				byWhat = By.linkText(byValue);
				break;
			case tagName:
				byWhat = By.tagName(byValue);
				break;
			case partialLinkText:
				byWhat = By.partialLinkText(byValue);
				break;
			}
		} catch (IllegalArgumentException e) {
			System.out.println(eb.getType() + " is not a validate attribute");
		}
		return byWhat;
	}
	
	/**
	 * @return a string type time.
	 */
	public static String fileNameByTime() {
		return new java.text.SimpleDateFormat("yyyy-MM-dd HHmmss")
				.format(new Date());
	}
	
	public static String takeScreenshot(WebDriver driver, String fileWithPath) {
		Helper.logInfo("Start to capture screen shot...");
		String outputDirectory = System.getProperty("user.dir")+"/target/surefire-reports/log/";
		//Path path = Paths.get(outputDirectory);
		//System.out.println("path=======> " + path.toString());
		String imageName = Helper.fileNameByTime() + ".png";
		System.out.println("directory=======> " + outputDirectory);
		System.out.println("imgname=======> " + imageName);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(outputDirectory + imageName));
			Helper.logInfo("Capturing screen shot succeeded!");
		} catch (IOException e) {
			Helper.logException("Capturing screen shot failed!", e.fillInStackTrace());
			e.printStackTrace();
		}
		return imageName;
	}

}
