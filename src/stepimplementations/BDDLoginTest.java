package stepimplementations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDLoginTest {
	WebDriver driver;
	
	@Given("^User is on the Login page$")
	public void User_is_on_the_Login_page() {
		System.out.println("User is on the Login page");
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@When("^User enters correct username and correct password$")
	public void User_enters_correct_username_and_correct_password() {
		System.out.println("User enters correct username and correct password");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testmail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@When("^user enters email(.*)$")
	public void user_enters_username(String username){
		System.out.println("TESTING USERNAME: "+username);
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	
	@And("^user enters password(.*)$")
	public void user_enters_password(String password) {
		System.out.println("TESTING PASSWORD: "+password);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_btnLogin")).click();
		//The above line can be made into another @And but we did not do it
	}
	
	@Then("^User gets confirmation$")
	public void User_gets_confirmation() {
		System.out.println("User gets confirmation");
		Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("success"));
		driver.quit();
	}

}



























