package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

public static WebDriver driver;

public static Robot robo;

public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

public static JavascriptExecutor js = (JavascriptExecutor) driver;

	public static void chromeLaunch() {
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
	}
	
	public static void edgeLaunch() {
		
		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
	}
	
	public static void getURL(String str) {
		
		driver.get(str);
	}
	
	public static void textToBePresent(String xpath, String text) {
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
	}
	
	public static void textToBePresentInElement(WebElement element, String str) {
		
		wait.until(ExpectedConditions.textToBePresentInElement(element, str));
	}
	
	public static void presenceOfAllElementsLocatedBy(String xpath) {
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	
	public static void scrollIntoView(WebElement element) {
		
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void pressEnter() throws AWTException {
		
		robo = new Robot();
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public static void main(String[] args) {
		
		chromeLaunch();
		edgeLaunch();
	}
}
