package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;

//import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class LoginStepDefinition{

	 WebDriver driver;

	
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
	 System.setProperty("webdriver.gecko.driver", "D:/Jay/QA course/SeleniumJars/geckodriver.exe");
	 driver = new FirefoxDriver();
	 driver.get("https://opensource-demo.orangehrmlive.com/");
	 }
	 
	 @When("^title of login page is OrangeHRM$")
	 public void title_of_login_page_is_OrangeHRM() {
	 String title = driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("OrangeHRM", title);
	 }
	
	// Reg Exp:
	// 1. \"([^\"]*)\"
	// 2. \"(.*)\"
	
	 @Then("^user enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password){
	 driver.findElement(By.name("txtUsername")).sendKeys(username);
	 driver.findElement(By.name("txtPassword")).sendKeys(password);
	 }
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() {
	 driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	// JavascriptExecutor js = (JavascriptExecutor)driver;
	 //js.executeScript("arguments[0].click();", loginBtn);
	 }
	
	
	 @Then("^user is on home page$")
	 public void user_is_on_home_page(){
	 String title = driver.getTitle();
	 System.out.println("Home Page title ::"+ title);
	 Assert.assertEquals("OrangeHRM", title);
	 }
	 
	 @Then("^user moves to candidates page$")
	 public void user_moves_to_candidates_page() {
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		
		}
	 
	 @Then("^user moves to new candidate page$")
	 public void user_moves_to_new_candidates_page() {
		driver.findElement(By.id("btnAdd")).click();
		
		}
	 
	 @Then("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	 public void user_enters_contacts_details(String firstname, String lastname, String email){
		 driver.findElement(By.id("addCandidate_firstName")).sendKeys(firstname);
		 driver.findElement(By.id("addCandidate_lastName")).sendKeys(lastname);
		 driver.findElement(By.id("addCandidate_email")).sendKeys(email);
		 driver.findElement(By.id("btnSave")).click();
	 }
	 

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
}
