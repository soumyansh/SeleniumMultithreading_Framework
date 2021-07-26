package tests;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import generic.DriverProvider;
import generic.ExcelReader;
import generic.Utilities;

public class SampleTests extends BaseTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void one(Hashtable<String, String> data) throws InterruptedException, IOException {

		getLogger().info(data.get("Fname")+"_"+data.get("Lname"));
		System.out.println(Thread.currentThread().getId());
		getDriver().manage().window().maximize();
		getDriver().get("https://www.google.com");
		sendKeys("//*[@name='q']", data.get("Fname"));
		sendKeys("//*[@name='q']", data.get("Lname"));
		CaptureScreenshot();
		Thread.sleep(8000);
		getDriver().quit();

	}

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void two(Hashtable<String, String> data) throws InterruptedException, IOException {

		System.out.println(Thread.currentThread().getId());
		getLogger().info(data.get("Fname")+"_"+data.get("Lname"));
		getDriver().manage().window().maximize();
		getDriver().get("https://www.google.com");
		sendKeys("//*[@name='q']", data.get("Fname"));
		sendKeys("//*[@name='q']", data.get("Lname"));
		CaptureScreenshot();
		Thread.sleep(8000);
		getDriver().quit();

	}

}