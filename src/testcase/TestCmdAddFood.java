package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdAddFood;
import restaurant.Food;

public class TestCmdAddFood {

	@Before
	public void setUp() throws Exception {
		//Food F001 has been added.
		
		new Food ("F001", "Hamburger", "30");
	}
	
	@After
	public void tearDown() {}

	/*CmdAddFood format: "addFood", Food_ID, Food_Name, Food_Price
	 *Food_ID is selected by user. Food_Name and Food_Price are inputed by user.
	 */
	
	@Test
	public void testAddFoodCorrect() throws Exception 
	{
		String[] addFood = {"addFood", "F002", "CheeseBurger", "20"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Food is added.", cmd.execute(addFood));
	}
	
	@Test
	public void testAddFoodNumException() throws Exception 
	{
		String[] addFood = {"addFood", "F003", "Hamburger", "abcd"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Invalid food price!", cmd.execute(addFood));
	}
	
	@Test
	public void testAddFoodDuplicateId() throws Exception 
	{
		String[] addFood = {"addFood", "F001", "Sushi", "10"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Food ID has been used.", cmd.execute(addFood));
	}
	
	@Test
	public void testAddFoodInvalidName() throws Exception 
	{
		String[] addFood = {"addFood", "F004", " ", "20"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Invalid input!", cmd.execute(addFood));
	}

}
