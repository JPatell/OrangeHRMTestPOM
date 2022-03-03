package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@id='welcome']")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(id = "menu_recruitment_viewRecruitmentModule")
	WebElement recruitmentLink;
	
	@FindBy(id = "menu_recruitment_viewCandidates")
	WebElement candidatesLink;
	

	@FindBy(xpath = "//span[contains(text(),'Timesheets')]")
	WebElement timeSheetsLink;


	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public CandidatesPage clickOnCandidatesLink(){
		//Actions action = new Actions(driver);
		//action.moveToElement(recruitmentLink).build().perform();
		//candidatesLink.click();
		recruitmentLink.click();
		return new CandidatesPage();
	}
//	
//	public TimeSheetsPage timeSheetsLink(){
//		dealsLink.click();
//		return new DealsPage();
//	}

	
	
	
//	public void clickOnNewContactLink(){
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newContactLink.click();
		
//	}
	
	
	
	
	
	
	

}
