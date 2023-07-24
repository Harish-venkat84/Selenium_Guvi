package runner;

import java.awt.AWTException;

import org.openqa.selenium.By;

import base.BaseClass;

public class Get_Title extends BaseClass{

	public static void getTitle() throws AWTException, InterruptedException {
		
		chromeLaunch();
		
		getURL("https://www.google.com/");
		
		driver.findElement(By.xpath("//textarea[@name = 'q']")).sendKeys("Selenium Webdriver");
		
		pressEnter();
		
		driver.findElement(By.xpath("//h3[text() = 'WebDriver']//parent::a")).click();
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.close();
		
	}
	
	
	public static void main(String[] args) {

		try {
			getTitle();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
