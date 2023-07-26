package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

public static WebDriver driver;

public static Robot robo;

public static WebDriverWait wait;

public static JavascriptExecutor js;

public static Select select;

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
	
	public static WebDriverWait webDriverWait() {
			
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		return wait;
	}
	
	
	public static void textToBePresent(String xpath, String text) {
		
		webDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
	}
	
	public static void textToBePresentInElement(WebElement element, String str) {
		
		webDriverWait().until(ExpectedConditions.textToBePresentInElement(element, str));
	}
	
	public static void presenceOfAllElementsLocatedBy(String xpath) {
		
		webDriverWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	
	public static void scrollIntoView(WebElement element) {
		
		js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static Robot roboObj() throws AWTException {
		
		if (robo == null) {
			
			robo = new Robot();
		}
		
		return robo;
	}
	
	public static void pressEnter() throws AWTException {
		
		roboObj().keyPress(KeyEvent.VK_ENTER);
		roboObj().keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public static void pressCtrl() throws AWTException {
		
		roboObj().keyPress(KeyEvent.VK_CONTROL);
	}
	
	public static void releaseCtrl() throws AWTException {
		
		roboObj().keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static Select selectObj(WebElement element) {
		
		select = new Select(element);
		
		return select;
	}
	
	public static void selectByVisibleText(WebElement element, String text) {
		
		selectObj(element).selectByVisibleText(text);
	}
	
	public static void selectByValue(WebElement element, String value) {
		
		selectObj(element).selectByValue(value);
	}
	
	public static void selectByIndex(WebElement element, int index) {
		
		selectObj(element).selectByIndex(index);
	}
	
	public static List<WebElement> getOptions(WebElement element) {
		
		List<WebElement> options = selectObj(element).getOptions();
		
		return options;
	}
	
	public static List<WebElement> getallSelectedOptions(WebElement element) {
		
		List<WebElement> allSelectedOptions = selectObj(element).getAllSelectedOptions();
		
		return allSelectedOptions;
	}
	
	public static void deSelectAll(WebElement element) {
		
		selectObj(element).deselectAll();
	}
	
	public static void navigateTo(String str) {
		
		driver.navigate().to(str);
	}
	
	public static void navigateBack() {
		
		driver.navigate().back();
	}
	
	public static void navigateForward() {
		
		driver.navigate().forward();
	}
	
	public static void refresh() {
		
		driver.navigate().refresh();
	}
	
	public static void main(String[] args) {
		
		chromeLaunch();
		edgeLaunch();
	}
}
