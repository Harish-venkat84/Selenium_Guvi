package testNG;

import java.util.ArrayList;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameter {
	
	@Parameters({ "first-name", "last-name" })
    @Test
    public void testparameter(String firstName, String lastName) {
		
      System.out.println(firstName + " " + lastName);
	}
	
	
	public static void main(String[] args) {
		
		
		ArrayList<Object> list = new ArrayList<>();
		
		Object[] array = list.toArray();
		
	}

}
