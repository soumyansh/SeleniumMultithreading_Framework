package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import generic.DriverProvider;
import generic.ExcelReader;

public class CustomListener extends BaseTest implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext m) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
	
		cleanup();

	}

	public void onTestSkipped(ITestResult arg0) {
	
		cleanup();

	}

	public void onTestStart(ITestResult m) {
		ExtentTest testLogger = report.createTest(m.getName());
		DriverProvider.getInstance().testLogger.set(testLogger);
		


	}

	public void onTestSuccess(ITestResult arg0) {
		DriverProvider.getInstance().testLogger.remove();
		cleanup();

	}

}
