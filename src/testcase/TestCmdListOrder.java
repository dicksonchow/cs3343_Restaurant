package testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddFood;
import restaurant.CmdAddOrder;
import restaurant.CmdListOrder;

public class TestCmdListOrder {

	@Before
	public void setUp() throws Exception {
		//Order must exist before listing order.
		
		String[] addFood1 = {"addFood", "F001", "CheeseBurger", "20"};
		CmdAddFood cmd1 = new CmdAddFood();
		cmd1.execute(addFood1);
		
		String[] addFood2 = {"addFood", "F002", "Pizza", "30"};
		CmdAddFood cmd2 = new CmdAddFood();
		cmd2.execute(addFood2);
		
		String[] addFood3 = {"addFood", "F003", "Sushi", "20"};
		CmdAddFood cmd3 = new CmdAddFood();
		cmd3.execute(addFood3);
		
		String[] addOrder1 = {"addOrder", "T001", "F001", "F002", "F003"};
		CmdAddOrder cmd4 = new CmdAddOrder();
		cmd4.execute(addOrder1);
		
		String[] addOrder2 = {"addOrder", "T002", "F002", "F003"};
		CmdAddOrder cmd5 = new CmdAddOrder();
		cmd5.execute(addOrder2);
	}
	
	public void tearDown() {}

	//CmdListOrder format: "listOrder"
	
	@Test
	public void testListOrder() throws Exception 
	{
		String listingHeader = "Table_ID     Total        Order                                   " + "\n";
		String toString1 = "T001         $70          CheeseBurger, Pizza, Sushi              " + "\n";
		String toString2 = "T002         $50          Pizza, Sushi                            " + "\n";
		String listOrder = listingHeader + toString1 + toString2;
		CmdListOrder cmd = new CmdListOrder();
		assertEquals(listOrder, cmd.execute());
	}

}
