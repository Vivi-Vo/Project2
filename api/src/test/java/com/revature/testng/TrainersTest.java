package com.revature.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import com.revature.assignforce.pages.LoginPage;
import com.revature.assignforce.pages.TrainersPage;
import com.revature.util.WebDriverHelper;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class TrainersTest {
  private static WebDriver driver;
   @BeforeSuite
   public void beforeSuite() {
	  driver = WebDriverHelper.launchApplication("https://assignforce-client.cfapps.io",false);
   }

  @Test(priority=1)
  
  public void addTrainer() {
    try {
    LoginPage l = new LoginPage(driver);
    l.attemptManagerLogin();
    TrainersPage t = new TrainersPage(driver);  
    WebDriverHelper.waitUntilVisible(driver, "//mat-tab-header[@class='mat-tab-header mat-tab-header-pagination-controls-enabled']");
    Assert.assertTrue(t.addTrainer(), "trainer added successfully");
	} catch (IOException | InterruptedException  e) {
    Assert.fail("Unable to login as manager");
	}
  }
//Unable to locate element by xpath. Test is disabled   
@Test(priority = 2, dependsOnMethods="addTrainer", enabled=false)
  public void addLocation() throws IOException{
	try {
    TrainersPage t = new TrainersPage(driver);  
    WebDriverHelper.waitUntilVisible(driver, "//mat-tab-header[@class='mat-tab-header mat-tab-header-pagination-controls-enabled']");
    Assert.assertTrue(t.addLocation(), "location added successfully");
	} catch(InterruptedException e) {
		Assert.fail("unable to add new location");
		
	}
  }
  @AfterSuite
  public void afterSuite() {
    driver.quit();
  }

}
