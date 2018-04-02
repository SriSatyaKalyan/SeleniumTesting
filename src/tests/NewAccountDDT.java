package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name, email, phone, gender, password, country;
	boolean weeklyEmail, monthlyEmail, occasionalEmail;
	WebDriver driver;
	WebElement nameElement, emailElement, phonenumberElement, passwordElement, verifypasswordElement, maleElement, femaleElement, countryElement, weeklyEmailElement, monthlyEmailElement, occasionalEmailElement, submitButtonElement;
	
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD: " + name + " " + email + " " + phone + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);
				
		//3. Fill the form by populating the fields
		nameElement.sendKeys(name); //Filling the name
		emailElement.sendKeys(email); // Filling the email address
		phonenumberElement.sendKeys(phone); //Filling the phone number field
		passwordElement.sendKeys(password); //Filling the password field
		verifypasswordElement.sendKeys(password); //Filling the Verifypassword field
		
		//Code for different formats like radio buttons, drop down menus and multiple choices.		
		if (gender.equalsIgnoreCase("male")) {
			maleElement.click(); //Selecting the Male radio button in the gender option
		}else {
			femaleElement.click(); //Selecting the Female radio button in the gender option
		}
		
		new Select(countryElement).selectByVisibleText(country); //Selecting the country through the dropdown menu
		
		//Multiple checkboxes 
		if (weeklyEmail) {                              
			if(!weeklyEmailElement.isSelected()) {weeklyEmailElement.click();} 
		}else {
			if(weeklyEmailElement.isSelected()) {weeklyEmailElement.click();}
		}
		
		if (monthlyEmail) {                              
			if(!monthlyEmailElement.isSelected()) {monthlyEmailElement.click();} 
		}else {
			if(monthlyEmailElement.isSelected()) {monthlyEmailElement.click();}
		}
		
		if (occasionalEmail) {                              
			if(!occasionalEmailElement.isSelected()) {occasionalEmailElement.click();} 
		}else {
			if(occasionalEmailElement.isSelected()) {occasionalEmailElement.click();}
		}
				
		submitButtonElement.click(); //Clicking the Submit button
		
		//4. Get Confirmation & Close the browser
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		//System.out.println("The confirmation message is: " + conf);
		if (conf.equals("Customer information added successfully")) {
			System.out.println("TEST PASSED");
		}else {
			System.out.println("TEST FAILED");
		}
	}
	
	@Before
	public void setUp() {
		driver = utilities.DriverFactory.open("chrome"); 
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();
		
		nameElement = 			driver.findElement(By.id("MainContent_txtFirstName"));
		emailElement = 			driver.findElement(By.name("ctl00$MainContent$txtEmail"));
		phonenumberElement = 	driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		passwordElement = 		driver.findElement(By.cssSelector("input[type='password']"));
		verifypasswordElement = 	driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword']")); 
		maleElement = 			driver.findElement(By.id("MainContent_Male"));
		femaleElement = 			driver.findElement(By.id("MainContent_Female"));
		countryElement = 		driver.findElement(By.id("MainContent_menuCountry"));
		
		weeklyEmailElement = 	driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		monthlyEmailElement = 	driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		occasionalEmailElement = driver.findElement(By.id("MainContent_checkUpdates"));
		submitButtonElement =    driver.findElement(By.name("ctl00$MainContent$btnSubmit"));
	}
	
	@After
	public void TearDown() {
		driver.close();
	}
	
	@Parameters
	public static List<String[]> getdata(){
		List<String[]> mockparameter = utilities.CSV.get("C:\\Users\\satya\\Desktop\\Eclipse Workspace\\SeleniumTraining\\UserAccounts.csv");
		//System.out.println(mockparameter);
		return mockparameter;
	}
	
	public NewAccountDDT(String name, String email, String phonenumber, String gender, String password, String country, String weeklyEmail, String monthlyEmail, String occasionalEmail){
		this.name = name;
		this.email = email;
		this.phone = phonenumber;
		this.gender = gender;
		this.password = password;
		this.country = country;
		
		if (weeklyEmail.equals("TRUE")) { this.weeklyEmail = true; }
		else {this.weeklyEmail = false;}
		
		if (monthlyEmail.equals("TRUE")) { this.monthlyEmail = true; }
		else {this.monthlyEmail = false;}
		
		if (occasionalEmail.equals("TRUE")) { this.occasionalEmail = true; }
		else {this.occasionalEmail = false;}
	}		
}
