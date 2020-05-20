package com.myOrganization.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.myOrganization.utilities.ExtentManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

/*
 * Here we will do all the initialization
  * 
 */
	

	public static Logger log= Logger.getLogger("devpinoyLogger");
	
	public static WebDriverWait wait;
	public ExtentReports rep= ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void setUp() {
		
		
		}
		
		
		
	
	
	

	
	

	
	
    @AfterSuite 
 	public void tearDown() {
    	
    
    		
    		log.debug("Test Execution completed");
    	}
    	
 		
 	}
	
	

