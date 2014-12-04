package testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import restaurant.CmdAddFood;
import restaurant.CmdListFood;

public class TestCmdListFood {

	@Before
	public void setUp() throws Exception {
		//Food must exist before listing food.
		
		String[] addFood1 = {"addFood", "F001", "CheeseBurger", "20"};
		CmdAddFood cmd1 = new CmdAddFood();
		cmd1.execute(addFood1);
		
		String[] addFood2 = {"addFood", "F002", "Hamburger", "30"};
		CmdAddFood cmd2 = new CmdAddFood();
		cmd2.execute(addFood2);
	}
	
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
