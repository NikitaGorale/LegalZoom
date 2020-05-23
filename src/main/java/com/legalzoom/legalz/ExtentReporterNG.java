package com.legalzoom.legalz;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * for this report we required two class // ExtentReports , ExtentSparkReporter
 * @author Nisha Lodha.
 *
 */

public class ExtentReporterNG {
	static ExtentReports extent;

	public static ExtentReports getreportobject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("LegalZoom site Automation Report");
		report.config().setDocumentTitle("Test Result of LegalZoom");
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Nisha Lodha");
		return extent;

}
}