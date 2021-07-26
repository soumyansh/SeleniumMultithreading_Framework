package generic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting {

	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;

	public void initializeReport() {
		String reportPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\report.html";
		htmlReport = new ExtentHtmlReporter(reportPath);
		htmlReport.config().setDocumentTitle("Multithreading Report");
		htmlReport.config().setReportName("Automation Report");
		report = new ExtentReports();
		report.attachReporter(htmlReport);

	}

	public void generateReport() {

		report.flush();
		

	}

}
