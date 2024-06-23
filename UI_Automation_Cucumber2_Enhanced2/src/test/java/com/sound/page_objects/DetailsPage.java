package com.sound.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.sound.utilities.CommonUtils;

public class DetailsPage {
	
	private static DetailsPage detailsInstance;
	private DetailsPage() {
	}
	public static DetailsPage getInstance() {
		if (detailsInstance==null) {
			detailsInstance=new DetailsPage();
		}
		return detailsInstance;
	}
	
	@FindBy(id="combo_facility")
	private WebElement FACILITY;
	
	@FindBy(id="chk_hospotal_readmission")
	private WebElement RE_ADMISSION;
	
	@FindBy(id="radio_program_medicaid")
	private WebElement MEDIC_AID;
	
	@FindBy(id="txt_visit_date")
	private WebElement DATE_BOX;

	
	@FindBy(className="next")
	private WebElement NEXT;

	
	@FindBy(xpath="//td[contains(text(),\"10\")]")
	private WebElement DATE;

	
	@FindBy(id="txt_comment")
	private WebElement COMMENT;

	
	@FindBy(id="btn-book-appointment")
	private WebElement BOOK_APPOINTMENT;


	public WebElement getFACILITY() {
		return FACILITY;
	}
//
//
//	public WebElement getRE_ADMISSION() {
//		return RE_ADMISSION;
//	}
//
//
//	public WebElement getMEDIC_AID() {
//		return MEDIC_AID;
//	}
//
//
//	public WebElement getDATE_BOX() {
//		return DATE_BOX;
//	}
//
//
//	public WebElement getNEXT() {
//		return NEXT;
//	}
//
//
//	public WebElement getDATE() {
//		return DATE;
//	}
//
//
//	public WebElement getCOMMENT() {
//		return COMMENT;
//	}
//
//
//	public WebElement getBOOK_APPOINTMENT() {
//		return BOOK_APPOINTMENT;
//	}

//	public void selectFacility(String facilityname) {
//		Select facility= new Select(FACILITY);
//		facility.selectByVisibleText(facilityname);
//	}
	
	public void clickReadmission() {
		RE_ADMISSION.click();
	}

	public void clickMedicaid() {
		MEDIC_AID.click();
	}
	
	public void clickDatebox() {
		DATE_BOX.click();
	}
	
	public void clickNext() {
		NEXT.click();
	}
	
	public void clickDate() {
		DATE.click();
	}
	
	public void enterComment(String comment) {
		COMMENT.sendKeys(comment);
	}
	
	public void clickBookApp() {
		CommonUtils.getInstance().highlightElement(BOOK_APPOINTMENT);
		BOOK_APPOINTMENT.click();
	}
}






