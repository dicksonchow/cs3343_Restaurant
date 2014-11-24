package testcase;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import restaurant.*;


public class TestCmdOrder {

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
		String[] order1 = {"F003"};
		String[] order2 = {"F001", "F003", "F004", "F005"};
		Order o1 = new Order("T001", order1);
		Order o2 = new Order("T002", order2);
		Restaurant.getInstance().addOrder(o1);
		Restaurant.getInstance().addOrder(o2);
	}
	
	//addOrder T003 F001 F002
	
	@Test
	public void TestAddOrderCorrect() throws Exception{
		setOutput();
		String[] orderStr = {"addOrder", "T003", "F001", "F002"};
		(new CmdAddOrder()).execute(orderStr);
		assertEquals("Order is added.\n", getOutput());
	}
	
	@Test
	public void TestAddOrderIdDul() throws Exception{
		setOutput();
		String[] orderStr = {"addOrder", "T001", "F001", "F002"};
		(new CmdAddOrder()).execute(orderStr);
		assertEquals("Order ID has been used.\n", getOutput());
	}
	
	@Test
	public void TestAddOrderFoodNotValid() throws Exception{
		setOutput();
		String[] orderStr = {"addOrder", "T004", "F001", "F350"};
		(new CmdAddOrder()).execute(orderStr);
		assertEquals("Invalid food ID!\n", getOutput());
	}
	
	@Test
	public void TestAddOrderInvInput() throws Exception{
		setOutput();
		String[] orderStr = {"addOrder", "F002"};
		(new CmdAddOrder()).execute(orderStr);
		assertEquals("Invalid input!\n", getOutput());
	}

	@Test
	public void TestEditOrderCorrect() throws Exception{
		setOutput();
		String[] orderStr = {"editOrder", "T001", "F001", "F002", "F003", "F004", "F005"};
		(new CmdEditOrder()).execute(orderStr);
		assertEquals("Order is edited.\n", getOutput());
	}

	@Test
	public void TestEditOrderTableNotValid() throws Exception{
		setOutput();
		String[] orderStr = {"editOrder", "T205", "F001", "F002", "F003"};
		(new CmdEditOrder()).execute(orderStr);
		assertEquals("Invalid table ID!\n", getOutput());
	}

	@Test
	public void TestEditOrderFoodNotValid() throws Exception{
		setOutput();
		String[] orderStr = {"editOrder", "T002", "F001", "F002", "F003", "F420", "F005"};
		(new CmdEditOrder()).execute(orderStr);
		assertEquals("Invalid food ID!\n", getOutput());
	}

	@Test
	public void TestEditOrderInvInput() throws Exception{
		setOutput();
		String[] orderStr = {"editOrder", "F005"};
		(new CmdEditOrder()).execute(orderStr);
		assertEquals("Invalid input!\n", getOutput());
	}

	@Test
	public void TestDeleteOrderCorrect() throws Exception{
		setOutput();
		String[] orderStr = {"deleteOrder", "T001"};
		(new CmdDeleteOrder()).execute(orderStr);
		assertEquals("Order is deleted.\n", getOutput());
	}

	@Test
	public void TestDeleteOrderTableNotValid() throws Exception{
		setOutput();
		String[] orderStr = {"deleteOrder", "T500"};
		(new CmdDeleteOrder()).execute(orderStr);
		assertEquals("Invalid table ID!\n", getOutput());
	}

	@Test
	public void TestDeleteOrderInvInput() throws Exception{
		setOutput();
		String[] orderStr = {"deleteOrder", "T002", "F005"};
		(new CmdDeleteOrder()).execute(orderStr);
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
