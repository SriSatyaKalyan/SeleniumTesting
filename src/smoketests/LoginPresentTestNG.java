package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
//import junit.framework.Assert;

public class LoginPresentTestNG {
	WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		boolean emailBoxPresent = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean passwordBoxPresent = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(emailBoxPresent);//, "Email Box Present");
		Assert.assertTrue(passwordBoxPresent);//, "Password Box Present");
	}
	
	@BeforeMethod
	public void testSetup() {
		System.out.println("Setting up the test");
		String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		
		driver = utilities.DriverFactory.open("chrome");
		driver.get(webURL);
	}
	
	@AfterMethod
	public void testbreakDown() {
		System.out.println("Tearing down the test");
		driver.close();
	}
}
