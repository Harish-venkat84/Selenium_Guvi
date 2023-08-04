package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ActionEx extends BaseClass{

	public static void main(String[] args) {
		
		chromeLaunch();
		
		getURL("https://demoqa.com/droppable/");
		
		WebElement drag = driver.findElement(By.id("draggable"));
		
		WebElement drop = driver.findElement(By.id("droppable"));
		
		action_Drag_Drop(drag, drop);
		
		String text = driver.findElement(By.xpath("//p[text() = 'Dropped!']")).getText();
		
		System.out.println(text);
		
		
	}
}
