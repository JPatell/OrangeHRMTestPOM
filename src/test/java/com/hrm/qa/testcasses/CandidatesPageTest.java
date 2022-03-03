package com.hrm.qa.testcasses;


//import org.apache.log4j.PropertyConfigurator;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.CandidatesPage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;

	public class CandidatesPageTest extends TestBase {

		LoginPage loginPage;
		HomePage homePage;
		TestUtil testUtil;
		CandidatesPage candidatesPage;
		
		String sheetName = "contacts";
		
		   
		public CandidatesPageTest(){
				super();
				
		}
		
		
		@BeforeMethod
		public void setUp() throws InterruptedException {
			
			initialization();
			testUtil = new TestUtil();
			candidatesPage = new CandidatesPage();
			loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			
			candidatesPage = homePage.clickOnCandidatesLink();
		}
		
		@Test(priority=1)
		public void verifyCandidatesPageLabel(){
			Assert.assertTrue(candidatesPage.verifyCandidatesLabel(), "contacts label is missing on the page");
		}
		
//		@Test(priority=2)
//		public void selectSingleContactsTest(){
//			contactsPage.selectContactsByName("test2 test2");
//		}
//		
//		@Test(priority=3)
//		public void selectMultipleContactsTest(){
//			contactsPage.selectContactsByName("test2 test2");
//			contactsPage.selectContactsByName("ui uiii");
//
//		}
		
//		@DataProvider
//		public Object[][] getCRMTestData(){
//			Object data[][] = TestUtil.getTestData(sheetName);
//			return data;
//		}
//		
//		
//		@Test(priority=4, dataProvider="getCRMTestData")
//		public void validateCreateNewContact(String title, String firstName, String lastName, String company){
//			homePage.clickOnNewContactLink();
//			contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
//			contactsPage.createNewContact(title, firstName, lastName, company);
//			
//		}
		
		

		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
		

	}


