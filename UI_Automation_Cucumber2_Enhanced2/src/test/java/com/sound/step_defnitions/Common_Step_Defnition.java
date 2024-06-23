package com.sound.step_defnitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sound.constants.Constants;
import com.sound.utilities.CommonUtils;
import com.sound.webdriver_manager.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.messages.types.Scenario;

public class Common_Step_Defnition {
	
	private static final Logger LOGGER=LogManager.getLogger(Common_Step_Defnition.class);
	
	@Before
	public void beforeScenario() {
		LOGGER.info("Execution Started");
		try {
            
			LOGGER.info("Instantiating the CommonUtils and Loading the Properties File");
			CommonUtils.getInstance().loadProperties();
			LOGGER.info("Checking the driver is null or not");
			if(DriverManager.getDriver()==null) {
				LOGGER.info("Driver is null.Instantiating it!");
				DriverManager.launchbrowser();
				CommonUtils.getInstance().initWebElements();
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
