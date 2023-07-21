package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

public static WebDriver driver;
	
	public static void chromeLaunch() {
		
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
	}
	
	public static void edgeLaunch() {
		
//		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
		
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
