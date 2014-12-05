package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdEditIngredient;
import restaurant.Ingredient;
import restaurant.Restaurant;

public class TestCmdEditIngredient {
	
	Ingredient i = new Ingredient("I001", "Sugar", "10", "20");
	String ingrdientId;

	@Before
	public void setUp() throws Exception {
		//Ingredient must exist before editing ingredient.
		Restaurant.getInstance().addIngredient(i);
	}
	
	@After
	public void tearDown() {
		Restaurant.getInstance().removeIngredient(i);
		
		Ingredient id = Restaurant.getInstance().findIngredient(ingrdientId);
		Restaurant.getInstance().removeIngredient(id);
	}

	/*CmdEditIngredient format: "editIng", Ingredient_ID, Ingredient_Name, Ingredient_Amount, Ingredient_Price
	 *Ingredient_ID is selected by user. Ingredient_Name, Ingredient_Amount and Ingredient_Price are inputed by user.
	 */
	
	@Test
	public void testEditIngreCorrect() throws Exception 
	{
		String[] editIngre = {"editIng", "I001", "Bean", "10", "30"};
		ingrdientId = editIngre[1];
		CmdEditIngredient cmd = new CmdEditIngredient();
		assertEquals("Ingredient is edited.", cmd.execute(editIngre));
	}
	
	@Test
	public void testEditIngreNumEx() throws Exception 
	{
		String[] editIngre = {"editIng", "I001", "Bean", "abc", "efg"};
		ingrdientId = editIngre[1];
		CmdEditIngredient cmd = new CmdEditIngredient();
		assertEquals("Invalid input!", cmd.execute(editIngre));
	}	
	
	@Test
	public void testEditIngreInvalidId() throws Exception 
	{
		String[] editIngre = {"editIng", "I020", "Fish", "10", "20"};
		ingrdientId = editIngre[1];
		CmdEditIngredient cmd = new CmdEditIngredient();
		assertEquals("Invalid ingredient ID!", cmd.execute(editIngre));
	}

	@Test
	public void testEditIngreInvalidName() throws Exception 
	{
		String[] editIngre = {"editIng", "I001", " ", "10", "20"};
		ingrdientId = editIngre[1];
		CmdEditIngredient cmd = new CmdEditIngredient();
		assertEquals("Invalid input!", cmd.execute(editIngre));
	}
	

}
