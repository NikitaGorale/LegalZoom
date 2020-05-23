package com.legalzoom.accountoverview;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.legalzoom.customeutils.PropertiesUtils;
import com.legalzoom.legalz.Keyword;

import junit.framework.Assert;

/**
 * /** Verify New Order in Account Overview page in Legal Zoom Site
 * 
 * @author Nisha Lodha
 *
 */

public class AccountOverviewBeginanewOrderTest {
	@BeforeTest
	public void openBrowser() {
		Keyword.openBrowser("chrome");
	}

	@Test
	public void verifybeginaneworder() {
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
		Select dropdown = new Select(Keyword.buildWebElement("dropdown"));
		dropdown.selectByValue("/limited-liability-company/limited-liability-company-overview.html");
		Keyword.buildWebElement("getstarted").click();
		String actual = "Start your business with confidence";
		String expected = Keyword.buildWebElement("headtitle").getText();
		Assert.assertEquals(expected, actual);

	}

	@AfterTest
	public void closeallbrowser() {
		Keyword.closebrowser();
	}
}
