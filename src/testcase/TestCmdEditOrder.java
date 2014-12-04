package testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import restaurant.CmdAddFood;
import restaurant.CmdAddOrder;
import restaurant.CmdEditOrder;

public class TestCmdEditOrder {

	@Before
	public void setUp() throws Exception {
		//Order must exist before editing order.
		
		String[] addFood1 = {"addFood", "F001", "CheeseBurger", "20"};
		CmdAddFood cmd1 = new CmdAddFood();
		cmd1.execute(addFood1);
		
		String[] addFood2 = {"addFood", "F002", "Pizza", "30"};
		CmdAddFood cmd2 = new CmdAddFood();
		cmd2.execute(addFood2);
		
		String[] addFood3 = {"addFood", "F003", "Sushi", "20"};
		CmdAddFood cmd3 = new CmdAddFood();
		cmd3.execute(addFood3);
		
		String[] addOrder = {"addOrder", "T001", "F001", "F002", "F003"};
		CmdAddOrder cmd4 = new CmdAddOrder();
		cmd4.execute(addOrder);
	}
	
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
