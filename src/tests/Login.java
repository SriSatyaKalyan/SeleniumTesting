package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.DashboardPage;
import pages.LoginPage;

public class Login {
	WebDriver driver;
	
	@Test
	public void loginTestPOM() {
		
		//1. Initialize driver
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		
		//2. Enter login information (Login Page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userName("tim@testemail.com");
		loginPage.setPassword("trpass");
		loginPage.clickLogin();
		
		//3. Get Confirmation (Confirmation Page)
		DashboardPage dashboardPage = new DashboardPage(driver);
		String confirmationmessage = dashboardPage.confirmationMessage();
		//System.out.println(confirmationmessage);
		
		//Assertions
		Assert.assertTrue(confirmationmessage.contains("success"));
		
		//4. Close the driver
		driver.quit();
	}
	
	@Before
	public void setup() {
		String browserType = "firefox";
		driver = utilities.DriverFactory.open(browserType);
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}
	

}
