package testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddFood;
import restaurant.CmdAddOrder;
import restaurant.CmdDeleteOrder;

public class TestCmdDeleteOrder {

	@Before
	public void setUp() throws Exception {
		//Order must exist before deleting order.
		
		String[] addFood = {"addFood", "F001", "CheeseBurger", "20"};
		CmdAddFood cmd1 = new CmdAddFood();
		cmd1.execute(addFood);
		
		String[] addOrder = {"addOrder", "T001", "F001"};
		CmdAddOrder cmd2 = new CmdAddOrder();
		cmd2.execute(addOrder);

	}
	
	/*CmdDeleteOrder format: "deleteOrder", Order_ID
	 *Order_ID is selected by user.
	 */
	
	@Test
	public void TestDeleteOrderCorrect() throws Exception{
		String[] orderStr = {"deleteOrder", "T001"};
		CmdDeleteOrder cmd = new CmdDeleteOrder();
		assertEquals("Order is deleted.", cmd.execute(orderStr));
	}

	@Test
	public void TestDeleteOrderTableNotValid() throws Exception{
		String[] orderStr = {"deleteOrder", "T500"};
		CmdDeleteOrder cmd = new CmdDeleteOrder();
		assertEquals("Invalid table ID!", cmd.execute(orderStr));
	}
}
