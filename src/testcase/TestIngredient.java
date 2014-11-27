package testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import restaurant.Ingredient;

public class TestIngredient {
	
	private Ingredient i1;

	@Before
	public void setUp(){
		Ingredient i1 = new Ingredient("001", "fish", "10", "20");
		this.i1 = i1;
	}
	
	@Test
	public void testGetId(){
		String id = i1.getIngredientID();
		assertEquals("001", id);
	}
	
	@Test
	public void testGetPrice(){
		int price = i1.getIngredientPrice();
		assertEquals(20, price);
	}
	
	@Test
	public void testToString(){
		String toString = i1.toString();
		String toBeTest = String.format("%-15s%-18s%-13s%-13s", "001", "fish", "10", "$" + "20");
		assertEquals(toBeTest, toString);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testListingHeading(){
		String toString = i1.getListingHeader();
		String toBeTest = String.format("%-15s%-18s%-13s%-13s", "Ingredient_ID", "Ingredient_Name", "Quantity", "Price");
		assertEquals(toBeTest, toString);
	}
	
	@Test
	public void testCompareToGreater(){
		Ingredient i2 = new Ingredient("002", "cheese", "100", "30");
		int result = i1.compareTo(i2);
		assertEquals(result, -1);
	}
	
	@Test
	public void testCompareToEqual(){
		Ingredient i2 = new Ingredient("002", "cheese", "100", "30");
		int result = i2.compareTo(i2);
		assertEquals(result, 0);
	}
	
	@Test
	public void testCompareToLess(){
		Ingredient i2 = new Ingredient("002", "cheese", "100", "30");
		int result = i2.compareTo(i1);
		assertEquals(result, 1);
	}
}
