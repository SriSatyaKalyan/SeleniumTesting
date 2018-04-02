package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;
	String browserType = "chrome"; 
	String destinationCity = "New York, New York";
	String checkInDate = "04/12/2018";
	String checkOutDate = "04/19/2018";
	String searchResult = "3";
	
	@Test
	public void hotelReservation() {
	
		//1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();;
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(destinationCity);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkInDate);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOutDate);
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[4]/div[3]/div/ul/li/button")).click();
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[4]/div[3]/div/ul/li/div/div/div/div[2]/div[2]")).click();
		//driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();
		driver.findElement(By.cssSelector("button[class='btn-primary btn-action  gcw-submit']")).click();
		
		//Printing the name of the city
		String nameofCity = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
		System.out.println("CITY: "+nameofCity);
		
		
		//2. Modify the search results page by giving criteria
		//driver.findElement(By.cssSelector("input[name='star'][id='star4'])")).click();
		driver.findElement(By.id("star4")).click();
		
		//3. Analysze the results and make a selection
		//driver.findElement(By.xpath("//*[@id=\"8409616\"]/div[2]/div/a")).click();
		
		//This is a thread which is giving time to the clickable Element below some time to act upon
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")).click();
		
		//Here we see a window switch. So, a code to switch the window
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		String hotelName = driver.findElement(By.xpath("//*[@id=\"hotel-name\"]")).getText();
		System.out.println("HOTEL: "+hotelName);
		
		//4. Book reservation
		driver.findElement(By.cssSelector("button[type='submit'][data-automation='bookButton']")).click();
		
		//5. Fill out contact information and billing
		
		//We are not doing this as it is unnecessary information.Save it for another day
		
		//6. Get confirmation
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Payment"));
		
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.get("https://www.expedia.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
