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
		
		List<WebElement> quantity = driver.findElements(By.xpath("//table//child::tbody//child::td//child::p[@class = 'quantity']"));
		
		List<WebElement> price = driver.findElements(By.xpath("//table//child::tbody//child::td[4]//child::p[@class = 'amount']"));
		
		int amount = 0;
		
		for (int i = 0; i < quantity.size(); i++) {
			
			int qty =  Integer.parseInt(quantity.get(i).getText());
			int pri = Integer.parseInt(price.get(i).getText());
			
			amount = amount + (qty * pri);
		}
		
		int totalAmount = Integer.parseInt(driver.findElement(By.xpath("//span[@class = 'totAmt']")).getText());
		
		if (amount == totalAmount) {
			
			System.out.println("Total amount are equal "+amount);
		}
		
		
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
			
			System.out.println("Promo code applied");
			
		}
		
		String dis = driver.findElement(By.xpath("//span[@class = 'discountPerc']")).getText();
		
		double discount = Integer.parseInt(dis.substring(0, 2));
		
		double discountPrice = Double.valueOf(driver.findElement(By.xpath("//span[@class = 'discountAmt']")).getText());
		
		double discountTotalAmount = (amount * discount) / 100;
		
		discountTotalAmount = amount - discountTotalAmount;
		
		if (discountPrice == discountTotalAmount) {
			
			System.out.println("discount price are equal");
		}
	}
	
	public static void main(String[] args) {
		
		waitEx();
	}

}
