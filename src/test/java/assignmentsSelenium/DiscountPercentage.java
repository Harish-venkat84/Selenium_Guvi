package assignmentsSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DiscountPercentage {
	
public static WebDriver driver;

public static LinkedHashMap<String, List<Double>> topdeals = new LinkedHashMap<>();
	
	@Test(priority = 2)
	public static void disEqual20() {
		
		ArrayList<String> discountProduct = new ArrayList<>();
		
		for (Map.Entry<String, List<Double>> entry : topdeals.entrySet()) {
			
			String key = entry.getKey();
			
			List<Double> val = entry.getValue();
			
			double price = val.get(0), discount = val.get(1), percentage = (discount / price) * 100;
			
			if (percentage >= 20 && percentage <= 50) {
				
				discountProduct.add(key);
			}
			
		}
		
		System.out.println("Discount Product ==> "+discountProduct);
	}
	
	@Test(priority = 1)
	public static void productNames() {
		
		driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[text() = 'Veg/fruit name']")).click();
		
		while(true) {
		
			List<WebElement> tBody = driver.findElements(By.xpath("//table//child::tbody//tr//child::td"));
			
			String name = "";

			List<Double> priceDis = new ArrayList<>();
			
			int count = 0;
			
			for (int j = 0; j < tBody.size(); j++) {
				
				count++;
				
				if (Character.isLetter(tBody.get(j).getText().charAt(0))) {
					
					name = tBody.get(j).getText();
					
				}else if (Character.isDigit(tBody.get(j).getText().charAt(0))) {
					
					priceDis.add(Double.valueOf(tBody.get(j).getText()));
				}
				
				if (count == 3) {
				
					topdeals.put(name, new ArrayList<Double>(priceDis));
					
					count = 0;
					
					priceDis.clear();
					
				}
				
			}

			WebElement next = driver.findElement(By.xpath("//span[@class = 'fa fa-angle-right']//parent::a"));
			
			String attribute = next.getAttribute("aria-disabled");
			
			if (attribute.equals("false")) {
				
				next.click();
				
			}else {
				
				break;
			}
			
		}
		
		driver.quit();
	}
}
