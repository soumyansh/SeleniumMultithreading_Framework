package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.Test;

import base.BaseTest;
import generic.Utilities;

public class SampleTests extends BaseTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void one(Hashtable<String, String> data,Method m) throws InterruptedException, IOException {

		getLogger().info(m.getName()+"_"+data.get("Fname") + "_" + data.get("Lname"));
		System.out.println(Thread.currentThread().getId());
		getDriver().manage().window().maximize();
		getDriver().get("https://www.google.com");
		sendKeys("//*[@name='q']", data.get("Fname"));
		sendKeys("//*[@name='q']", data.get("Lname"));
		CaptureScreenshot();
		Thread.sleep(8000);

	}

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void two(Hashtable<String, String> data,Method m) throws InterruptedException, IOException {

		System.out.println(Thread.currentThread().getId());
		getLogger().info(m.getName()+"_"+data.get("Fname") + "_" + data.get("Lname"));
		getDriver().manage().window().maximize();
		getDriver().get("https://www.google.com");
		sendKeys("//*[@name='q']", data.get("Fname"));
		sendKeys("//*[@name='q']", data.get("Lname"));
		CaptureScreenshot();
		Thread.sleep(8000);

	}

	@Test()
	public void three(Method m) throws InterruptedException, IOException {

		System.out.println(Thread.currentThread().getId());
		getLogger().info(m.getName()+"_"+"Bla");
		getDriver().manage().window().maximize();
		getDriver().get("https://www.google.com");
		sendKeys("//*[@name='q']", "Bla");

		CaptureScreenshot();
		Thread.sleep(8000);

	}

	@Test()
	public void four(Method m) throws InterruptedException, IOException {

		System.out.println(Thread.currentThread().getId());
		getLogger().info(m.getName()+"_"+"Boo");
		getDriver().manage().window().maximize();
		getDriver().get("https://www.google.com");

		sendKeys("//*[@name='q']", "Boo");
		CaptureScreenshot();
		Thread.sleep(8000);

	}

	@Test()
	public void five(Method m) throws InterruptedException, IOException {

		System.out.println(Thread.currentThread().getId());
		getLogger().info(m.getName()+"_"+"Conclusion");
		getDriver().manage().window().maximize();
		getDriver().get("https://www.google.com");
		
		sendKeys("//*[@name='q']", "Conclusion");
		CaptureScreenshot();
		Thread.sleep(8000);

	}

}