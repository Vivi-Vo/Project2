package com.revature.testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.revature.assignforce.pages.LoginPage;
import com.revature.util.WebDriverHelper;

public class LoginPageTests {
	private static WebDriver driver;
	
	@BeforeSuite
	public static void setupDriver() {
		driver = WebDriverHelper.launchApplication("https://assignforce-client.cfapps.io", true);
	}
	
	@Test(groups="manager")
	public static void managerIsAbleToLogin() {
		try {
			LoginPage l = new LoginPage(driver);
			l.attemptManagerLogin();
			
			Boolean pass = false;
			try {				
				pass = WebDriverHelper.waitForUrlToContain(driver, "overview");
			} catch (Exception e) {
				Assert.fail("Manager homepage failed to load after login / or took too long to load");
			}
			
			Assert.assertTrue(pass, "Failed to navigate to overview page after manager login");
		} catch (IOException e) {
			Assert.fail("Unable to run test, check locator.properties file");
		}
	}
	
	@AfterSuite
	public static void closeDriver() {
		driver.quit();
	}
}
