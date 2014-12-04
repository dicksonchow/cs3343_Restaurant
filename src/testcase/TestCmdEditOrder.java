package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdEditOrder;
import restaurant.Food;
import restaurant.Order;

public class TestCmdEditOrder {

	@Before
	public void setUp() throws Exception {
		//Order must exist before editing order.
		
		new Food("F001", "CheeseBurger", "20");
		new Food("F002", "Pizza", "30");
		new Food("F003", "Sushi", "10");
		
		String[] addOrder = {"F001", "F002", "F003"};
		new Order("T001", addOrder);
	}
	
	@After
	public void tearDown() {}
	
	/*CmdEditOrder format: "editOrder", Order_ID, Food_ID...(unrestricted number of Food_IDs)
	 *Order_ID is selected by user. Food_ID is inputed by user.
	 */
	
	@Test
	public void TestEditOrderCorrect() throws Exception{
		String[] orderStr = {"editOrder", "T001", "F002", "F003"};
		CmdEditOrder cmd = new CmdEditOrder();
		assertEquals("Order is edited.", cmd.execute(orderStr));
	}

	@Test
	public void TestEditOrderInvalidTableId() throws Exception{
		String[] orderStr = {"editOrder", "T205", "F001", "F002"};
		CmdEditOrder cmd = new CmdEditOrder();
		assertEquals("Invalid table ID!", cmd.execute(orderStr));
	}

	@Test
	public void TestEditOrderInvalidFoodId() throws Exception{
		String[] orderStr = {"editOrder", "T001", "F008"};
		CmdEditOrder cmd = new CmdEditOrder();
		assertEquals("Invalid food ID!", cmd.execute(orderStr));
	}

	@Test
	public void TestEditOrderInvalidInput() throws Exception{
		String[] orderStr = {"editOrder", "T001"};
		CmdEditOrder cmd = new CmdEditOrder();
		assertEquals("Invalid input!", cmd.execute(orderStr));
	}

}
