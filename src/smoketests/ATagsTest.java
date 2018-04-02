package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
	WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		//Test the number of ATags or hyperlinks in the page
		System.out.println("Running the test");
		 
		List <WebElement> aElements = driver.findElements(By.tagName("a"));
		int numberofAElements = aElements.size();
		System.out.println("The number of AElements are: "+numberofAElements);		
		for (WebElement aElement : aElements) {
			System.out.println("The element is " + aElement.getText());
		}
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
