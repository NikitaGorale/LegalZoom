package com.legalzoom.hometest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.legalzoom.customeutils.PropertiesUtils;
import com.legalzoom.legalz.Keyword;

import junit.framework.Assert;

public class LegalZoomHomePageTest extends PropertiesUtils {
	private static Logger log = Logger.getLogger(LegalZoomHomePageTest.class);
	public WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		if (log.isDebugEnabled()) {
			log.debug("entering openBrowser()");
		}
		Keyword.openBrowser("chrome");
		if (log.isDebugEnabled()) {
			log.debug("exiting openBrowser()");
		}
	}

	/**
	 * Verify LegalZoom WebSite Home page after login verified url
	 */
	@Test(description = "Verifed Home page of LegalZoom")
	public void verifyhomepage() {
		if (log.isDebugEnabled()) {
			log.debug("entering verifyhomepage()");
		}
		log.info("Verify Home Page");
		Keyword.launchUrl(PropertiesUtils.getLocator("url"));
		String actual = "© LegalZoom.com, Inc. All rights reserved.";
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.err.println("Error in Home Page");
			e.printStackTrace();
		}
		Keyword.acceptcookies();
		String expected = Keyword.getTitle("title");
		log.info("LegalZoomHomePageTest expected" + expected);
		Assert.assertEquals(expected, actual);
		if (log.isDebugEnabled()) {
			log.debug("exiting verifyhomepage()");
		}
	}

	@AfterTest
	public void closeallbrowser() {
		if (log.isDebugEnabled()) {
			log.debug("entering closeallbrowser()");
		}
		Keyword.closebrowser();
		if (log.isDebugEnabled()) {
			log.debug("exiting closeallbrowser()");
		}
	}

}
