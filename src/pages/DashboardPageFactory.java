package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;
//import org.testng.Assert;

public class DashboardPageFactory {
	WebDriver driver;
	
	@FindBy(id="conf_message")
	WebElement confirmationMessageElement;
	
	@FindBy(linkText="Change password")
	WebElement changePasswordElement;
	
	public DashboardPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String confirmationMessage() {
		return confirmationMessageElement.getText();
	}
	
	public void changePassword() {
		changePasswordElement.click();
	}
	
	public void dashboard() {
		String message = confirmationMessage();
		Assert.assertTrue(message.contains("success"));
	}
	
}
