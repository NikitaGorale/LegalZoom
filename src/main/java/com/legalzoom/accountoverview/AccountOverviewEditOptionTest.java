package com.legalzoom.accountoverview;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.legalzoom.customeutils.PropertiesUtils;
import com.legalzoom.legalz.Keyword;

import junit.framework.Assert;

/**
 * Verify Edit Option in Account Overview page in Legal Zoom Site
 * 
 * @author Nisha Lodha
 *
 */

public class AccountOverviewEditOptionTest {
	@BeforeTest
	public void openBrowser() {
		Keyword.openBrowser("chrome");
	}

	@Test
	public void verifyeditoption() {
		Keyword.launchUrl(PropertiesUtils.getLocator("url"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.err.println("Wait for Page Load");
			e.printStackTrace();
		}
		Keyword.acceptcookies();
		Keyword.addwait();
		Keyword.myaccount();
		Keyword.addwait();
		Keyword.usernameandpassword();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.err.println("Wait for Page Load");
			e.printStackTrace();
		}

		Keyword.buildWebElement("notinterested").click();
		Keyword.buildWebElement("edit").click();

		String expected = Keyword.buildWebElement("personal").getText();
		String actual = "Personal Information";
		Assert.assertEquals(expected, actual);

	}

	@AfterTest
	public void closeallbrowser() {
		Keyword.closebrowser();
	}

}
