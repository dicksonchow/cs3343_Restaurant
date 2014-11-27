package testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import restaurant.*;

public class TestCmdFood {

	@Before
	public void setUp() throws Exception {}
	
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

}
