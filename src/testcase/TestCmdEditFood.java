package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdEditFood;
import restaurant.Food;
import restaurant.Restaurant;

public class TestCmdEditFood {
	
	Food f = new Food("F001", "CheeseBurger", "20");
	String foodId;

	@Before
	public void setUp() throws Exception {
		//Food must exist before editing food.
		Restaurant.getInstance().addFood(f);
	}
	
	@After
	public void tearDown() {
		Restaurant.getInstance().removeFood(f);
		//Restaurant.getInstance().removeFood(temp);
		Food fd = Restaurant.getInstance().findFood(foodId);
		Restaurant.getInstance().removeFood(fd);
	}

	/*CmdEditFood format: "editFood", Food_ID, Food_Name, Food_Price
	 *Food_ID is selected by user. Food_Name and Food_Price are inputed by user.
	 */
	
	@Test
	public void testEditFoodCorrect() throws Exception 
	{
		String[] editFood = {"editFood", "F001", "Hamburger", "30"};
		foodId = editFood[1];
		CmdEditFood cmd = new CmdEditFood();
		assertEquals("Food is edited.", cmd.execute(editFood));
	}
	
	@Test
	public void testEditFoodNumException() throws Exception 
	{
		String[] editFood = {"editFood", "F001", "Hamburger", "abcd"};
		foodId = editFood[1];
		CmdEditFood cmd = new CmdEditFood();
		assertEquals("Invalid food price!", cmd.execute(editFood));
	}
	
	@Test
	public void testEditFoodInvalidId() throws Exception 
	{
		String[] editFood = {"editFood", "F002", "Hamburger", "30"};
		foodId = editFood[1];
		CmdEditFood cmd = new CmdEditFood();
		assertEquals("Invalid food ID!", cmd.execute(editFood));
	}
	
	@Test
	public void testEditFoodInvalidName() throws Exception 
	{
		String[] editFood = {"editFood", "F001", " ", "20"};
		foodId = editFood[1];
		CmdEditFood cmd = new CmdEditFood();
		assertEquals("Invalid input!", cmd.execute(editFood));
	}

}
