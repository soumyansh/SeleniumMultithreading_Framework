package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import generic.Utilities;
import pages.HomePage;
import pages.LoginPage;

public class Smoke extends BaseTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void one(Hashtable<String, String> data,Method m) throws InterruptedException, IOException {
		getLogger().info(data.get("Fname"));
		LoginPage lp=new LoginPage();
		lp.navigateToLoginPage();
		lp.doLogin("Admin", "admin123");
		HomePage hp=new HomePage();
		hp.assignLeave(data.get("Fname"));
		CaptureScreenshot();
	}

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void two(Hashtable<String, String> data,Method m) throws InterruptedException, IOException {
		getLogger().info(data.get("Fname"));
		LoginPage lp=new LoginPage();
		lp.navigateToLoginPage();
		lp.doLogin("Admin", "admin123");
		HomePage hp=new HomePage();
		hp.leaveList(data.get("Fname"));
		CaptureScreenshot();
		
	}

	
	
}