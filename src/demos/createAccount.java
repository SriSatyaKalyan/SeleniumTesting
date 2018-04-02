package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class createAccount {

	public static void main(String[] args) {
		//1. Create WebDriver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\satya\\Desktop\\Eclipse Workspace\\Selenium Software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//2. Open browser to go to the Account Management Page and Click on New Account button
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("Create Account")).click();
		
		//3. Fill the form by populating the fields
		
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Robin Williams"); //Filling the name
		
		driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys("robinw@testmail.com"); // Filling the email address
		
		driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("12345654321"); //Filling the phone number field
		
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("rwilliams"); //Filling the password field
		
		driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword']")).sendKeys("rwilliams"); //Filling the Verifypassword field
		
		//Code for different formats like radio buttons, drop down menus and multiple choices.		
		driver.findElement(By.id("MainContent_Male")).click(); //Selecting the Male radio button in the gender option
		
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("France"); //Selecting the country through the dropdown menu
		
		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click(); //MULTIPLE CHOICE
		
		driver.findElement(By.name("ctl00$MainContent$btnSubmit")).click(); //Clicking the Submit button
		
		//4. Get Confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("The confirmation message is: "+conf);
		
		//5. Close the browser
		driver.close();

	}

}
