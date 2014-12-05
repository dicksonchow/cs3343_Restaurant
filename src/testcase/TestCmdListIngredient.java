package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdListIngredient;
import restaurant.Ingredient;
import restaurant.Restaurant;

public class TestCmdListIngredient {
	
	Ingredient i1 = new Ingredient("I001", "Sugar", "10", "20");
	Ingredient i2 = new Ingredient("I002", "Fish", "10", "30");

	@Before
	public void setUp() throws Exception {
		//Ingredient must exist before listing ingredient.
		Restaurant.getInstance().addIngredient(i1);
		Restaurant.getInstance().addIngredient(i2);
	}
	
	@After
	public void tearDown() {
		Restaurant.getInstance().removeIngredient(i1);
		Restaurant.getInstance().removeIngredient(i2);
	}

	//CmdListIngredient format: "listIng"    
	
	@Test
	public void testListIngre() throws Exception 
	{
		String listingHeader = "Ingredient_ID  Ingredient_Name   Quantity     Price        " + "\n";
		String toString1 = "I001           Sugar             10           $20          " + "\n";
		String toString2 = "I002           Fish              10           $30          " + "\n";
		String listIngre = listingHeader + toString1 + toString2;
		System.out.println(listIngre);
		CmdListIngredient cmd = new CmdListIngredient();
		System.out.println(cmd.execute());
		assertEquals(listIngre, cmd.execute());
	}

}
