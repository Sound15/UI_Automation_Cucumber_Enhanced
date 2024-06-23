package com.sound.step_defnitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import com.sound.constants.Constants;
import com.sound.page_objects.ConformationPage;
import com.sound.page_objects.DetailsPage;
import com.sound.page_objects.HomePage;
import com.sound.page_objects.LoginPage;
import com.sound.utilities.CommonUtils;
import com.sound.webdriver_manager.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_Appointment_Booking_Step_Def {
	
	private static final Logger LOGGER=LogManager.getLogger(Verify_Appointment_Booking_Step_Def.class);
	
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		try {
	    DriverManager.getDriver().get(Constants.APP_URL);
		}catch(Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	}

	@And("the user clicks on the make appointment button")
	public void the_user_clicks_on_the_make_appointment_button() {
		try {
			HomePage.getInstance().click_Make_App();
		    LOGGER.info("the user clicks on the make appointment option");
			}catch(Exception e) {
				LOGGER.error(e);
				CommonUtils.getInstance().takeScreenshot();
			}
	    
	}

	@And("the user logins using the username and password")
	public void the_user_login_using_the_username_and_password() {
		try {
			LoginPage.getInstance().enterUserName(Constants.USERNAME);
			LoginPage.getInstance().enterPassword(Constants.PASSWORD);
			LoginPage.getInstance().clickLogin();
		    
		    String url=DriverManager.getDriver().getCurrentUrl();
		    if(url.contains("appointment")) {
		    	LOGGER.info("the user is logged in successfully");
			}}catch(Exception e) {
				LOGGER.error(e);
				CommonUtils.getInstance().takeScreenshot();
			}
		
	    }
	

	@And("the user selects the facility as {string} from the dropdown using {string}")
	public void the_user_selects_the_facility_as_from_the_dropdown_using(String facilityname, String howTo) {
		try {
			CommonUtils.getInstance().selectFromDropDown(DetailsPage.getInstance().getFACILITY(),howTo,facilityname);
			LOGGER.info("the user selects the facility dropdown");
			}catch(Exception e) {
				LOGGER.error(e);
				CommonUtils.getInstance().takeScreenshot();
			}
		
	}
	

    @And("the user checks the checkbox of readmission")
    public void the_user_checks_the_checkbox_of_readmission() {
    	try {
    		DetailsPage.getInstance().clickReadmission();
        	LOGGER.info("the user checks the checkbox of readmission");
    		}catch(Exception e) {
    			LOGGER.error(e);
    			CommonUtils.getInstance().takeScreenshot();
    		}
    	
    }
	
    @Given("the user selects radiobutton of Medicaid Healthcare program")
    public void the_user_selects_radiobutton_of_medicaid_healthcare_program() {
    	try {
    		DetailsPage.getInstance().clickMedicaid();
        	LOGGER.info("the user selects radiobutton of Medicaid Healthcare program");
    		}catch(Exception e) {
    			LOGGER.error(e);
    			CommonUtils.getInstance().takeScreenshot();
    		}
    	
    }
    
    @Given("the user selects the Tenth date of next month")
    public void the_user_selects_the_tenth_date_of_next_month() {
    	try {
    		DetailsPage.getInstance().clickDatebox();
        	DetailsPage.getInstance().clickNext();
        	DetailsPage.getInstance().clickDate();
    		LOGGER.info("the user selects the Tenth date of next month");
    		}catch(Exception e) {
    			LOGGER.error(e);
    			CommonUtils.getInstance().takeScreenshot();
    		}
    	
    }
    
    @Given("the user adds necesssary comments as {string}")
    public void the_user_adds_necesssary_comments_as(String comment) {
    	try {
    		DetailsPage.getInstance().enterComment(comment);
        	LOGGER.info("the user adds necesssary comments as "+comment);
    		}catch(Exception e) {
    			LOGGER.error(e);
    			CommonUtils.getInstance().takeScreenshot();
    		}
    	
    }	

	@When("the user clicks on book appointment button")
	public void the_user_clicks_on_book_appointment_button() {
		try {
			DetailsPage.getInstance().clickBookApp();
		    LOGGER.info("the user clicks on book appointment button");
			}catch(Exception e) {
				LOGGER.error(e);
				CommonUtils.getInstance().takeScreenshot();
			}
	    
	}

	@Then("the user should see the title as {string}")
	public void the_user_should_see_the_title_as(String expectedTitle) {
		
		
			String actualTitle=ConformationPage.getInstance().getTitle();
		    if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		    	LOGGER.info("Expected Title is displayed");
		    }
		    else {
				LOGGER.error("Expected Ttile is not displayed");
				CommonUtils.getInstance().takeScreenshot();
			}
	    
	    	
	}
	
	@And("the user should see the facility as {string}")
		public void the_user_should_see_the_facility_as(String expectedFacility) {
		
			String actualFacility=ConformationPage.getInstance().getFacility();
		    if(actualFacility.equalsIgnoreCase(expectedFacility)) {
		    	LOGGER.info("Expected Facility is displayed");
		    
			}else{
				LOGGER.error("Expected Facility is not displayed");
				CommonUtils.getInstance().takeScreenshot();
			}
		
    }
	
	@And("the user should see the readmission status as {string}")
	public void the_user_should_see_the_readmission_status_as(String expectedStatus) {
		
			String actualReadmissionStatus=ConformationPage.getInstance().getReadmissionStatus();
		    if(actualReadmissionStatus.equals(expectedStatus)) {
		    	LOGGER.info("Expected Readmission status is displayed");
		   
			}else{
				LOGGER.error("Expected Readmission status is not displayed");
				CommonUtils.getInstance().takeScreenshot();
			}
		
	    
    }
	
	@And("the user should see the program as {string}")
	public void the_user_should_see_the_program_as(String expectedProgram) {
		
			String actualProgram=ConformationPage.getInstance().getProgram();
		    if(actualProgram.equals(expectedProgram)) {
		    	LOGGER.info("Expected Program is displayed");
		    }
		    else{
				LOGGER.error("Expected Program is not displayed");
				CommonUtils.getInstance().takeScreenshot();
			}
		
    }    
	    
	@And("the user should see the date as {string}")
	public void the_user_should_see_the_date_as(String expectedDate) {
		String actualDate=ConformationPage.getInstance().getDate();
		    if(actualDate.equals(expectedDate)) {
		    	LOGGER.info("Expected Date is displayed");
		    }
		    else{
				LOGGER.error("Expected Date is not displayed");
				CommonUtils.getInstance().takeScreenshot();
			}
		
	    
    }        
	    
	@And("the user should see the comment as {string}")
	public void the_user_should_see_the_comment_as(String expectedComment) {
		
			String actualComment=ConformationPage.getInstance().getComment();
		    if(actualComment.equals(expectedComment)) {
		    	LOGGER.info("Expected comment is displayed");
		    }
		    else{
				LOGGER.error("Expected comment is not displayed");
				CommonUtils.getInstance().takeScreenshot();
			}
		

	    
     }         
	    
	    
	    
}

