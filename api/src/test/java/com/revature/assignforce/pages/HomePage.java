package com.revature.assignforce.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.util.WebDriverHelper;

public class HomePage {
    private String overviewTab;
    private String batchesTab;
    private String locationTab;
    private String curriculaTab;
    private String trainerTab;
    private String reportTab;
    private String settingTab;
    private String navbar;
    private WebDriver driver;
    private static final String pageIdentifier = "tab";

    
    public HomePage(WebDriver d) throws IOException {
    	this.driver=d;
        Properties props = new Properties();
		InputStream inputPropertyFile = null;
		inputPropertyFile = new FileInputStream("src/test/resources/locator.properties"); 
		props.load(inputPropertyFile);

        this.navbar = props.getProperty("navbar");        
        this.overviewTab=props.getProperty(pageIdentifier+"-overview");
        this.trainerTab = props.getProperty(pageIdentifier+"-trainers");
        this.batchesTab=props.getProperty(pageIdentifier+"-batches");     
        this.curriculaTab=props.getProperty(pageIdentifier+"-curricula");   
        this.locationTab=props.getProperty(pageIdentifier+"-locations");        
        this.reportTab=props.getProperty(pageIdentifier+"-reports");        
        this.settingTab=props.getProperty(pageIdentifier+"-settings");        
	}

	public WebElement getOverviewTab() {
		return WebDriverHelper.waitUntilVisible(driver, overviewTab);
	}

    public WebElement getNavbar() {
		return WebDriverHelper.waitUntilVisible(driver, navbar);
	}

	public WebElement getBatchesTab() {
        return WebDriverHelper.waitUntilVisible(driver, batchesTab);
	}

	public WebElement getLocationTab() {
		return WebDriverHelper.waitUntilVisible(driver, locationTab);
	}

	public WebElement getCurriculaTab() {
		return WebDriverHelper.waitUntilVisible(driver, curriculaTab);
	}

	public WebElement getReportTab() {
		return WebDriverHelper.waitUntilVisible(driver, reportTab);
	}

	public WebElement getSettingTab() {
		return WebDriverHelper.waitUntilVisible(driver, settingTab);
	}

	public WebElement getTrainerTab() {
		return WebDriverHelper.waitUntilVisible(driver, trainerTab);
	}

    public boolean clickTabs(){
        boolean clicked = true;
        getNavbar();
        try {
        getOverviewTab().click();
        WebDriverHelper.waitForUrlToContain(driver, "/overview");

        getBatchesTab().click();
        WebDriverHelper.waitForUrlToContain(driver, "/batches");

        getCurriculaTab().click();
        WebDriverHelper.waitForUrlToContain(driver, "/curricula");

        getLocationTab().click();
        WebDriverHelper.waitForUrlToContain(driver, "/locations");
        }
        catch(Exception e) {
        	clicked=false;
        }
        return clicked;
    }    

    public boolean clickReportTabs(){
        boolean clicked=true;
        try{
        getReportTab().click();
        WebDriverHelper.waitForUrlToContain(driver, "/reports");
        }
        catch(Exception e){
            clicked=false;
        }
        return clicked;
    }

    public boolean clickSettingTabs(){
        boolean clicked=true;
        try{
            getSettingTab().click();
            WebDriverHelper.waitForUrlToContain(driver, "/settings");
            }
        catch(Exception e){
            clicked=false;
        }
        return clicked;
    }



}
