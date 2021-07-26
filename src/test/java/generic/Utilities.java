package generic;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import base.BaseTest;

public class Utilities extends BaseTest {

	

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {
		DriverProvider.getInstance().excel.set(new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\TestData.xlsx"));
		String sheetName = m.getName();

		int rows = getExcel().getRowCount(sheetName);

		int cols = getExcel().getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(getExcel().getCellData(sheetName, colNum, 1), getExcel().getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}

}
