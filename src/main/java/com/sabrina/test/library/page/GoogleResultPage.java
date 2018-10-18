package com.sabrina.test.library.page;

import com.sabrina.test.frame.elements.ElementBase;
import com.sabrina.test.frame.elements.LinkElement;
import com.sabrina.test.frame.utilities.Helper;
import com.sabrina.test.frame.utilities.WebDriverFunction;

public class GoogleResultPage {

	public GoogleResultPage() {
		Helper.logInfo("=========================================================");
		Helper.logInfo(this.getClass().toString());
		Helper.logInfo("=========================================================");
	}
	
	private LinkElement lnkFirst = new LinkElement("xpath", "//a/h3", "lnkFirst");
	public LinkElement lnkFirst() {
		lnkFirst.setWebElement(WebDriverFunction.findElement(Helper.getByMechanism(lnkFirst)));
		return lnkFirst;
	}
	
	private ElementBase baseTopNavBar = new LinkElement("cssSelector", "div#hdtb-msb-vis", "baseTopNavBar");
	public ElementBase baseTopNavBar() {
		baseTopNavBar.setWebElement(WebDriverFunction.findElement(Helper.getByMechanism(baseTopNavBar)));
		return baseTopNavBar;
	}
	
	private LinkElement lnkCannotLocate = new LinkElement("cssSelector", "div#aaa", "lnkCannotLocate");
	public LinkElement lnkCannotLocate() {
		lnkCannotLocate.setWebElement(WebDriverFunction.findElement(Helper.getByMechanism(lnkCannotLocate)));
		return lnkCannotLocate;
	}
	
	
	
	
	
	

}
