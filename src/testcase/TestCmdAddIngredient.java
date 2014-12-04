package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdAddIngredient;

public class TestCmdAddIngredient {

	@Before
	public void setUp() throws Exception {}
	
	@After
	public void tearDown() {}
	
	/*CmdAddIngredient format: "addIng", Ingredient_ID, Ingredient_Name, Ingredient_Amount, Ingredient_Price
	 *Ingredient_ID is selected by user. Ingredient_Name, Ingredient_Amount and Ingredient_Price are inputed by user.
	 */
	
	@Test
	public void testAddIngCorrect() throws Exception 
	{
		String[] addIngre = {"addIng", "I001", "Sugar", "10", "20"};
		CmdAddIngredient cmd = new CmdAddIngredient();
		assertEquals("Ingredient is added.", cmd.execute(addIngre));
	}
	
	@Test
	public void testAddIngreNumException() throws Exception 
	{
		String[] addIngre = {"addIng", "I002", "Fish", "adfasdf", "asdfasdf"};
		CmdAddIngredient cmd = new CmdAddIngredient();
		assertEquals("Invalid input!", cmd.execute(addIngre));
	}
	
	@Test
	public void testAddIngreDuplicateId() throws Exception 
	{
		String[] addIngre = {"addIng", "I001", "Salt", "10", "30"};
		CmdAddIngredient cmd = new CmdAddIngredient();
		assertEquals("Ingredient ID has been used.", cmd.execute(addIngre));
	}
	
	@Test
	public void testAddIngreInvalidName() throws Exception 
	{
		String[] addIngre = {"addIng", "I003", " ", "10", "30"};
		CmdAddIngredient cmd = new CmdAddIngredient();
		assertEquals("Invalid input!", cmd.execute(addIngre));
	}
	
}
