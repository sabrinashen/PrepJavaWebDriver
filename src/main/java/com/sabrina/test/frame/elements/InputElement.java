package com.sabrina.test.frame.elements;

import org.openqa.selenium.Keys;

import com.sabrina.test.frame.utilities.Helper;

public class InputElement extends ElementBase {

	public InputElement(String type, String value, String name) {
		super(type, value, name);
	}
	
	public void input(String content) {
		try {
			this.getWebElement().sendKeys(content);
			this.getWebElement().sendKeys(Keys.TAB);
		} catch (Exception e) {
			Helper.logException("Get Unknown Exception", e);
		}
		
	}

}
