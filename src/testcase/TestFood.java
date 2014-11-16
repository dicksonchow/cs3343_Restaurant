package testcase;

import org.junit.Before;
import org.junit.Test;

import restaurant.CmdAddFood;
import restaurant.Food;

public class TestFood {

	@Before
	public void setUp() throws Exception {
		Food[] f= new Food[2];
		//f[0] = new Food("Spaghetti", 60);
		//f[1] = new Food("Soup", 30);
		//Staff s = new Staff("Tony", 8000);
		//order = new Order(f,s);
	}
	
	public void tearDown() {}
	
	@Test
	public void testAddFood() {
		String[] addFood = {"addFood","F003","CheeseBurger","20"};
		CmdAddFood cmd = new CmdAddFood();
		cmd.execute(addFood);
	} 
}
