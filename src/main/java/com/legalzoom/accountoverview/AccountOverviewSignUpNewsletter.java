package com.legalzoom.accountoverview;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.legalzoom.customeutils.PropertiesUtils;
import com.legalzoom.legalz.Keyword;

/**
 * Verify sign Up for Our Newsletter in Account Overview page in Legal Zoom Site
 * 
 * @author Nisha Lodha
 *
 */

public class AccountOverviewSignUpNewsletter {
	@BeforeTest
	public void openBrowser() {
		Keyword.openBrowser("chrome");
	}

	@Test
	public void verifysignupforournewsletter() {
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
		Keyword.buildWebElement("signupfornewsletter").sendKeys(PropertiesUtils.getLocator("username"));
		Keyword.buildWebElement("signupnewsletter").click();
		String actual = "Thank you! You are now subscribed to the LegalZoom newsletter.";
		String expected = Keyword.alertgettext();
		Keyword.alertaccept();
		Assert.assertEquals(actual, expected);

	}

	@AfterTest
	public void closeallbrowser() {
		Keyword.closebrowser();
	}
}
