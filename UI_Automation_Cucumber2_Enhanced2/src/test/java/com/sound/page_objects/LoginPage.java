package com.sound.page_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sound.utilities.CommonUtils;
import com.sound.webdriver_manager.DriverManager;

public class LoginPage {
	
	private static LoginPage loginInstance;
	private LoginPage() {
	}
	public static LoginPage getInstance() {
		if (loginInstance==null) {
			loginInstance=new LoginPage();
		}
		return loginInstance;
	}
	By USERNAME=By.id("txt-username");
//	By PASSWORD=By.id("txt-password");
//	By LOGIN_BUTTON=By.id("btn-login");
	
	WebDriver driver=DriverManager.getDriver();
	
	//By using PageFactory
//	@FindBy(id="txt-username")
//	private WebElement USERNAME;
	@FindBy(id="txt-password")
	private WebElement PASSWORD;
	@FindBy(id="btn-login")
	private WebElement LOGIN_BUTTON;
	
//	public WebElement getUSERNAME() {
//		return USERNAME;
//	}
//	public WebElement getPASSWORD() {
//		return PASSWORD;
//	}
//	public WebElement getLOGIN_BUTTON() {
//		return LOGIN_BUTTON;
//	}
	
	public void enterUserName(String username) {
		try {
		CommonUtils.getInstance().highlightElement(driver.findElement(USERNAME));
		driver.findElement(USERNAME).sendKeys(username);
		}catch(Exception e) {
			System.out.println("Element not found. Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
			}catch(Exception e2) {
				System.out.println("Element not found. Please check the locator used");
			}
		}
	}
	
	public void enterPassword(String password) {
		PASSWORD.sendKeys(password);
	}
	
	public void clickLogin() {
		LOGIN_BUTTON.click();
	}

}
