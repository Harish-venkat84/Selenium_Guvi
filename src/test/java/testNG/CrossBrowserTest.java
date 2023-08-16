package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

	static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browserName"})
	public void driver_Launch(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		
		}else if (browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		}else if(browserName.equalsIgnoreCase("FireFox")) {
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void testCases() {
		
		driver.get("https://www.google.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("q"))));
		
		driver.findElement(By.name("q")).sendKeys("Selenium TestNG");
	}
	
	@AfterMethod
	public void driverQuit() {
		
		driver.quit();
	}
	
}
