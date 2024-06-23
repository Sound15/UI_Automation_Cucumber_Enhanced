package com.sound.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sound.utilities.CommonUtils;

public class HomePage {
	
	private static HomePage homeInstance;
	private HomePage() {
	}
	public static HomePage getInstance() {
		if (homeInstance==null) {
			homeInstance=new HomePage();
		}
		return homeInstance;
	}
	
	@FindBy(id="btn-make-appointment")
	private WebElement MAKE_APPOINTMENT;

//	public WebElement getMAKE_APPOINTMENT() {
//		return MAKE_APPOINTMENT;
//	}

	public void click_Make_App() {
		CommonUtils.getInstance().highlightElement(MAKE_APPOINTMENT);
		MAKE_APPOINTMENT.click();
	}
}
