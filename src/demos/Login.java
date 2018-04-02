package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		//1. Define the web driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\Desktop\\Eclipse Workspace\\Selenium Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//2. Open web driver and navigate to the page
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//Find Elements: Locate the element, determine the action and pass the parameters
		
		//3. Enter email address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		
		//4. Enter password
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		
		//5. Click on login button
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		
		//6. Get confirmation
		String confirmation_message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("The CONFIRMATION MESSAGE: "  + confirmation_message);
		
		String pageTitle = driver.getTitle();
		System.out.println("The pageTitle is: "+pageTitle);
		
		//7. Close the web browser
		driver.close();
	}
}
