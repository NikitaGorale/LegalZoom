package com.legalzoom.accountoverview;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.legalzoom.customeutils.PropertiesUtils;
import com.legalzoom.legalz.Keyword;

import junit.framework.Assert;

/**
 * Verify Help Search in Account Overview page in Legal Zoom Site
 * 
 * @author Nisha Lodha
 *
 */

public class AccountOverviewHelpSearchLink {
	@BeforeTest
	public void openBrowser() {
		Keyword.openBrowser("chrome");
	}

	@Test
	public void verifysearchourknowledgecenter() {
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
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.err.println("Wait for Page Load");
			e.printStackTrace();
		}

		Keyword.buildWebElement("newcompilesclose").click();
		Keyword.buildWebElement("closemylo").click();
		Keyword.buildWebElement("searchourknowlege").click();
		String expected = Keyword.buildWebElement("knowledgecenter").getText();
		String actual = "Knowledge Center";
		Assert.assertEquals(expected, actual);

	}

	@AfterTest
	public void closeallbrowser() {
		Keyword.closebrowser();
	}
}
