package com.revature.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import com.revature.assignforce.pages.LoginPage;
import com.revature.assignforce.pages.TrainersPage;
import com.revature.util.WebDriverHelper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class TrainersTest {
  private static WebDriver driver;
   @BeforeSuite
   public void beforeSuite() {
	  driver = WebDriverHelper.launchApplication("https://assignforce-client.cfapps.io",true);
   }

  @Test(priority=1, enabled=false)
  
  public void addTrainer() {
    try {
    LoginPage l = new LoginPage(driver);
    l.attemptManagerLogin();
    TrainersPage t = new TrainersPage(driver);  
    Assert.assertTrue(t.addTrainer(), "trainer added successfully");
	} catch (IOException | InterruptedException  e) {
    Assert.fail("Unable to add new trainer");
	}
  }

  @AfterSuite
  public void afterSuite() {
    driver.quit();
  }

}
