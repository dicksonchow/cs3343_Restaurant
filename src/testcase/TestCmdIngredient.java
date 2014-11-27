package testcase;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddIngredient;
import restaurant.CmdDeleteIngredient;
import restaurant.CmdEditIngIngredient;
import restaurant.Ingredient;
import restaurant.Restaurant;

public class TestCmdIngredient {

	@Before
	public void setUp() throws Exception {
		Ingredient i1 = new Ingredient("001", "fish", "10", "20");
		Restaurant.getInstance().addIngredient(i1);
		Ingredient i2 = new Ingredient("002", "cheese", "100", "30");
		Restaurant.getInstance().addIngredient(i2);
	}
	
	@Test
	public void testAddIngreCorrect() throws Exception 
	{
		String[] addIngre = {"addIng","005", "sugar", "10", "20"};
		assertEquals("Ingredient is added.", (new CmdAddIngredient()).execute(addIngre));
	}
	
	@Test
	public void testAddIngreIdDul() throws Exception 
	{
		String[] addIngre = {"addIng","001", "fish", "10", "20"};
		assertEquals("Ingredient ID has been used.", (new CmdAddIngredient()).execute(addIngre));
	}
	
	@Test
	public void testAddIngreInvInput() throws Exception 
	{
		String[] addIngre = {"addIng", "20"};
		assertEquals("Invalid input!", (new CmdAddIngredient()).execute(addIngre));
	}
	
	@Test
	public void testAddIngreNumEx() throws Exception 
	{
		String[] addIngre = {"addIng","001", "fish", "adfasdf", "asdfasdf"};
		assertEquals("Invalid input!", (new CmdAddIngredient()).execute(addIngre));
	}
	
	@Test
	public void testEditIngreNotExists() throws Exception 
	{
		String[] editIngre = {"editIng","020", "fish", "10", "20"};
		assertEquals("Invalid ingredient ID!", (new CmdEditIngIngredient()).execute(editIngre));
	}
	
	@Test
	public void testEditIngreCorrect() throws Exception 
	{
		String[] editIngre = {"editIng","001", "bean", "10", "20"};
		assertEquals("Ingredient is edited.", (new CmdEditIngIngredient()).execute(editIngre));
	}
	
	@Test
	public void testEditIngreInputNotCorrect() throws Exception 
	{
		String[] editIngre = {"001", "20"};
		assertEquals("Invalid input!", (new CmdEditIngIngredient()).execute(editIngre));
	}
	
	@Test
	public void testEditIngreNumEx() throws Exception 
	{
		String[] editIngre = {"editIng","001", "bean", "abc", "efg"};
		assertEquals("Invalid input!", (new CmdEditIngIngredient()).execute(editIngre));
	}
	
	//deleteIng Ingredient_ID
	
	@Test
	public void testDeleteIngreCorr() throws Exception 
	{
		String[] deleteIngre = {"deleteIng", "002"};
		assertEquals("Ingredient is deleted.", (new CmdDeleteIngredient()).execute(deleteIngre));
	}
	
	@Test
	public void testDeleteIngreNotExists() throws Exception 
	{
		String[] deleteIngre = {"deleteIng", "020"};
		assertEquals("Invalid ingredient ID!", (new CmdDeleteIngredient()).execute(deleteIngre));
	}
	
}
