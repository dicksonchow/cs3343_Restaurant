package testcase;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdCost;
import restaurant.Ingredient;
import restaurant.Restaurant;

public class TestCmdCost {

	private Ingredient i1;
	private Ingredient i2;
	private Ingredient i3;

	@Before
	public void setUp(){
		//Ingredient must exist before calculating the cost.
		
		i1 = new Ingredient("I001", "Fish", "10", "25");
		i2 = new Ingredient("I002", "Cheese", "100", "30");
		i3 = new Ingredient("I003", "Sugar", "20", "50");
	}
	
	@After
	public void teardown(){
		Restaurant.getInstance().removeIngredient(i1);
		Restaurant.getInstance().removeIngredient(i2);
		Restaurant.getInstance().removeIngredient(i3);
	}
	
	
	@Test
	public void testCmdCost() throws Exception{
		//Cost = 25 + 30 + 50
		
		String exp = "$105           " +"\n";
		CmdCost cmd = new CmdCost();
		assertEquals(exp, cmd.execute());
	}

}
