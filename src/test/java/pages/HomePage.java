package pages;

import org.openqa.selenium.By;

import base.BaseTest;

public class HomePage extends BaseTest {
	
	
	public void assignLeave(String text) {
		getDriver().findElement(By.xpath("(//*[text()='Assign Leave'])[2]")).click();
		getDriver().findElement(By.id("assignleave_txtEmployee_empName")).sendKeys(text);
	}
	
	public void leaveList(String text) {
		getDriver().findElement(By.xpath("(//*[text()='Leave List'])[2]")).click();
		getDriver().findElement(By.id("leaveList_txtEmployee_empName")).sendKeys(text);
	}

}
