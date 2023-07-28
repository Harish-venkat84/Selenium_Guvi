package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class IFrameEx extends BaseClass{
/*
 *	there are three ways to switch to frame 
 * driver.switchTo().frame(By.id);
 * driver.switchTo().frame(WebElement);
 * driver.switchTo().frame(0);	
*/
	
	public static void iFrameEx() {
		
		chromeLaunch();
		
		getURL("https://the-internet.herokuapp.com/iframe");
		
		implicitlyWait();
		
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@title = 'Rich Text Area']"));
		
		driver.switchTo().frame(iFrame);
		
		WebElement frameText = driver.findElement(By.xpath("//p//parent::body"));
		
		frameText.clear();
		
		frameText.sendKeys("selenuim Guvi");
		
		String text = driver.findElement(By.xpath("//p")).getText();
		
		System.out.println(text);
		
		driver.switchTo().defaultContent();
		
		driver.quit();
		
	}
	
	public static void nestedFrame() {
		
		chromeLaunch();
		
		getURL("https://demoqa.com/nestedframes");
		
		implicitlyWait();
		
		driver.switchTo().frame("frame1");
		
		String text = driver.findElement(By.xpath("//iframe[@srcdoc = '<p>Child Iframe</p>']//parent::body")).getText();
		
		System.out.println(text);
		
		WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc = '<p>Child Iframe</p>']"));
		
		driver.switchTo().frame(childFrame);
		
		String text2 = driver.findElement(By.xpath("//p[text() = 'Child Iframe']")).getText();
		
		System.out.println(text2);
		
		driver.switchTo().parentFrame();
		
		String parentText = driver.findElement(By.xpath("//iframe[@srcdoc = '<p>Child Iframe</p>']//parent::body")).getText();
		
		System.out.println(parentText);
		
		driver.switchTo().defaultContent();
		
		String defaultText = driver.findElement(By.xpath("//div[text() = 'Nested Frames']")).getText();
		
		System.out.println(defaultText);
		
		driver.quit();
	}
	
	public static void main(String[] args) {
		
//		iFrameEx();
		
		nestedFrame();
		
		
	}

}
