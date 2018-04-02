package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	
	WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password) {
		System.out.println("NEW RECORD: " + name + " " + email + " " + password);	
		//Find Elements: Locate the element, determine the action and pass the parameters
		//3. Enter email address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
		
		//4. Enter password
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		
		//5. Click on login button
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		
		//6. Get confirmation
		String confirmation_message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("The CONFIRMATION MESSAGE: "  + confirmation_message);
		
		String pageTitle = driver.getTitle();
		System.out.println("The pageTitle is: "+pageTitle);
	}
	
	@BeforeMethod
	public void setUp() {	
		//1. Define the web driver
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Desktop\\Eclipse Workspace\\Selenium Software\\chromedriver.exe");
		driver = utilities.DriverFactory.open("firefox");
		//2. Open web driver and navigate to the page
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@AfterMethod
	public void tearDown() {
		//7. Close the web browser
		driver.close();
	}
	
	@DataProvider
	public String[][] getData(){
		return utilities.Excel.get("C:\\Users\\satya\\Desktop\\Eclipse Workspace\\SeleniumTraining\\UserLogin.xls");
	}

}
