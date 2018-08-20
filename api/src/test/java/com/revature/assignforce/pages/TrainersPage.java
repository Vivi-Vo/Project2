package com.revature.assignforce.pages;

import com.revature.util.WebDriverHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TrainersPage {
    private WebDriver driver;
    private String tab;
    private String addButton;
    private String first;
    private String last;
    private String email;
    private String submitButton;

    private static final String pageIdentifier = "trainer";

    public TrainersPage(WebDriver d) throws IOException {
        this.driver = d;
        Properties props = new Properties();
		InputStream inputPropertyFile = null;
		inputPropertyFile = new FileInputStream("src/test/resources/locator.properties"); 
		props.load(inputPropertyFile);
        this.tab = props.getProperty(pageIdentifier + "-tab");
        this.addButton= props.getProperty(pageIdentifier+"-addbtn");
        this.first = props.getProperty(pageIdentifier+"-firstname");
        this.last = props.getProperty(pageIdentifier+"-lastname");
        this.email = props.getProperty(pageIdentifier+"-email");
        this.submitButton=props.getProperty((pageIdentifier+"-submitbtn"));
    }
    
    
	public WebElement getTab() {
		return WebDriverHelper.waitUntilVisible(driver, tab);
    }
    
	public WebElement getAddButton() {
		return WebDriverHelper.waitUntilVisible(driver, addButton);
	}
	public WebElement getFirst() {
		return WebDriverHelper.waitUntilVisible(driver, first);
	}
	public WebElement getLast() {
		return WebDriverHelper.waitUntilVisible(driver, last);
	}
	public WebElement getEmail() {
		return WebDriverHelper.waitUntilVisible(driver, email);
	}
	public WebElement getSubmitButton() {
		return WebDriverHelper.waitUntilVisible(driver, submitButton);
	}
	public boolean addTrainer() throws InterruptedException {
        Boolean added = false;
        getTab().click();
        getAddButton().click();
        getFirst().sendKeys("Test");
        getLast().sendKeys("NPE");
        getEmail().sendKeys("nullpointer@exception.com");
        getSubmitButton().click();

        if(driver.getPageSource().contains("Test NPE")){
            added=true;
        }
        return added;
    }
    
    public boolean addLocation() throws InterruptedException{
    	driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@id='mat-tab-label-0-2']")).click();
        driver.findElement(By.xpath("//mat-icon[contains(text(),'add_location')]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
        driver.findElement(By.xpath("mat-input-34")).sendKeys("NPE");
        driver.findElement(By.id("mat-input-35")).sendKeys("Null");
        driver.findElement(By.id("mat-input-36")).sendKeys("State");
        driver.findElement(By.xpath("//span[contains(text(),'Add')]")).click();
        Thread.sleep(300);

        if(driver.getPageSource().contains("NPE")){
            return true;
        }
        return false;
    }
  

    
}
