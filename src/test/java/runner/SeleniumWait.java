package runner;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class SeleniumWait extends BaseClass{
	
	public static void waitEx() {
		
		chromeLaunch();
		
		getURL("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		implicitlyWait();
		
		driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys("ber");
		
//		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		
		presenceOfAllElementsLocatedBy("//div[@class = 'product-action']//child::button", 10);
		
		textToBePresent("//button[text() = 'ADD TO CART']", "ADD TO CART", 10);
		
		List<WebElement> addCart = driver.findElements(By.xpath("//button[contains(text(), 'ADD TO CART')]"));
		
		for (WebElement cart : addCart) {
			
			textToBePresentInElement(cart, "ADD TO CART", 10);
			
			cart.click();
		}
		
		driver.findElement(By.xpath("//a[@class = 'cart-icon']")).click();
		driver.findElement(By.xpath("//button[text() = 'PROCEED TO CHECKOUT']")).click();
		
		WebElement apply = driver.findElement(By.xpath("//button[text() = 'Apply']"));
		apply.click();
		
		String text = driver.findElement(By.xpath("//span[text() = 'Empty code ..!']")).getText();
		
		WebElement promocode = driver.findElement(By.xpath("//input[@class = 'promoCode']"));
		
		if (text.equals("Empty code ..!")) {
			
			promocode.sendKeys("rahul");
		}
		
		apply.click();
		
		textToBePresent("//span[text() = 'Invalid code ..!']", "Invalid code ..!", 10);
		
		String invalid = driver.findElement(By.xpath("//span[text() = 'Invalid code ..!']")).getText();
		
		if (invalid.equals("Invalid code ..!")) {
			
			promocode.clear();
			
			promocode.sendKeys("rahulshettyacademy");
		}
		
		apply.click();
		
		textToBePresent("//span[text() = 'Code applied ..!']", "Code applied ..!", 10);
		
		String valid = driver.findElement(By.xpath("//span[text() = 'Code applied ..!']")).getText();
		
		if (valid.equals("Code applied ..!")) {
			
			System.out.println("Test pass");
		}
	}
	
	public static void main(String[] args) {
		
		waitEx();
	}

}
