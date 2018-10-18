package com.sabrina.test.frame.elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.sabrina.test.frame.utilities.Helper;
import com.sabrina.test.frame.utilities.Waiter;

public class ElementBase {
	private String name = "";
	private String type = "";
	private String value = "";
	private WebElement webElement = null;
	private List<WebElement> webElements =  new ArrayList<WebElement>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public WebElement getWebElement() {
		return webElement;
	}

	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
		Helper.logInfo("Set WeElement <"+ this.name +"> with By <"+ this.type +": "+ this.value +"> Successfully!");
	}

	public List<WebElement> getWebElements() {
		return webElements;
	}

	public void setWebElements(List<WebElement> webElements) {
		this.webElements = webElements;
	}
	
	public ElementBase(String type, String value, String name) {
		this.setType(type);
		this.setValue(value);
		this.setName(name);
//		this.setWebElement(null, "");
	}
	
	public void waitElementPresent() {
		Helper.logInfo("Wait for this element" + this);
		Waiter.waitElementPresent(Helper.getByMechanism(this));
	}
	
	public boolean isDisplayed() {
		boolean flag = false;
		if (null != this.getWebElement()) {
			flag = this.getWebElement().isDisplayed();
			Helper.logInfo("Element <"+ this.getName() +"> displaying is "+flag+"!");
		} else {
			Helper.logError("Element <"+ this.getName() +"> is null with locator <type: "+ this.getType() +", value: "+ this.getValue() +">!");
		}
		return flag;
	}
	
	public void click() {
		this.getWebElement().click();
	}
	
	
	
	

}
