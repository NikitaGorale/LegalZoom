package com.legalzoom.accountoverview;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.legalzoom.customeutils.PropertiesUtils;
import com.legalzoom.legalz.Keyword;

import junit.framework.Assert;

/**
 * verify scheduleNewAppointment in AccountOverview in signin page of LegalZoom
 * 
 * @author Nisha Lodha
 *
 */

public class AccountOverviewNewConsultation {
	@BeforeTest
	public void openBrowser() {
		Keyword.openBrowser("chrome");
	}

	@Test
	public void verifyschedulenewconsultation() {
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

		Keyword.buildWebElement("notinterested").click();
		Keyword.buildWebElement("newconsultation").click();
		Keyword.addwait();
		String expected = "Talk to an\nAttorney";
		String actual = Keyword.buildWebElement("talktoanattorney").getText();
		Assert.assertEquals(expected, actual);

	}

	@AfterTest
	public void closeallbrowser() {
		Keyword.closebrowser();
	}

}
