package runner;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class Get_Links extends BaseClass {

	public static ArrayList<String> links = new ArrayList<>();

	public static void links() throws AWTException {

		chromeLaunch();

		getURL("https://www.google.com/");

		driver.findElement(By.xpath("//textarea[@name = 'q']")).sendKeys("selenium ide");

		pressEnter();

		boolean con = true;

		while (con) {

			try {
				
				textToBePresent("//span[text() = 'Next']", "Next");

				WebElement next = driver.findElement(By.xpath("//span[text() = 'Next']"));
				
				textToBePresentInElement(next, "Next");
				
				presenceOfAllElementsLocatedBy("//h3//parent::a[@href]");

				List<WebElement> elements = driver.findElements(By.xpath("//h3//parent::a[@href]"));

				for (WebElement element : elements) {

					links.add(element.getAttribute("href"));
				}

				
				scrollIntoView(next);
				
				if (next.isDisplayed()) {

					driver.findElement(By.xpath("//span[text() = 'Next']//parent::a")).click();

				} else {

					con = false;
					break;
				}

			} catch (Exception e) {

				break;
			}

		}

		System.out.println(links);
	}

	public static void main(String[] args) {

		try {

			links();

		} catch (AWTException e) {

			e.printStackTrace();
		}

	}

}
