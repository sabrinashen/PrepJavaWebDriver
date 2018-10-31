package com.sabrina.test.library.page;

import org.openqa.selenium.WebDriver;

import com.sabrina.test.frame.elements.ElementBase;
import com.sabrina.test.frame.elements.LinkElement;
import com.sabrina.test.frame.utilities.Helper;
import com.sabrina.test.frame.utilities.PageBase;

public class GoogleResultPage extends PageBase{

	public GoogleResultPage(WebDriver driver) {
		super(driver);
		Helper.logInfo("=========================================================");
		Helper.logInfo(this.getClass().toString());
		Helper.logInfo("=========================================================");
	}
	
	private LinkElement lnkFirst = new LinkElement("xpath", "//a/h3", "lnkFirst");
	public LinkElement lnkFirst() {
		lnkFirst.setWebElement(super.findElement(lnkFirst));
		return lnkFirst;
	}
	
	private ElementBase baseTopNavBar = new LinkElement("cssSelector", "div#hdtb-msb-vis", "baseTopNavBar");
	public ElementBase baseTopNavBar() {
		baseTopNavBar.setWebElement(super.findElement(baseTopNavBar));
		return baseTopNavBar;
	}
	
	private LinkElement lnkCannotLocate = new LinkElement("cssSelector", "div#aaa", "lnkCannotLocate");
	public LinkElement lnkCannotLocate() {
		lnkCannotLocate.setWebElement(super.findElement(lnkCannotLocate));
		return lnkCannotLocate;
	}
	
	
	
	
	
	

}
