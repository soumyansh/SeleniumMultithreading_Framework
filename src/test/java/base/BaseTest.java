package base;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import generic.DriverProvider;
import generic.ExcelReader;
import generic.Reporting;

public class BaseTest extends Reporting{

public String ScreenShotName;

	
	public void CaptureScreenshot() throws IOException {
		
		Date d = new Date();
		String d1 = d.toString().replace(":", "_").replace(" ", "_");

		ScreenShotName = "Screen_" + d1+System.nanoTime() + ".jpg";
		File scr = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String destpath = System.getProperty("user.dir") + "//src//test//resources//Screenshots//" + ScreenShotName;
		File dest = new File(destpath);
		FileUtils.copyFile(scr, dest);
		getLogger().addScreenCaptureFromPath(destpath);

	}
	@BeforeSuite
	public void setUp() throws IOException {
		try {
			File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots");
			FileUtils.cleanDirectory(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		initializeReport();
	}
	
	public void clickElement(String xpath) {
		WebElement ele= getDriver().findElement(By.xpath(xpath));
		ele.click();
	}
	
	public void sendKeys(String xpath,String text) {
		getDriver().findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public WebDriver getDriver() {
		DriverProvider.getInstance().getDriver().manage().window().maximize();
		return DriverProvider.getInstance().getDriver();
	}
	
	public ExtentTest getLogger() {
		return DriverProvider.testLogger.get();
	}
	
	public ExcelReader getExcel() {
		return DriverProvider.excel.get();
	}
	
	public void cleanup() 
	{
		
		DriverProvider.getInstance().removeDriver();
		DriverProvider.getInstance().removeExcel();
		DriverProvider.getInstance().removeLogger();
	}
	
	@AfterSuite
	public void afterSuite() {
		generateReport();
	}
}
