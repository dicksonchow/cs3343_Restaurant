package testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import restaurant.*;

public class TestCmdFood {

	@Before
	public void setUp() throws Exception {
		Food f1 = new Food("F001", "CheeseBurger", "20");
		Food f2 = new Food("F002", "Pizza", "30");
		Food f3 = new Food("F003", "Sushi", "20");
		Food f4 = new Food("F004", "Sandwich", "10");
		Food f5 = new Food("F005", "Apple Pie", "5");
		Restaurant.getInstance().addFood(f1);
		Restaurant.getInstance().addFood(f2);
		Restaurant.getInstance().addFood(f3);
		Restaurant.getInstance().addFood(f4);
		Restaurant.getInstance().addFood(f5);
	}
	
	public void tearDown() {}

	@Test
	public void testAddFoodCorrect() throws Exception 
	{
		String[] addFood = {"addFood", "F003", "CheeseBurger", "20"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Food is added.", cmd.execute(addFood));
	}
	
	@Test
	public void testAddFoodNumEx() throws Exception 
	{
		String[] addFood = {"addFood", "F006", "CheeseBurger", "abcd"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Invalid food price!", cmd.execute(addFood));
	}
	
	@Test
	public void testAddFoodDupId() throws Exception 
	{
		String[] addFood = {"addFood", "F003", "CheeseBurger", "20"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Food ID has been used.", cmd.execute(addFood));
	}
	
	@Test
	public void testAddFoodInvalid() throws Exception 
	{
		String[] addFood = {"F020", "CheeseBurger", "20"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Invalid input!", cmd.execute(addFood));
	}
	
	@Test
	public void testEditFoodCorrect() throws Exception{
		String[] editFood = {"editFood", "F003", "F002", "Pizza", "30"};
		assertEquals("Food is edited.", (new CmdEditFood()).execute(editFood));
	}
	
	@Test
	public void testEditFoodInvalidId() throws Exception{
		String [] editFood = {"editFood", "F350", "F002", "Pizza", "30"};
		assertEquals("Invalid food ID!", (new CmdEditFood()).execute(editFood));
	}
	
	@Test
	public void testEditFoodInvalidInput01() throws Exception{
		String[] editFood = {"editFood", "F003", "F02", "Pizza", "30"};
		assertEquals("Invalid input!", (new CmdEditFood()).execute(editFood));
	}
	
	@Test
	public void testEditFoodInvalidInput02() throws Exception{
		String[] editFood = {"editFood", "F003", "F002", "", "30"};
		assertEquals("Invalid input!", (new CmdEditFood()).execute(editFood));
	}
	
	@Test
	public void testEditFoodInvalidInput03() throws Exception{
		String[] editFood = {"editFood", "F003", "F002", "Pizza", "-1"};
		assertEquals("Invalid input!", (new CmdEditFood()).execute(editFood));
	}
	
	@Test
	public void testEditFoodFormatEx() throws Exception{
		String[] editFood = {"editFood", "F003", "F002", "Pizza", "abc"};
		assertEquals("Invalid food price!", (new CmdEditFood()).execute(editFood));
	}
	
	@Test
	public void testDeleteFoodCorrect() throws Exception{
		String[] deleteFood = {"deleteFood", "F003"};
		assertEquals("Food is deleted.", (new CmdDeleteFood()).execute(deleteFood));
	}
	
	@Test
	public void TestDeleteOrdertableNotValid() throws Exception{
		String[] deleteFood = {"deleteFood", "F450"};
		assertEquals("Invalid food ID!", (new CmdDeleteFood()).execute(deleteFood));
	}

}
