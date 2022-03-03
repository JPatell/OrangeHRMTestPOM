package com.hrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.qa.base.TestBase;

public class NewCandidatePage extends TestBase {

	@FindBy(xpath = "//h1[@id='addCandidateHeading']")
	WebElement newCandidateLabel;
	
	@FindBy(id="addCandidate_firstName")
	WebElement firstName;
	
	@FindBy(id="addCandidate_lastName")
	WebElement lastName;
	
	@FindBy(id="addCandidate_email")
	WebElement email;
	
	@FindBy(id = "btnSave")
	WebElement saveBtn;
	
	
	
	// Initializing the Page Objects:
	public NewCandidatePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyNewCandidateLabel(){
		return newCandidateLabel.isDisplayed();
	}
	
	

	
	public void createNewCandidate(String ftName, String ltName, String em){
//		Select select = new Select(driver.findElement(By.name("title")));
//		select.selectByVisibleText(title);
//		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		email.sendKeys(em);
		saveBtn.click();
		
	}
	
// job vacancy?
	
	
	

}