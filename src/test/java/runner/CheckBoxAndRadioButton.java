package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class CheckBoxAndRadioButton extends BaseClass{
	
	public static void demo_guru() throws InterruptedException {
		
		chromeLaunch();
		
		getURL("https://demo.guru99.com/test/radio.html");
		
		driver.findElement(By.xpath("//input[@value = 'Option 1']")).click();
		WebElement radio3 = driver.findElement(By.xpath("//input[@value = 'Option 3']"));

		if (!radio3.isSelected()) {
			
			radio3.click();
		}
		
		driver.findElement(By.xpath("//input[@value = 'checkbox1']")).click();
		WebElement checkBox3 = driver.findElement(By.xpath("//input[@value = 'checkbox3']"));
		checkBox3.click();
		
		if (checkBox3.isSelected()) {
			
			System.out.println("Selected");
		}
		
		Thread.sleep(1000);
		
		driver.quit();
		
	}

	
	public static void main(String[] args) {
		
		try {
			
			demo_guru();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
