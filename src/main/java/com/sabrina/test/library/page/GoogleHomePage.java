package com.sabrina.test.library.page;

import org.openqa.selenium.WebDriver;

import com.sabrina.test.frame.elements.ButtonElement;
import com.sabrina.test.frame.elements.InputElement;
import com.sabrina.test.frame.utilities.Helper;
import com.sabrina.test.frame.utilities.PageBase;

public class GoogleHomePage extends PageBase {

	public GoogleHomePage(WebDriver driver) {
		super(driver);
		Helper.logInfo("=========================================================");
		Helper.logInfo(this.getClass().toString());
		Helper.logInfo("=========================================================");
	}

	private ButtonElement btnGoogleSearch = new ButtonElement("name", "btnK", "btnGoogleSearch");
	public ButtonElement btnGoogleSearch() {
		btnGoogleSearch.setWebElement(super.findElement(btnGoogleSearch));
		return btnGoogleSearch;
	}
	
	private InputElement inptSearch = new InputElement("id", "lst-ib", "inptSearch");
	public InputElement inptSearch() {
		inptSearch.setWebElement(super.findElement(inptSearch));
		return inptSearch;
	}
	
}
