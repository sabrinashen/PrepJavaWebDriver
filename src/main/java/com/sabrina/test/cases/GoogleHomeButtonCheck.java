package com.sabrina.test.cases;

import org.testng.annotations.Test;

import com.sabrina.test.frame.utilities.BaseTestRun;
import com.sabrina.test.frame.utilities.WebDriverFunction;
import com.sabrina.test.library.page.GoogleHomePage;
import com.sabrina.test.library.page.GoogleResultPage;

public class GoogleHomeButtonCheck extends BaseTestRun {
	
	
	@Test
	public void clickGoogleSearchButton() {
		WebDriverFunction.get("http://www.google.com");
		GoogleHomePage googleHomePage = new GoogleHomePage();
		googleHomePage.inptSearch().isDisplayed();
		googleHomePage.inptSearch().input("Sabrina");
		googleHomePage.btnGoogleSearch().click();
		GoogleResultPage googleResultPage = new GoogleResultPage();
		googleResultPage.lnkFirst().isDisplayed();
		googleResultPage.baseTopNavBar().isDisplayed();
		googleResultPage.lnkFirst().click();
		WebDriverFunction.getCurrentUrl();
//		googleResultPage.lnkCannotLocate().isDisplayed();
		
		
	}

}
