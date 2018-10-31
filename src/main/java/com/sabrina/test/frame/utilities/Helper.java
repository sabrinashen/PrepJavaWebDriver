package com.sabrina.test.frame.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.sabrina.test.frame.elements.ElementBase;

public class Helper {
	
	private static Logger log = LogManager.getLogger(Helper.class);
	
	public static void logInfo(String msg) {
		log.info("INFO - " + msg);
	}
	
	public static void logException(String msg, Throwable t) {
		log.error("ERROR with EXCEPTION - " + msg, t);
		Assert.fail(msg, t);
	}
	
	public static void logError(String msg) {
		log.error(msg);
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

}
