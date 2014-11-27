package testcase;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdCost;
import restaurant.Cost;
import restaurant.Ingredient;
import restaurant.Restaurant;

public class TestCost {
	
	private Ingredient i1;
	private Ingredient i2;
	private Ingredient i3;

	@Before
	public void setUp(){
		Ingredient i1 = new Ingredient("001", "fish", "10", "20");
		Ingredient i2 = new Ingredient("002", "cheese", "100", "30");
		Ingredient i3 = new Ingredient("003", "sugar", "20", "50");
		Restaurant.getInstance().addIngredient(i1);
		Restaurant.getInstance().addIngredient(i2);
		Restaurant.getInstance().addIngredient(i3);
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
	}
	
	@After
	public void teardown(){
		Restaurant.getInstance().removeIngredient(i1);
		Restaurant.getInstance().removeIngredient(i2);
		Restaurant.getInstance().removeIngredient(i3);
	}
	
	@Test
	public void testTotalCost(){
		int cost = Cost.getInstance().setCost();
		int exp = 50 + 30 + 20;
		assertEquals(exp, cost);
	}
	
	@Test
	public void testToString(){
		String str = Cost.getInstance().toString();
		int cost = 50 + 30 + 20;
		String exp = String.format("%-15s\n", "$" + cost);
		assertEquals(exp, str);
	}
	
	@Test
	public void testCmdCost() throws Exception{
		int cost = 50 + 30 + 20;
		String exp = String.format("%-15s\n", "$" + cost);
		assertEquals(exp, (new CmdCost()).execute());
	}

}
