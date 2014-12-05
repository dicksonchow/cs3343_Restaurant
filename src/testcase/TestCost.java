package testcase;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.Cost;
import restaurant.Ingredient;
import restaurant.Restaurant;

public class TestCost {
	
	private Ingredient i1 = new Ingredient("I001", "Fish", "10", "25");;
	private Ingredient i2 = new Ingredient("I002", "Cheese", "100", "30");;
	private Ingredient i3 = new Ingredient("I003", "Sugar", "20", "50");;

	@Before
	public void setUp(){
		//Ingredient must exist before calculating the cost.
		Restaurant.getInstance().addIngredient(i1);
		Restaurant.getInstance().addIngredient(i2);
		Restaurant.getInstance().addIngredient(i3);
	}
	
	@After
	public void teardown(){
		Restaurant.getInstance().removeIngredient(i1);
		Restaurant.getInstance().removeIngredient(i2);
		Restaurant.getInstance().removeIngredient(i3);
	}
	
	@Test
	public void testCostSetCost(){
		int cost = Cost.getInstance().setCost();
		int expectedCost = 25 + 30 + 50;
		assertEquals(expectedCost, cost);
	}
	
	@Test
	public void testCostToString(){
		//Cost = 25 + 30 + 50 = 105
		
		String exp = "$105           " + "\n";
		String str = Cost.getInstance().toString();
		assertEquals(exp, str);
	}

}
