package runner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;

public class AlertEx extends BaseClass {

	public static void alertEx() {
		
		chromeLaunch();
		
		getURL("https://demoqa.com/alerts");
		
		implicitlyWait();

		WebElement click1 = driver.findElement(By
				.xpath("//span[text() = 'Click Button to see alert ']//parent::div//parent::div//child::button[text() = 'Click me']"));
		
		click1.click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		driver.switchTo().defaultContent();
		
		String alert2_Xpath = "//span[text() = 'On button click, alert will appear after 5 seconds ']//parent::div//parent::div//child::button[text() = 'Click me']";
		
		driver.findElement(By.xpath(alert2_Xpath)).click();
		
		webDriverWait(10).until(ExpectedConditions.alertIsPresent());
		
		Alert alert2 = driver.switchTo().alert();
		
		alert2.accept();
		
		driver.switchTo().defaultContent();
		
		String alert4_xpath = "//span[text() = 'On button click, prompt box will appear']//parent::div//parent::div//child::button[text() = 'Click me']";
	
		WebElement alert4_Element = driver.findElement(By.xpath(alert4_xpath));
		
		scrollIntoView(alert4_Element);
		
		alert4_Element.click();
		
		webDriverWait(10).until(ExpectedConditions.alertIsPresent());
		
		Alert alert4 = driver.switchTo().alert();
		
		alert4.sendKeys("Selenium Guvi");
		
		System.out.println(alert4.getText());
		
		alert4.accept();
		
	}
	
	public static void main(String[] args) {
			
		alertEx();
			
	}
	
}
