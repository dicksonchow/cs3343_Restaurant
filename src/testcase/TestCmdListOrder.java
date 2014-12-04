package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdListOrder;
import restaurant.Food;
import restaurant.Order;

public class TestCmdListOrder {

	@Before
	public void setUp() throws Exception {
		//Order must exist before listing order.
		
		new Food("F001", "CheeseBurger", "20");
		new Food("F002", "Pizza", "30");
		new Food("F003", "Sushi", "5");

		String[] addOrder1 = {"F001", "F002", "F003"};
		new Order("T001", addOrder1);
		String[] addOrder2 = {"F002", "F003"};
		new Order("T002", addOrder2);
	}
	
	@After
	public void tearDown() {}

	//CmdListOrder format: "listOrder"
	
	@Test
	public void testListOrder() throws Exception 
	{
		String listingHeader = "Table_ID     Total        Order                                   " + "\n";
		String toString1 = "T001         $55          CheeseBurger, Pizza, Sushi              " + "\n";
		String toString2 = "T002         $35          Pizza, Sushi                            " + "\n";
		String listOrder = listingHeader + toString1 + toString2;
		CmdListOrder cmd = new CmdListOrder();
		assertEquals(listOrder, cmd.execute());
	}

}
