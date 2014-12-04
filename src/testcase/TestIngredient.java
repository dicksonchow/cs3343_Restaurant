package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.Ingredient;

public class TestIngredient {
	
	private Ingredient i1;

	@Before
	public void setUp(){
		i1 = new Ingredient("I001", "Fish", "10", "20");
	}
	
	@After
	public void teardown(){}
	
	@Test
	public void testIngreGetIngredientPrice(){
		int price = i1.getIngredientPrice();
		assertEquals(20, price);
	}	
	
	@Test
	public void testIngreGetIngredientId(){
		String id = i1.getIngredientID();
		assertEquals("I001", id);
	}
		
	@Test
	public void testIngreCompareToGreater(){
		Ingredient i2 = new Ingredient("I002", "Cheese", "100", "30");
		int result = i1.compareTo(i2);
		assertEquals(-1,result);
	}
	
	@Test
	public void testIngreCompareToEqual(){
		Ingredient i2 = new Ingredient("I002", "Cheese", "100", "30");
		int result = i2.compareTo(i2);
		assertEquals(0, result);
	}
	
	@Test
	public void testIngreCompareToSmaller(){
		Ingredient i2 = new Ingredient("I002", "Cheese", "100", "30");
		int result = i2.compareTo(i1);
		assertEquals(1, result);
	}
	
	@Test
	public void testIngreToString(){
		String toString = i1.toString();
		String exp = "I001           Fish              10           $20          ";
		assertEquals(exp, toString);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testListingHeading(){
		String toString = i1.getListingHeader();
		String exp = "Ingredient_ID  Ingredient_Name   Quantity     Price        ";
		assertEquals(exp, toString);
	}

}
