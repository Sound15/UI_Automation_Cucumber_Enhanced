package com.sound.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConformationPage {
	
	private static ConformationPage conformationInstance;
	private ConformationPage() {
	}
	public static ConformationPage getInstance() {
		if (conformationInstance==null) {
			conformationInstance=new ConformationPage();
		}
		return conformationInstance;
	}
	

	@FindBy(xpath="//h2")
	private WebElement TITLE;
	
	@FindBy(id="facility")
	private WebElement FACILITY_CONF;
	
	@FindBy(id="hospital_readmission")
	private WebElement READMISSION_CONF;
	
	@FindBy(id="program")
	private WebElement PROGRAM_CONF;
	
	@FindBy(id="visit_date")
	private WebElement DATE_CONF;
	
	@FindBy(id="comment")
	private WebElement COMMENT_CONF;
	
	@FindBy(className="btn btn-default")
	private WebElement HOME_PAGE;

//	public WebElement getTITLE() {
//		return TITLE;
//	}
//
//	public WebElement getFACILITY_CONF() {
//		return FACILITY_CONF;
//	}
//
//	public WebElement getREADMISSION_CONF() {
//		return READMISSION_CONF;
//	}
//
//	public WebElement getPROGRAM_CONF() {
//		return PROGRAM_CONF;
//	}
//
//	public WebElement getDATE_CONF() {
//		return DATE_CONF;
//	}
//
//	public WebElement getCOMMENT_CONF() {
//		return COMMENT_CONF;
//	}
//
//	public WebElement getHOME_PAGE() {
//		return HOME_PAGE;
//	}

	public String getTitle(){
		return TITLE.getText();
	}
	
	public String getFacility(){
		return FACILITY_CONF.getText();
	}
	
	public String getReadmissionStatus(){
		return READMISSION_CONF.getText();
	}
	
	public String getProgram(){
		return PROGRAM_CONF.getText();
	}
	
	public String getDate(){
		return DATE_CONF.getText();
	}
	
	public String getComment(){
		return COMMENT_CONF.getText();
	}
	

}
