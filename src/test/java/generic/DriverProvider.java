package generic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

public class DriverProvider {

	private DriverProvider() {

	}

	private static DriverProvider instance = new DriverProvider();

	public static DriverProvider getInstance() {
		return instance;

	}
	public static ThreadLocal<ExtentTest>testLogger=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExcelReader>excel=new ThreadLocal<ExcelReader>();
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
		@Override
		protected WebDriver initialValue() {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			return new ChromeDriver();
		}
	};

	public WebDriver getDriver() {
		
		return driver.get();
	}

	public void removeDriver() {
		driver.get().quit();
		driver.remove();
	}
	public void removeLogger() {
		testLogger.remove();
	}
	public void removeExcel() {
		excel.remove();
	}

}
