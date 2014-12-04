package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdDeleteOrder;
import restaurant.Food;
import restaurant.Order;
import restaurant.Restaurant;

public class TestCmdDeleteOrder {

	@Before
	public void setUp() throws Exception {
		//Order must exist before deleting order.
		
		Food f = new Food("F001", "CheeseBurger", "20");
		Restaurant.getInstance().addFood(f);
		
		String[] addOrder = {"F001"};
		Order o = new Order("T001", addOrder);
		Restaurant.getInstance().addOrder(o);
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
