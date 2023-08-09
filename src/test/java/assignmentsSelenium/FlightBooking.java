package assignmentsSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightBooking {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.xpath("//label[text() = 'Round Trip']//parent::td//child::input")).click();

		driver.findElement(By.xpath(
				"//div[@id = 'marketCityPair_1']//div[@class = 'left1']//child::input[@value = 'Departure City']"))
				.sendKeys("che");

		driver.findElement(By.xpath("//ul//child::li//child::a[text() = ' Chennai (MAA)']")).click();

		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class = 'dropdownDiv']//a[text() = ' Bengaluru (BLR)']"));

		elements.get(1).click();

		List<WebElement> firstday = driver
				.findElements(By.xpath("//table//child::tbody//child::td//child::a[text() = '10']"));

		firstday.get(0).click();

		List<WebElement> sec_day_Sel = driver
				.findElements(By.xpath("//div[@id = 'Div1']//child::input[@readonly = 'readonly']"));

		sec_day_Sel.get(0).click();

		List<WebElement> sectday = driver
				.findElements(By.xpath("//table//child::tbody//child::td//child::a[text() = '10']"));

		sectday.get(1).click();

		List<WebElement> adultDropDown = driver.findElements(By.xpath("//div[text() = '1 Adult']"));

		adultDropDown.get(0).click();

		List<WebElement> adultAdding = driver
				.findElements(By.xpath("//div[@class = 'ad-row-right']//child::span[text() = '+']"));

		WebElement adults = null;
		WebElement child = null;
		WebElement infant = null;

		for (int i = 0; i < adultAdding.size(); i++) {

			if (i == 0) {

				adults = adultAdding.get(i);

			} else if (i == 1) {

				child = adultAdding.get(i);

			} else if (i == 2) {

				infant = adultAdding.get(i);

			} else if (i == 3) {

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

		List<WebElement> search = driver
				.findElements(By.xpath("//span[@class = 'btn-find-flight-home']//child::input[@type = 'submit']"));

		search.get(0).click();
	}

}
