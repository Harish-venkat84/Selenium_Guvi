package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProvider {

	static WebDriver driver;
	
	
	@BeforeMethod
	public void launchDriver() {
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "test_Data")
	public void acceptData(String url, String text) {
		
		driver.get(url);
		
		driver.findElement(By.name("q")).sendKeys(text);
	}
	
	
	@DataProvider(name = "test_Data")
	public Object[][] giveData() {
		
		return new Object[][] {
			{"https://www.google.com/", "test1"},
			{"https://www.google.com/", "test2"},
			{"https://www.google.com/", "test3"}};
		
	}
	
	@AfterMethod
	public void driverQuit() {
		
		driver.quit();
	}
}
