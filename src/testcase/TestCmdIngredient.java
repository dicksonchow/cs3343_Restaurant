package testcase;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import restaurant.CmdAddFood;
import restaurant.CmdAddIngredient;
import restaurant.CmdDeleteIngredient;
import restaurant.CmdEditIngIngredient;
import restaurant.Ingredient;
import restaurant.Restaurant;

public class TestCmdIngredient {

	@Before
	public void setUp() throws Exception {
		Ingredient i1 = new Ingredient("001", "fish", "10", "20");
		Restaurant.getInstance().addIngredient(i1);
		Ingredient i2 = new Ingredient("002", "cheese", "100", "30");
		Restaurant.getInstance().addIngredient(i2);
	}
	
	@Test
	public void testAddIngreCorrect() throws Exception 
	{
		setOutput();
		String[] addIngre = {"addIng","005", "sugar", "10", "20"};
		(new CmdAddIngredient()).execute(addIngre);
		assertEquals("Ingredient is added.\n", getOutput());
	}
	
	@Test
	public void testAddIngreIdDul() throws Exception 
	{
		setOutput();
		String[] addIngre = {"addIng","001", "fish", "10", "20"};
		(new CmdAddIngredient()).execute(addIngre);
		assertEquals("Ingredient ID has been used.\n", getOutput());
	}
	
	@Test
	public void testAddIngreInvInput() throws Exception 
	{
		setOutput();
		String[] addIngre = {"addIng", "20"};
		(new CmdAddIngredient()).execute(addIngre);
		assertEquals("Invalid input!\n", getOutput());
	}
	
	@Test
	public void testAddIngreNumEx() throws Exception 
	{
		setOutput();
		String[] addIngre = {"addIng","001", "fish", "adfasdf", "asdfasdf"};
		(new CmdAddIngredient()).execute(addIngre);
		assertEquals("Invalid input!\n", getOutput());
	}
	
	@Test
	public void testEditIngreNotExists() throws Exception 
	{
		setOutput();
		String[] editIngre = {"editIng","020", "fish", "10", "20"};
		(new CmdEditIngIngredient()).execute(editIngre);
		assertEquals("Invalid ingredient ID!\n", getOutput());
	}
	
	@Test
	public void testEditIngreCorrect() throws Exception 
	{
		setOutput();
		String[] editIngre = {"editIng","001", "bean", "10", "20"};
		(new CmdEditIngIngredient()).execute(editIngre);
		assertEquals("Ingredient is edited.\n", getOutput());
	}
	
	@Test
	public void testEditIngreInputNotCorrect() throws Exception 
	{
		setOutput();
		String[] editIngre = {"001", "20"};
		(new CmdEditIngIngredient()).execute(editIngre);
		assertEquals("Invalid input!\n", getOutput());
	}
	
	@Test
	public void testEditIngreNumEx() throws Exception 
	{
		setOutput();
		String[] editIngre = {"editIng","001", "bean", "abc", "efg"};
		(new CmdEditIngIngredient()).execute(editIngre);
		assertEquals("Invalid input!\n", getOutput());
	}
	
	//deleteIng Ingredient_ID
	
	@Test
	public void testDeleteIngreCorr() throws Exception 
	{
		setOutput();
		String[] deleteIngre = {"deleteIng", "002"};
		(new CmdDeleteIngredient()).execute(deleteIngre);
		assertEquals("Ingredient is deleted.\n", getOutput());
	}
	
	@Test
	public void testDeleteIngreNotExists() throws Exception 
	{
		setOutput();
		String[] deleteIngre = {"deleteIng", "020"};
		(new CmdDeleteIngredient()).execute(deleteIngre);
		assertEquals("Invalid ingredient ID!\n", getOutput());
	}
	
	@Test
	public void testDeleteIngreInvInput() throws Exception 
	{
		setOutput();
		String[] deleteIngre = {"deleteIng", "002", "bean", "abc", "efg"};
		(new CmdDeleteIngredient()).execute(deleteIngre);
		assertEquals("Invalid input!\n", getOutput());
	}
	
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;  
	
	private void setOutput() throws Exception
	{
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();  
		System.setOut(new PrintStream(bos)); 
	}
	
	private String getOutput() //throws Exception
	{
		System.setOut(oldPrintStream);
		return bos.toString();
	}
	
}
