package com.sound.webdriver_manager;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.sound.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	public static final Logger LOGGER=LogManager.getLogger(DriverManager.class);
 private static WebDriver driver=null;
 public static void launchbrowser() {
	 try {
		 switch(Constants.BROWSER) {
		 case "chrome":
			 WebDriverManager.chromedriver().setup();
			 LOGGER.info("Launching "+Constants.BROWSER);
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			 break;
		 case "firefox":
			 WebDriverManager.firefoxdriver().setup();
			 LOGGER.info("Launching "+Constants.BROWSER);
			 driver=new FirefoxDriver();
			 break;
		 case "ie":
			 WebDriverManager.chromedriver().setup();
			 LOGGER.info("Launching "+Constants.BROWSER);
			 driver=new InternetExplorerDriver();
			 break;
		 case "edge":
			 WebDriverManager.chromedriver().setup();
			 LOGGER.info("Launching "+Constants.BROWSER);
			 driver=new EdgeDriver();
			 break;
		 default:
			 WebDriverManager.chromedriver().setup();
			 LOGGER.info("Launching "+Constants.BROWSER);
			 driver=new ChromeDriver();
			 break;
		 }
	 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 
 }
public static WebDriver getDriver() {
	return driver;
}
}
