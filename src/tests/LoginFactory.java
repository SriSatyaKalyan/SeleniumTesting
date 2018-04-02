package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPageFactory;
import pages.LoginPageFactory;

public class LoginFactory {
	WebDriver driver;
	String username = "tim@testmail.com";
	String password = "trpass";
	
	@Test
	public void loginTestPageFactory(){
		
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(username, password);
		
		DashboardPageFactory dashboardPage = new DashboardPageFactory(driver);
		dashboardPage.dashboard();
	}
	
	@Before
	public void Setup() {
		//1. Initialize driver
		driver = utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
