package com.hrm.qa.testcasses;


import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.NewCandidatePage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;
import com.hrm.qa.pages.CandidatesPage;


	public class NewCandidatePageTest extends TestBase {

		LoginPage loginPage;
		HomePage homePage;
		TestUtil testUtil;
		NewCandidatePage newCandidatePage;
		CandidatesPage candidatesPage;
		
		String sheetName = "candidates";
		
		   
		public NewCandidatePageTest(){
				super();
				
		}
		
		
		@BeforeMethod
		public void setUp() throws InterruptedException {
			
			initialization();
			testUtil = new TestUtil();
			newCandidatePage = new NewCandidatePage();
			loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			
			candidatesPage = homePage.clickOnCandidatesLink();
			newCandidatePage = candidatesPage.clickOnNewCandidateLink();
			Thread.sleep(4000);
		}
		
		@Test(priority=1)
		public void verifyNewCandidatePageLabel(){
			Assert.assertTrue(newCandidatePage.verifyNewCandidateLabel(), "new candidate label is missing on the page");
		}
		
	
		@DataProvider
		public Object[][] getHRMTestData(){
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}

		
		@Test(priority=2, dataProvider="getHRMTestData")
		public void CreateNewCandidate(String ftName, String ltName, String em){
		//newCandidatePage = candidatesPage.clickOnNewCandidateLink();	
		newCandidatePage.createNewCandidate(ftName, ltName, em);
			
		}
		
		

		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
		

	}
