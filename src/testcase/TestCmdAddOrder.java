package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.*;


public class TestCmdAddOrder {

	@Before
	public void setUp() throws Exception {
		//Food must exist before adding order.
		
		new Food("F001", "CheeseBurger", "20");
		new Food("F002", "Pizza", "30");
		new Food("F003", "Sushi", "10");
	}
	
	@After
	public void tearDown() {}
	
	/*CmdAddOrder format: "addOrder", Order_ID, Food_ID...(unrestricted number of Food_IDs)
	 *Order_ID is selected by user. Food_ID is inputed by user.
	 */
	
	@Test
	public void TestAddOrderCorrect() throws Exception{
		String[] orderStr = {"addOrder", "T001", "F001", "F002"};
		CmdAddOrder cmd = new CmdAddOrder();
		assertEquals("Order is added.", cmd.execute(orderStr));
	}
	
	@Test
	public void TestAddOrderDuplicateId() throws Exception{
		String[] orderStr = {"addOrder", "T001", "F003"};
		CmdAddOrder cmd = new CmdAddOrder();
		assertEquals("Order ID has been used.", cmd.execute(orderStr));
	}
	
	@Test
	public void TestAddOrderInvalidFoodId() throws Exception{
		String[] orderStr = {"addOrder", "T002", "F001", "F350"};
		CmdAddOrder cmd = new CmdAddOrder();
		assertEquals("Invalid food ID!", cmd.execute(orderStr));
	}
	
	@Test
	public void TestAddOrderInvalidInput() throws Exception{
		String[] orderStr = {"addOrder", "T003"};
		CmdAddOrder cmd = new CmdAddOrder();
		assertEquals("Invalid input!", cmd.execute(orderStr));
	}

}
