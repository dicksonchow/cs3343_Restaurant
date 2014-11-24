package testcase;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

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
//		setOutput();
		String[] addFood = {"addFood", "F003", "CheeseBurger", "20"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Food is added.", cmd.execute(addFood));
	}
	
	@Test
	public void testAddFoodNumEx() throws Exception 
	{
//		setOutput();
		String[] addFood = {"addFood", "F006", "CheeseBurger", "abcd"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Invalid food price!", cmd.execute(addFood));
	}
	
	@Test
	public void testAddFoodDupId() throws Exception 
	{
//		setOutput();
		String[] addFood = {"addFood", "F003", "CheeseBurger", "20"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Food ID has been used.", cmd.execute(addFood));
	}
	
	@Test
	public void testAddFoodInvalid() throws Exception 
	{
//		setOutput();
		String[] addFood = {"F020", "CheeseBurger", "20"};
		CmdAddFood cmd = new CmdAddFood();
		assertEquals("Invalid input!", cmd.execute(addFood));
	}
	
//	PrintStream oldPrintStream;
//	ByteArrayOutputStream bos;  
//	
//	private void setOutput() throws Exception
//	{
//		oldPrintStream = System.out;
//		bos = new ByteArrayOutputStream();  
//		System.setOut(new PrintStream(bos)); 
//	}
//	
//	private String getOutput() //throws Exception
//	{
//		System.setOut(oldPrintStream);
//		return bos.toString();
//	}
}
