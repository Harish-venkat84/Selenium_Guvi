package assignmentsSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonAssignment {

	static WebDriver driver;

	@BeforeMethod
	public void driverLaunch() {

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
	}

	@Test
	public void printers() {

		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("printers");

		driver.findElement(By.xpath("//input[@id = 'nav-search-submit-button']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[@aria-label = 'See more']/span[text() = 'See more']")));

		List<WebElement> brandsOf7 = driver.findElements(By.xpath("//div[@id ='brandsRefinements']/ul/span/li/span/a[@tabindex]"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		for (WebElement brand : brandsOf7) {
			
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[@aria-label = 'See more']/span[text() = 'See more']")));

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@aria-label = 'See more']/span[text() = 'See more']"))));
			
			brand.click();
			
		}
		
		WebElement seeMore = driver.findElement(By.xpath("//a[@aria-label = 'See more']/span[text() = 'See more']"));
		
		js.executeScript("arguments[0].scrollIntoView();", seeMore);
	}

	@Test(enabled = false)
	public void amazonThirdItem() {

		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("mobile phones");

		driver.findElement(By.xpath("//input[@id = 'nav-search-submit-button']")).click();

		WebElement samsung = driver.findElement(By.xpath("/"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", samsung);

		samsung.click();

		WebElement onePlus = driver.findElement(By.xpath("//span[text() =  'OnePlus']"));

		js.executeScript("arguments[0].scrollIntoView();", onePlus);

		onePlus.click();

		WebElement itemNo3 = driver.findElement(By.xpath("//div[@data-index =  '5']"));

		js.executeScript("arguments[0].scrollIntoView();", itemNo3);

		driver.findElement(By.xpath("//div[@data-index =  '4']/div/div/div/div/div/div[2]/div/div/div/h2/a")).click();
	}

}
