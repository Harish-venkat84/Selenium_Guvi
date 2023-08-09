package assignmentsSelenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class Automatation5 extends BaseClass {
	
	
	@Test(priority = 2)
	public static void topDeals() {
		
		String parentWindow = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[text() = 'Top Deals']")).click();

		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String eachWin : allWindowHandles) {

			if (!eachWin.equals(parentWindow)) {

				driver.switchTo().window(eachWin);

				break;
			}
		}

		driver.findElement(By.xpath("//span[text() = 'Veg/fruit name']")).click();

		List<WebElement> tHead = driver.findElements(By.xpath("//table//child::thead//tr//th"));

		for (WebElement headName : tHead) {

			System.out.print(headName.getText());

			printingSpace(headName.getText().length());
		}

		List<WebElement> noOfPage = driver.findElements(By.xpath("//li[@class = 'active']//following::a"));

		int printNextLine = 0;

		for (int i = 0; i <= 3; i++) {

			List<WebElement> tBody = driver.findElements(By.xpath("//table//child::tbody//tr//child::td"));

			for (WebElement eachItems : tBody) {

				if (printNextLine % 3 == 0) {

					System.out.println();
				}

				printNextLine++;

				System.out.print(eachItems.getText());

				printingSpace(eachItems.getText().length());

			}

			if (i != 3) {

				noOfPage.get(i).click();
			}

		}
		
		System.out.println();
		
		driverQuit();
		
	}
	
	@Test(priority = 1)
	public static void productNames() {
		
		chromeLaunch();
		
		getURL("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		List<WebElement> names = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
		
		int i = 1;
		
		for (WebElement name : names) {
			
			System.out.println(i + ". " +name.getText());
			
			i++;
		}
		
	}
	
	public static void printingSpace(int length) {

		for (int j = 0; j < 20 - length; j++)
			System.out.print(' ');
	}
	

}
