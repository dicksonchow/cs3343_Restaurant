package testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddFood;
import restaurant.CmdDeleteFood;

public class TestCmdDeleteFood {

	@Before
	public void setUp() throws Exception {
		//Food must exist before deleting food.
		
		String[] addFood = {"addFood", "F001", "CheeseBurger", "20"};
		CmdAddFood cmd = new CmdAddFood();
		cmd.execute(addFood);
	}
	
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
	
	@Test
	public void testDeleteFoodInvalidId() throws Exception 
	{
		String[] deleteFood = {"deleteFood", "F002"};
		CmdDeleteFood cmd = new CmdDeleteFood();
		assertEquals("Invalid food ID!", cmd.execute(deleteFood));
	}

}
