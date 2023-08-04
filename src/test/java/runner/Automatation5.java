package runner;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class Automatation5 extends BaseClass {

	public static void printingSpace(int length) {

		for (int j = 0; j < 20 - length; j++)
			System.out.print(' ');
	}
	
	public static void topDeals() {
		
		getURL("https://rahulshettyacademy.com/seleniumPractise/#/");
		
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

	}
	
	public static void productNames() {
		
		List<WebElement> names = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
		
		int i = 1;
		
		for (WebElement name : names) {
			
			System.out.println(i + ". " +name.getText());
			
			i++;
		}
	}

	public static void flightBooking() {
		
		getURL("https://rahulshettyacademy.com/dropdownsPractise/");
		
		implicitlyWait();

		driver.findElement(By.xpath("//label[text() = 'Round Trip']//parent::td//child::input")).click();
		
		driver.findElement(By.xpath("//div[@id = 'marketCityPair_1']//div[@class = 'left1']//child::input[@value = 'Departure City']")).sendKeys("che");
		
		driver.findElement(By.xpath("//ul//child::li//child::a[text() = ' Chennai (MAA)']")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class = 'dropdownDiv']//a[text() = ' Bengaluru (BLR)']"));
		
		for (int i = 0; i < elements.size(); i++) {
			
			if (i == elements.size()-1) {
				
				elements.get(i).click();
			}
		}
		
		List<WebElement> firstday = driver.findElements(By.xpath("//table//child::tbody//child::td//child::a[text() = '7']"));
		
		for (int i = 0; i < firstday.size(); i++) {
			
			if (i == 0) {
				
				firstday.get(i).click();
			}
		}
		
		List<WebElement> sec_day_Sel = driver.findElements(By.xpath("//div[@id = 'Div1']//child::input[@readonly = 'readonly']"));
		
		for (int i = 0; i < sec_day_Sel.size(); i++) {
			
			if (i == 0) {
				
				sec_day_Sel.get(i).click();
			}
		}
		
		List<WebElement> sectday = driver.findElements(By.xpath("//table//child::tbody//child::td//child::a[text() = '7']"));
		
		for (int i = 0; i < sectday.size(); i++) {
			
			if (i == sectday.size()-1) {
				
				sectday.get(i).click();
			}
		}
		
		List<WebElement> adult = driver.findElements(By.xpath("//div[text() = '1 Adult']"));
		
		adult.get(0).click();
		
		List<WebElement> adultAdding = driver.findElements(By.xpath("//div[@class = 'ad-row-right']//child::span[text() = '+']"));
		
		WebElement adults = null;
		WebElement child = null;
		WebElement infant = null;
		
		for (int i = 0; i < adultAdding.size(); i++) {
			
			if (i == 0) {
				
				adults = adultAdding.get(i);
				
			}else if (i == 1) {
				
				child = adultAdding.get(i);
				
			}else if(i == 2) {
				
				infant = adultAdding.get(i);
			
			}else if (i == 3) {
				
				break;
			}
			
		}
		
		adults.click();
		adults.click();
		
		child.click();
		child.click();
		
		infant.click();
		infant.click();
		
		List<WebElement> done = driver.findElements(By.xpath("//input[@value = 'Done']"));
		
		done.get(0).click();
		
		List<WebElement> search = driver.findElements(By.xpath("//span[@class = 'btn-find-flight-home']//child::input[@type = 'submit']"));
		
		search.get(0).click();
	}
	
	public static void main(String[] args) {

		chromeLaunch();

		flightBooking();

	}

}
