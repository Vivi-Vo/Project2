package com.revature.assignforce.pages;

import com.revature.util.WebDriverHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainersPage {
    private WebDriver driver;
    private String trainerTab;
    private String addButton;
    private String first;
    private String last;
    private String email;
    private String submitButton;
    private String navbar;
    private static final String pageIdentifier = "trainer";

    public TrainersPage(WebDriver d) throws IOException {
        this.driver = d;
        Properties props = new Properties();
		InputStream inputPropertyFile = null;
		inputPropertyFile = new FileInputStream("src/test/resources/locator.properties"); 
		props.load(inputPropertyFile);
        this.trainerTab = props.getProperty("tab"+pageIdentifier);
        this.addButton= props.getProperty(pageIdentifier+"-addbtn");
        this.first = props.getProperty(pageIdentifier+"-firstname");
        this.last = props.getProperty(pageIdentifier+"-lastname");
        this.email = props.getProperty(pageIdentifier+"-email");
        this.submitButton=props.getProperty((pageIdentifier+"-submitbtn"));
        this.navbar = props.getProperty("navbar");        
    }
    
	public WebElement getTrainerTab() {
		return WebDriverHelper.waitUntilVisible(driver, trainerTab);
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
    public WebElement getNavbar() {
		return WebDriverHelper.waitUntilVisible(driver, navbar);
	}

	public boolean addTrainer() throws InterruptedException {
        Boolean added = false;
        getNavbar();
        getTrainerTab().click();
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
    
}
