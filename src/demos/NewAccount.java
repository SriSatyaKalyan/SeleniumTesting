package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		//Defining variables and replacing them with the parameters provided
		String name = 		 "Robin Williams";
		String email = 		 "robinw@testmail.com";
		String phonenumber = "12345654321";
		String password = 	 "rwilliams";
		String country = 	 "France";
		String browserType = "chrome";
		WebDriver driver;
		
		String gender =           "female";
		boolean weeklyEmail =     true;
		boolean monthlyEmail =    false;
		boolean occasionalEmail = true;
		
		//1. Create WebDriver
		//Options for cross-browsing
		driver = utilities.DriverFactory.open(browserType);
		
		//2. Open browser to go to the Account Management Page and Click on New Account button
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();
		
		//Creating WebElements for better understandability
		WebElement nameElement = 			driver.findElement(By.id("MainContent_txtFirstName"));
		WebElement emailElement = 			driver.findElement(By.name("ctl00$MainContent$txtEmail"));
		WebElement phonenumberElement = 	driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passwordElement = 		driver.findElement(By.cssSelector("input[type='password']"));
		WebElement verifypasswordElement = 	driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword']")); 
		WebElement maleElement = 			driver.findElement(By.id("MainContent_Male"));
		WebElement femaleElement = 			driver.findElement(By.id("MainContent_Female"));
		WebElement countryElement = 		driver.findElement(By.id("MainContent_menuCountry"));
		
		WebElement weeklyEmailElement = 	driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement monthlyEmailElement = 	driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement occasionalEmailElement = driver.findElement(By.id("MainContent_checkUpdates"));
		WebElement submitButtonElement =    driver.findElement(By.name("ctl00$MainContent$btnSubmit"));
		
		//3. Fill the form by populating the fields
		nameElement.sendKeys(name); //Filling the name
		emailElement.sendKeys(email); // Filling the email address
		phonenumberElement.sendKeys(phonenumber); //Filling the phone number field
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
		
		driver.close();

	}

}
