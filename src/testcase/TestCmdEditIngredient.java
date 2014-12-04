package testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddIngredient;
import restaurant.CmdEditIngredient;

public class TestCmdEditIngredient {

	@Before
	public void setUp() throws Exception {
		//Ingredient must exist before editing ingredient.
		
		String[] addIngre = {"addIng", "I001", "Sugar", "10", "20"};
		CmdAddIngredient cmd = new CmdAddIngredient();
		cmd.execute(addIngre);
	}
	
	public void tearDown() {}

	/*CmdEditIngredient format: "editIng", Ingredient_ID, Ingredient_Name, Ingredient_Amount, Ingredient_Price
	 *Ingredient_ID is selected by user. Ingredient_Name, Ingredient_Amount and Ingredient_Price are inputed by user.
	 */
	
	@Test
	public void testEditIngreCorrect() throws Exception 
	{
		String[] editIngre = {"editIng", "I001", "Bean", "10", "30"};
		CmdEditIngredient cmd = new CmdEditIngredient();
		assertEquals("Ingredient is edited.", cmd.execute(editIngre));
	}
	
	@Test
	public void testEditIngreNumEx() throws Exception 
	{
		String[] editIngre = {"editIng", "I001", "Bean", "abc", "efg"};
		CmdEditIngredient cmd = new CmdEditIngredient();
		assertEquals("Invalid input!", cmd.execute(editIngre));
	}	
	
	@Test
	public void testEditIngreInvalidId() throws Exception 
	{
		String[] editIngre = {"editIng", "I020", "Fish", "10", "20"};
		CmdEditIngredient cmd = new CmdEditIngredient();
		assertEquals("Invalid ingredient ID!", cmd.execute(editIngre));
	}

	@Test
	public void testEditIngreInvalidName() throws Exception 
	{
		String[] editIngre = {"editIng", "I001", " ", "10", "20"};
		CmdEditIngredient cmd = new CmdEditIngredient();
		assertEquals("Invalid input!", cmd.execute(editIngre));
	}
	

}
