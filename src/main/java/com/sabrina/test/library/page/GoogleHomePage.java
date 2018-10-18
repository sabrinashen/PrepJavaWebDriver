package com.sabrina.test.library.page;

import com.sabrina.test.frame.elements.ButtonElement;
import com.sabrina.test.frame.elements.InputElement;
import com.sabrina.test.frame.utilities.Helper;
import com.sabrina.test.frame.utilities.WebDriverFunction;

public class GoogleHomePage {

	public GoogleHomePage() {
		Helper.logInfo("=========================================================");
		Helper.logInfo(this.getClass().toString());
		Helper.logInfo("=========================================================");
	}

	private ButtonElement btnGoogleSearch = new ButtonElement("name", "btnK", "btnGoogleSearch");
	public ButtonElement btnGoogleSearch() {
		btnGoogleSearch.setWebElement(WebDriverFunction.findElement(Helper.getByMechanism(btnGoogleSearch)));
		return btnGoogleSearch;
	}
	
	private InputElement inptSearch = new InputElement("id", "lst-ib", "inptSearch");
	public InputElement inptSearch() {
		inptSearch.setWebElement(WebDriverFunction.findElement(Helper.getByMechanism(inptSearch)));
		return inptSearch;
	}
	
}
