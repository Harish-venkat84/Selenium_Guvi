package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Group1 {
	
	
	@BeforeSuite
	public void beforeSuite() {
		
		System.out.println("Before suite");
	}
	
	@BeforeTest
	public void beforeTest() {

		System.out.println("Before test");
	}

	@BeforeClass
	public void beforeClass() {

		System.out.println("Before class");
	}
	
	@BeforeGroups("smoke")
	public void beforeGroups() {
		System.out.println("Before Groups");
	}
	
	@BeforeMethod
	public void beforeMethod() {

		System.out.println("Before method");
	}
	
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
	
	@AfterMethod
	public void afterMethod() {

		System.out.println("After method");
	}
	
	@AfterGroups("smoke")
	public void afterGroups() {
		System.out.println("After Groups");
	}
	
	@AfterClass
	public void afterClass() {

		System.out.println("After class");
	}
	
	@AfterTest
	public void afterTest() {

		System.out.println("After test");
	}
	
	@AfterSuite
	public void afterSuite() {
		
		System.out.println("After suite");
	}
	
}
