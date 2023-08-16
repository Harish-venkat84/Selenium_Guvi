package testNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTest1 {

	public static WebDriver driver;

	@BeforeMethod
	public void launch() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(invocationCount = 4, threadPoolSize = 2)
	public void launchGoogle() {

		driver.get("https://www.google.com/");

		String title = driver.getTitle();

		System.out.println(title);
	}

	@Test
	public void launchBrad() {

		driver.get("https://bard.google.com/?hl=en");

		String title = driver.getTitle();

		System.out.println(title);
	}
	
	@AfterMethod
	public void driverQuit() {
		
		driver.quit();
	}

}
