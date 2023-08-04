package runner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class JavaScriptExecutorEx extends BaseClass{

	public static void main(String[] args) {
		
		chromeLaunch();
		
		getURL("https://www.guvi.in/");
		
		implicitlyWait();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		 js.executeScript("window.scrollBy(0,700)");
		 
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		 String sText =  js.executeScript("return document.title;").toString();
		 
		 
		 
		 System.out.println(sText);
		 
		 Actions act = new Actions(driver);
		 
		 act.scrollByAmount(0, 500).build().perform();
	}
	
}
