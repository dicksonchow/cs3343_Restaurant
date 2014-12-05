package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdDeleteFood;
import restaurant.Food;
import restaurant.Restaurant;

public class TestCmdDeleteFood {

	@Before
	public void setUp() throws Exception {
		//Food must exist before deleting food.
		
		Food f = new Food("F001", "CheeseBurger", "20");
		Restaurant.getInstance().addFood(f);
	}
	
	@After
	public void tearDown() {}

	/*CmdDeleteFood format: "deleteFood", Food_ID
	 *Food_ID is selected by user.
	 */
	
	@Test
	public void testDeleteFoodCorrect() throws Exception 
	{
		String[] deleteFood = {"deleteFood", "F001"};
		CmdDeleteFood cmd = new CmdDeleteFood();
		assertEquals("Food is deleted.", cmd.execute(deleteFood));
	}
	
//	@Test
//	public void testDeleteFoodInvalidId() throws Exception 
//	{
//		String[] deleteFood = {"deleteFood", "F002"};
//		CmdDeleteFood cmd = new CmdDeleteFood();
//		assertEquals("Invalid food ID!", cmd.execute(deleteFood));
//	}

}
