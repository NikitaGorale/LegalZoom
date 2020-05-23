package com.legalzoom.legalz;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.log4testng.Logger;

import com.legalzoom.customeutils.PropertiesUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	private static Logger log = Logger.getLogger(Keyword.class);
	public static WebDriver driver;

	public static void openBrowser(String browser) {
		log.info("Browser open" + browser);
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		case "HtmlUnit":
			driver = new HtmlUnitDriver();
		default:
			break;

		}
	}

	public static String alertgettext() {
		return driver.switchTo().alert().getText();
	}

	public static void alertaccept() {
		driver.switchTo().alert().accept();

	}

	public static void launchUrl(String url) {
		log.info("Web Site Url" + url);
		driver.get(url);
	}

	public static String getTitle(String title) {
		return buildWebElement("title").getText();
	}

	public static String getWelcome(String welcome) {
		return buildWebElement("welcome").getText();
	}

	public static void myaccount() {

		buildWebElement("myaccount").click();
	}

	public static void acceptcookies() {
		buildWebElement("cookies").click();
	}

	public static void usernameandpassword() {
		buildWebElement("emailid").sendKeys(PropertiesUtils.getLocator("username"));
		buildWebElement("password").sendKeys(PropertiesUtils.getLocator("pass"));
		buildWebElement("signin").click();
	}

	public static void addwait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static WebElement buildWebElement(String locator) {
		return driver.findElement(By.xpath(PropertiesUtils.getLocator(locator)));
	}

	public static List<WebElement> buildWebElementList(String locator) {

		return (List<WebElement>) driver.findElement(By.xpath(PropertiesUtils.getLocator(locator)));
	}

	public static void closebrowser() {
		driver.close();
		driver = null;
	}

	public String getscreenshortpath(String testCaseName, WebDriver driver1) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String today = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
		String des = System.getProperty("user.dir") + "\\reports\\" + testCaseName + "_" + today + ".JPG";
		try {
			FileUtils.copyFile(src, new File(des));

		} catch (IOException e) {
			System.err.println("File Not created");
			e.printStackTrace();
		}
		return des;
		
		/*
		 * AShot ashot=new AShot();
		Screenshot src=ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(src.getImage(), "JPG", new File("D:\\Nisha\\aa.jpg"));
		 */
	}
}
