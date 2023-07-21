package runner;

import org.openqa.selenium.By;

import base.BaseClass;

public class TestRunner extends BaseClass {
	
	
	public static void selectorshub() {
		
		chromeLaunch();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		driver.findElement(By.xpath("//input[@id = 'userId']")).sendKeys("gmail@gmail.com");
		driver.findElement(By.xpath("//input[@id = 'pass']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@name = 'company']")).sendKeys("selectorhub");
		driver.findElement(By.xpath("//input[@name = 'mobile number']")).sendKeys("7823219932");
		driver.findElement(By.xpath("//input[@value= 'Submit']")).click();
		
	}
	
	public static void main(String[] args) {
	
		selectorshub();
	
	}
	
}
