package smoketests;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

//import junit.framework.Assert;

public class pageTitleJUnit {
	//Declaring the variables at CLASS level as it allows the variables to be access
	String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	WebDriver driver;
	
	@Test
	public void pageTitleTest() {
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Training | Account Management";
		Assert.assertEquals(expectedTitle, actualTitle);
		//Assert.fail("We intentionally failed this test");
	}
	
	@Before
	public void Setup() {
		System.out.println("Initializing the driver");
		driver = utilities.DriverFactory.open("chrome");
	}
	
	@After
	public void TearDown() {
		System.out.println("Closing the test down");
		driver.close();
	}
}
