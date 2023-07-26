package runner;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class SelectEx extends BaseClass{

	public static void demoqa() {
		
		chromeLaunch();
		
		getURL("https://demoqa.com/select-menu");
		
		WebElement menu = driver.findElement(By.xpath("//select[@id = 'oldSelectMenu']"));
		
		scrollIntoView(menu);
		
		selectByVisibleText(menu, "Green");
		
		selectByValue(menu, "5");
		
		selectByIndex(menu, 10);
		
		List<WebElement> options = getOptions(menu);
		
		for (WebElement option : options) {
			
			System.out.println(option.getText());
		}
	}
	
	
	public static void standardMultiDropdown() throws AWTException {
		
		WebElement cars = driver.findElement(By.xpath("//select[@id = 'cars']"));
		
		scrollIntoView(cars);
		
		selectByVisibleText(cars, "Saab");
		
		pressCtrl();
		
		selectByValue(cars, "audi");
		
		releaseCtrl();
		
		List<WebElement> getallSelectedOptions = getallSelectedOptions(cars);
		
		for (WebElement webElement : getallSelectedOptions) {
			
			System.out.println("++ "+webElement.getText()+ " ++");
		}
	}
	
	public static void multiDropdown() {
		

		
		WebElement multiColour = driver.findElement(By.xpath("//div[text()= 'Select...']"));
		
		scrollIntoView(multiColour);
		
		multiColour.click();
		
		driver.findElement(By.xpath("//div[@id = 'react-select-4-option-0']")).click();
		driver.findElement(By.xpath("//div[@id = 'react-select-4-option-3']")).click();
		
		
	}
	
	public static void main(String[] args) {
		
		demoqa();
		
		multiDropdown();
		
		try {
			standardMultiDropdown();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
}
