package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdDeleteOrder;
import restaurant.Food;
import restaurant.Order;

public class TestCmdDeleteOrder {

	@Before
	public void setUp() throws Exception {
		//Order must exist before deleting order.
		
		new Food("F001", "CheeseBurger", "20");
		
		String[] addOrder = {"F001"};
		new Order("T001", addOrder);
	}
	
	@After
	public void tearDown() {}
	
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
