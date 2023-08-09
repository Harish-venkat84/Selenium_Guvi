package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AtTestProperties {

	
	@Test(priority = 1, enabled = true)
	public void testCase1() {
		
		System.out.println("Test Case 1");
		
		Assert.assertEquals("String", "String");
		
	}
	
	
	@Test(priority = 2, enabled = true)
	public void testCase2() {
		
		System.out.println("Test Case 2");
		
		Assert.assertNotEquals("a", "b");
	}
	
	@Test(priority = 3,  alwaysRun = true)
	public void testCase3() {
		
		System.out.println("Test Case 3");
		
		int value = 30;
		
		assert value <= 20: "not under weight";
		
		System.out.println("value is " + value);
	}
	
	@Test(priority = 4, dependsOnMethods = {"testCase1"})
	public void testCase4() {
		
		System.out.println("Test Case 4");
	}
	
}
