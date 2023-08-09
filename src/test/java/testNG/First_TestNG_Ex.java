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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class First_TestNG_Ex {

	@BeforeSuite
	public void name1() {

		System.out.println("before suite");
	}

	@BeforeTest
	public void name3() {

		System.out.println("before test");
	}

	@BeforeClass
	public void name2() {

		System.out.println("before class");
	}

	@BeforeGroups("names")
	public void beforeGroups() {
		System.out.println("beforeGroups method executed before testOne group");
	}

	@BeforeMethod
	public void name4() {

		System.out.println("before method");
	}

	@Test(priority = 1)
	public void name5() {

		System.out.println("test 1");
		
	}

	@Test(priority = 2, groups = { "names" })
	public void name6() {

		System.out.println("test 2");
	}

	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "data one" }, { "data two" }, { "data three" } };
	}

	@Test(dataProvider = "data-provider")
	public void testMethod(String data) {
		System.out.println("Data is: " + data);
	}

	@AfterMethod
	public void name7() {

		System.out.println("After method");
	}

	@AfterGroups("names")
	public void afterGroups() {
		System.out.println("AfterGroups method executed after testOne group");
	}

	@AfterClass
	public void name9() {

		System.out.println("After class");
	}

	@AfterTest
	public void name8() {

		System.out.println("After test");
	}

	@AfterSuite
	public void name10() {

		System.out.println("After suite");
	}

}
