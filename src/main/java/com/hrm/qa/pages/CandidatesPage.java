package com.hrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.qa.pages.CandidatesPage;
import com.hrm.qa.base.TestBase;

public class CandidatesPage extends TestBase {

	@FindBy(xpath = "//a[@class='toggle tiptip']")
	WebElement candidateLabel;
	
	@FindBy(id="btnAdd")
	WebElement newCandidateLink;
	
	
	
	// Initializing the Page Objects:
	public CandidatesPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyCandidatesLabel(){
		return candidateLabel.isDisplayed();
	}
	
	
	public NewCandidatePage clickOnNewCandidateLink(){
		if(candidateLabel.isDisplayed()) {
	        newCandidateLink.click();
		}
		else {
			System.out.println("stuck");
		}
	
	return new NewCandidatePage();
}
	
	

	

	
	
	

}