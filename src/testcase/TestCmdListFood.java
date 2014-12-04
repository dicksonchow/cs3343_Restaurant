package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdListFood;
import restaurant.Food;

public class TestCmdListFood {

	@Before
	public void setUp() throws Exception {
		//Food must exist before listing food.
		
		new Food("F001", "CheeseBurger", "20");
		new Food("F002", "Hamburger", "30");
	}
	
	@After
	public void tearDown() {}

	//CmdListFood format: "listFood"
	
	@Test
	public void testListFood() throws Exception 
	{
		String listingHeader = "Food_ID      Food_Name      Price          " + "\n";
		String toString1 = "F001         CheeseBurger   $20            " + "\n";
		String toString2 = "F002         Hamburger      $30            " + "\n";
		String listFood = listingHeader + toString1 + toString2;
		CmdListFood cmd = new CmdListFood();
		assertEquals(listFood, cmd.execute());
	}

}
