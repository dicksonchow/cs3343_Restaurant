package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.Food;

public class TestFood {

	private Food f1;

	@Before
	public void setUp(){
		f1 = new Food("F001", "CheeseBurger", "20");
	}
	
	@After
	public void teardown(){}
	
	@Test
	public void testFoodGetFoodPrice(){
		int price = f1.getFoodPrice();
		assertEquals(20, price);
	}	
	
	@Test
	public void testFoodGetFoodName(){
		String name = f1.getFoodName();
		assertEquals("CheeseBurger", name);
	}
	
	@Test
	public void testFoodGetFoodId(){
		String id = f1.getFoodID();
		assertEquals("F001", id);
	}
		
	@Test
	public void testFoodCompareToSmaller(){
		Food f2 = new Food("F002", "Hamburger", "30");
		int result = f1.compareTo(f2);
		assertEquals(-1,result);
	}
	
	@Test
	public void testFoodCompareToEqual(){
		Food f2 = new Food("F002", "Hamburger", "30");
		int result = f2.compareTo(f2);
		assertEquals(0, result);
	}
	
	@Test
	public void testFoodCompareToGreater(){
		Food f2 = new Food("F002", "Hamburger", "30");
		int result = f2.compareTo(f1);
		assertEquals(1, result);
	}
	
	@Test
	public void testFoodToString(){
		String toString = f1.toString();
		String exp = "F001         CheeseBurger   $20            ";
		assertEquals(exp, toString);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testFoodListingHeading(){
		String toString = f1.getListingHeader();
		String exp = "Food_ID      Food_Name      Price          ";
		assertEquals(exp, toString);
	}

}
