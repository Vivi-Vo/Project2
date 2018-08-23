package com.revature.testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.revature.assignforce.pages.HomePage;
import com.revature.assignforce.pages.LoginPage;
import com.revature.util.WebDriverHelper;

public class HomePageTest {
	  private static WebDriver driver;
	   @BeforeSuite
	   public void beforeSuite() {
		  driver = WebDriverHelper.launchApplication("https://assignforce-client.cfapps.io",true);
	   }
	   @Test(priority=1)
	   public void managerIsAbleToClickBetweenTabs(){
	     try{
	       LoginPage l = new LoginPage(driver);
	       l.attemptManagerLogin();
	       HomePage h = new HomePage(driver);
	       Assert.assertTrue(h.clickTabs(), "manager is able to move between tabs");
	     }catch(IOException e){
	       Assert.fail("Unable to click between tabs");
	     }
	   }
	   @Test(priority = 2, dependsOnMethods="managerIsAbleToClickBetweenTabs")
	   public void reportRouteIsCorrect() throws IOException {
		   try {
		   HomePage h = new HomePage(driver);
		   Assert.assertTrue(h.clickReportTabs(), "report route is correct");
		   }catch(Exception e) {
			   Assert.fail("report route is incorrect");
		   }
	   }
	   @Test(priority = 3, dependsOnMethods="managerIsAbleToClickBetweenTabs")
	   public void settingRouteIsCorrect() throws IOException {
		   try {
		   HomePage h = new HomePage(driver);
		   Assert.assertTrue(h.clickSettingTabs(), "setting route is correct");
		   }
		   catch(Exception e) {
			   Assert.fail("setting route is incorrect");
		   }
	   }

	   @AfterSuite
	   public void afterSuite() {
	     driver.quit();
	   }

}
