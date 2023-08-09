package testNG;

import org.testng.annotations.Test;

public class TestNG_Group2 {
	
	
	@Test(priority = 1, groups = {"smoke"})
	public void testCase1() {
	
		System.out.println("Test Case 1");
		
	}
	
	@Test(priority = 2, groups = {"smoke", "sanity"})
	public void testCase2() {
		
		System.out.println("Test Case 2");
		
	}
	
	@Test(priority = 3, groups = {"regression"})
	public void testCase3() {
		
		System.out.println("Test Case 3");
		
	}
	
	@Test(priority = 4, groups = {"sanity"})
	public void testCase4() {
		
		System.out.println("Test Case 4");
		
	}
	
	@Test(priority = 5, groups = {"smoke", "regression"})
	public void testCase5() {
		
		System.out.println("Test Case 5");
		
	}
	
	@Test(priority = 6, groups = {"sanity", "regression"})
	public void testCase6() {
		
		System.out.println("Test Case 6");
		
	}
	
	@Test(priority = 7, groups = {"smoke", "regression", "sanity"})
	public void testCase7() {
		
		System.out.println("Test Case 7");
		
	}
	
}
