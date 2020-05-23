package com.legalzoom.hometest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.legalzoom.customeutils.PropertiesUtils;
import com.legalzoom.legalz.Keyword;

/**
 * Verify SignIn in LegalZoom using correct Username and Password
 * 
 * @author Nisha Lodha
 *
 */
public class LegalZoomSignInTest {
	public WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		Keyword.openBrowser("chrome");
	}

	@Test()
	public void verifysignin() {

		Keyword.launchUrl(PropertiesUtils.getLocator("url"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.err.println("Check sign in page");
			e.printStackTrace();
		}
		Keyword.acceptcookies();
		Keyword.myaccount();
		Keyword.addwait();
		Keyword.usernameandpassword();

		Keyword.addwait();
		Keyword.buildWebElement("notinterested").click();
		String expected = Keyword.buildWebElement("accountoverview").getText();

		String actual = "ACCOUNT OVERVIEW";
		System.out.println(actual);
		Assert.assertEquals(actual, expected);

	}

	@AfterTest
	public void closeallbrowser() {
		Keyword.closebrowser();
	}
}
