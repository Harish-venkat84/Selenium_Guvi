package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class NavigateCommands extends BaseClass {
	
	public static void main(String[] args) {
		
		try {
			
			demoqa();
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void demoqa() throws InterruptedException {
		
		chromeLaunch();
		
		getURL("https://demoqa.com/");
		
		Thread.sleep(2000);
		
		WebElement elements = driver.findElement(By.xpath("//div[@class = 'category-cards']/div[1]/div"));
		
		scrollIntoView(elements);
		
		Thread.sleep(1000);
		
		elements.click();
		
		Thread.sleep(1000);
		
		navigateBack();
		
		Thread.sleep(1000);
		
		navigateForward();
		
		Thread.sleep(1000);
		
		refresh();
		
		Thread.sleep(1000);
		
		navigateTo("https://www.google.com/");
		
		Thread.sleep(1000);
		
		driver.quit();
	}

}
