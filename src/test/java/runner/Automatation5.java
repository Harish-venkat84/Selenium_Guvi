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

	public static void main(String[] args) {

		chromeLaunch();

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

		int a = 0;

		for (int i = 0; i <= 3; i++) {

			List<WebElement> tBody = driver.findElements(By.xpath("//table//child::tbody//tr//child::td"));

			for (WebElement eachItems : tBody) {

				if (a % 3 == 0) {

					System.out.println();
				}

				a++;

				System.out.print(eachItems.getText());

				printingSpace(eachItems.getText().length());

			}

			if (i != 3) {

				noOfPage.get(i).click();
			}

		}

	}

}
