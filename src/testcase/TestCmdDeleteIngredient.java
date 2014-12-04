package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdDeleteIngredient;
import restaurant.Ingredient;
import restaurant.Restaurant;

public class TestCmdDeleteIngredient {

	@Before
	public void setUp() throws Exception {
		//Ingredient must exist before deleting ingredient.
		
		Ingredient i = new Ingredient("I001", "Sugar", "10", "20");
		Restaurant.getInstance().addIngredient(i);
	}
	
	@After
	public void tearDown() {}

	/*CmdDeleteIngredient format: "deleteIng", Ingredient_ID
	 *Ingredient_ID is selected by user.
	 */

	@Test
	public void testDeleteIngreCorrect() throws Exception 
	{
		String[] deleteIngre = {"deleteIng", "I001"};
		CmdDeleteIngredient cmd = new CmdDeleteIngredient();
		assertEquals("Ingredient is deleted.", cmd.execute(deleteIngre));
	}
	
	@Test
	public void testDeleteIngreInvalidId() throws Exception 
	{
		String[] deleteIngre = {"deleteIng", "I020"};
		CmdDeleteIngredient cmd = new CmdDeleteIngredient();
		assertEquals("Invalid ingredient ID!", cmd.execute(deleteIngre));
	}
	
	
}
