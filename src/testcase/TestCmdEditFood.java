package testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddFood;
import restaurant.CmdEditFood;

public class TestCmdEditFood {

	@Before
	public void setUp() throws Exception {
		//Food must exist before editing food.
		
		String[] addFood = {"addFood", "F001", "CheeseBurger", "20"};
		CmdAddFood cmd = new CmdAddFood();
		cmd.execute(addFood);
	}
	
	public void tearDown() {}

	/*CmdEditFood format: "editFood", Food_ID, Food_Name, Food_Price
	 *Food_ID is selected by user. Food_Name and Food_Price are inputed by user.
	 */
	
	@Test
	public void testEditFoodCorrect() throws Exception 
	{
		String[] editFood = {"editFood", "F001", "Hamburger", "30"};
		CmdEditFood cmd = new CmdEditFood();
		assertEquals("Food is edited.", cmd.execute(editFood));
	}
	
	@Test
	public void testEditFoodNumException() throws Exception 
	{
		String[] editFood = {"editFood", "F001", "Hamburger", "abcd"};
		CmdEditFood cmd = new CmdEditFood();
		assertEquals("Invalid food price!", cmd.execute(editFood));
	}
	
	@Test
	public void testEditFoodInvalidId() throws Exception 
	{
		String[] editFood = {"editFood", "F002", "Hamburger", "30"};
		CmdEditFood cmd = new CmdEditFood();
		assertEquals("Invalid food ID!", cmd.execute(editFood));
	}
	
	@Test
	public void testEditFoodInvalidName() throws Exception 
	{
		String[] editFood = {"editFood", "F001", " ", "20"};
		CmdEditFood cmd = new CmdEditFood();
		assertEquals("Invalid input!", cmd.execute(editFood));
	}

}
