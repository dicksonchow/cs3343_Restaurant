package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdAddIngredient;
import restaurant.CmdDeleteFood;
import restaurant.CmdDeleteIngredient;
import restaurant.Ingredient;
import restaurant.Restaurant;

public class TestCmdAddIngredient {
	
	Ingredient i = new Ingredient ("I001", "Salt", "10", "30");
	String ingrdientId;
	//String[] deleteIng = {"deleteIng", ingrdientId};

	@Before
	public void setUp() throws Exception {
		//Ingredient I001 has been added.
		Restaurant.getInstance().addIngredient(i);
	}
	
	@After
	public void tearDown() {
		Restaurant.getInstance().removeIngredient(i);
		
		//CmdDeleteIngredient cmd = new CmdDeleteIngredient();
		//cmd.execute(deleteIng);
		Ingredient id = Restaurant.getInstance().findIngredient(ingrdientId);
		Restaurant.getInstance().removeIngredient(id);
	}
	
	/*CmdAddIngredient format: "addIng", Ingredient_ID, Ingredient_Name, Ingredient_Amount, Ingredient_Price
	 *Ingredient_ID is selected by user. Ingredient_Name, Ingredient_Amount and Ingredient_Price are inputed by user.
	 */
	
	@Test
	public void testAddIngreCorrect() throws Exception 
	{
		String[] addIngre = {"addIng", "I002", "Sugar", "10", "20"};
		ingrdientId = addIngre[1];
		CmdAddIngredient cmd = new CmdAddIngredient();
		assertEquals("Ingredient is added.", cmd.execute(addIngre));
	}
	
	@Test
	public void testAddIngreNumException() throws Exception 
	{
		String[] addIngre = {"addIng", "I003", "Fish", "adfasdf", "asdfasdf"};
		ingrdientId = addIngre[1];
		CmdAddIngredient cmd = new CmdAddIngredient();
		assertEquals("Invalid input!", cmd.execute(addIngre));
	}
	
	@Test
	public void testAddIngreDuplicateId() throws Exception 
	{
		String[] addIngre = {"addIng", "I001", "Cheese", "10", "40"};
		ingrdientId = addIngre[1];
		CmdAddIngredient cmd = new CmdAddIngredient();
		assertEquals("Ingredient ID has been used.", cmd.execute(addIngre));
	}
	
	@Test
	public void testAddIngreInvalidName() throws Exception 
	{
		String[] addIngre = {"addIng", "I003", " ", "10", "30"};
		ingrdientId = addIngre[1];
		CmdAddIngredient cmd = new CmdAddIngredient();
		assertEquals("Invalid input!", cmd.execute(addIngre));
	}
	
}
