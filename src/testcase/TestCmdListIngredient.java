package testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddIngredient;
import restaurant.CmdListIngredient;

public class TestCmdListIngredient {

	@Before
	public void setUp() throws Exception {
		//Ingredient must exist before listing ingredient.
		
		String[] addIngre1 = {"addIng", "I001", "Sugar", "10", "20"};
		CmdAddIngredient cmd1 = new CmdAddIngredient();
		cmd1.execute(addIngre1);
		
		String[] addIngre2 = {"addIng", "I002", "Fish", "10", "30"};
		CmdAddIngredient cmd2 = new CmdAddIngredient();
		cmd2.execute(addIngre2);
	}
	
	public void tearDown() {}

	//CmdListIngredient format: "listIng"
	
	@Test
	public void testListIngre() throws Exception 
	{
		String listingHeader = "Ingredient_ID  Ingredient_Name   Quantity     Price        " + "\n";
		String toString1 = "I001           Sugar             10           $20          " + "\n";
		String toString2 = "I002           Fish              10           $30          " + "\n";
		String listIngre = listingHeader + toString1 + toString2;
		CmdListIngredient cmd = new CmdListIngredient();
		assertEquals(listIngre, cmd.execute());
	}

}
