package com.legalzoom.hometest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.legalzoom.customeutils.PropertiesUtils;
import com.legalzoom.legalz.Keyword;

import junit.framework.Assert;

/**
 * To verify singUp functionality for new user.
 * 
 * @author Nisha Lodha
 *
 */

public class LegalZoomSignUpTest {
	public WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		Keyword.openBrowser("chrome");
	}

	@Test
	public void verifysignup() {

		Keyword.launchUrl(PropertiesUtils.getLocator("url"));
		Keyword.addwait();
		Keyword.acceptcookies();
		Keyword.myaccount();
		Keyword.addwait();
		Keyword.buildWebElement("createnewaccount").click();
		System.out.println("path not found");
		String actual = "Create an account";
		String expected = Keyword.buildWebElement("createaccount").getText();
		Assert.assertEquals(expected, actual);
	}

	@AfterTest
	public void closeallbrowser() {
		Keyword.closebrowser();
	}
}
