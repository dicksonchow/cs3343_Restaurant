package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddIngredient;
import restaurant.CmdDeleteIngredient;

public class TestCmdDeleteIngredient {

	@Before
	public void setUp() throws Exception {
		//Ingredient must exist before deleting ingredient.
		
		String[] addIngre = {"addIng", "I001", "Sugar", "10", "20"};
		CmdAddIngredient cmd = new CmdAddIngredient();
		cmd.execute(addIngre);
	}
	
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
