package com.sabrina.test.frame.elements;

public class InputElement extends ElementBase {

	public InputElement(String type, String value, String name) {
		super(type, value, name);
	}
	
	public void input(String content) {
		this.getWebElement().sendKeys(content);
	}

}
