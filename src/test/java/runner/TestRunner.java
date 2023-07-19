package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestRunner {
	
	public static WebDriver driver;
	
	@Test(priority = 1)
	public static void chromeLaunch() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://chromedriver.chromium.org/getting-started");
		
		try {
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		WebElement text = driver.findElement(By.id(""));
		text.sendKeys("java");
		
		
		driver.close();
	}
	
	@Test(priority = 2)
	public static void edgeLaunch() {
		
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
		
		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://chromedriver.chromium.org/getting-started");
		
		try {
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.close();
	}
	
	public static void main(String[] args) {
		
		chromeLaunch();
		edgeLaunch();
	}

}
