package com.sabrina.test.cases;

import org.testng.annotations.Test;

import com.sabrina.test.frame.utilities.BaseTestRun;
import com.sabrina.test.library.page.GoogleHomePage;
import com.sabrina.test.library.page.GoogleResultPage;

public class GoogleHomeButtonCheck3 extends BaseTestRun {
	
	
	@Test
	public void clickGoogleSearchButton() {
		getDriver().get("http://www.google.com");
		GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
		googleHomePage.inptSearch().isDisplayed();
		googleHomePage.inptSearch().input("Anna");
		googleHomePage.btnGoogleSearch().click();
		GoogleResultPage googleResultPage = new GoogleResultPage(getDriver());
		googleResultPage.lnkFirst().isDisplayed();
		googleResultPage.baseTopNavBar().isDisplayed();
		googleResultPage.lnkFirst().click();
		getDriver().getCurrentUrl();
		
		
	}

}
