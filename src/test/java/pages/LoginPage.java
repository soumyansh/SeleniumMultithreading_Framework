package pages;

import org.openqa.selenium.By;

import base.BaseTest;

public class LoginPage extends BaseTest {
	
	public void navigateToLoginPage() {
		getDriver().get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	public void doLogin(String username,String password) {
		getDriver().findElement(By.id("txtUsername")).sendKeys(username);
		getDriver().findElement(By.id("txtPassword")).sendKeys(password);
		getDriver().findElement(By.id("btnLogin")).click();
	}

	
}
