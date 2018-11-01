package com.sabrina.test.frame.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;

import com.sabrina.test.frame.elements.ElementBase;

public class Helper {

	private static Logger log = LogManager.getLogger(Helper.class);
	private static WebDriver driver;
	private static ITestContext context;
	
	public static void setWebDriver(WebDriver d) {
		driver = d;
	}
	
	public static void setITestContext(ITestContext c) {
		context = c;
	}

	public static void logInfo(String msg) {
		log.info("INFO - " + msg);
	}

	public static void logException(String msg, Throwable t) {
		String imgName = Helper.takeScreenshot();
		log.error("ERROR - Has SCREENSHOT "+ imgName +" with EXCEPTION - " + msg, t);
		Assert.fail(msg, t);
	}

	public static void logError(String msg) {
		String imgName = Helper.takeScreenshot();
		log.error("ERROR - Has SCREENSHOT "+ imgName +" - " + msg);
		Assert.fail(msg);
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
		return new java.text.SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());
	}
	
	public static String getCurrentTestName() {
		Class<?> x = context.getSuite().getAllMethods().listIterator().next().getRealClass();
//		System.out.println(x.getName().substring(x.getName().lastIndexOf(".")+1));
		return x.getName();
	}
	
	public static String takeScreenshot() {
		Helper.logInfo("Start to capture screen shot...");
		String outputDirectory = System.getProperty("user.dir")+"/target/surefire-reports/log/";
		String imageName = Helper.getCurrentTestName() + "_" + Helper.fileNameByTime() + ".png";
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(outputDirectory + imageName));
			Helper.logInfo("Capturing screen shot succeeded!");
		} catch (IOException e) {
			Helper.logException("Capturing screen shot failed!", e);
		}
		return imageName;
	}

}
