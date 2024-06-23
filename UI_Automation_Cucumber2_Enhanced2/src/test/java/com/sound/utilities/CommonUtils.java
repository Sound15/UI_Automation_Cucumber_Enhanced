package com.sound.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sound.constants.Constants;
import com.sound.page_objects.ConformationPage;
import com.sound.page_objects.DetailsPage;
import com.sound.page_objects.HomePage;
import com.sound.page_objects.LoginPage;
import com.sound.step_defnitions.Common_Step_Defnition;
import com.sound.webdriver_manager.DriverManager;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class CommonUtils {
	
	private static final Logger LOGGER=LogManager.getLogger(CommonUtils.class);
	private static CommonUtils commonUtilsInstance;
	private CommonUtils() {
	}
	public static CommonUtils getInstance() {
		if(commonUtilsInstance==null) {
			commonUtilsInstance=new CommonUtils();
		}
		return commonUtilsInstance;
	}

	
	public void loadProperties() throws FileNotFoundException {
		
		Properties properties=new Properties();
		try {
			
			properties.load(getClass().getResourceAsStream("/config.properties"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		Constants.APP_URL=properties.getProperty("APP_URL");
		Constants.BROWSER=properties.getProperty("BROWSER");
		Constants.USERNAME=properties.getProperty("UserName");
		Constants.PASSWORD=properties.getProperty("Password");
		
		
		
	}
	
	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(),LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(),HomePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(),DetailsPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(),ConformationPage.getInstance());
	}
	
	public void takeScreenshot() {
		File screenshot=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot,new File("screenshot.png"));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void highlightElement(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor)DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
	}
	
	public void selectFromDropDown(WebElement dropDown,String howTo,String value) {
		Select select=new Select(dropDown);
		switch(howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "text":
			select.selectByVisibleText(value);
			break;
		default:
			LOGGER.info("Please provide a valid selection to the feature file. Valid selections are text, value, index");
			break;
		}
	}
	} 
  
