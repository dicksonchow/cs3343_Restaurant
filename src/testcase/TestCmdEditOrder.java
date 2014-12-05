package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdEditOrder;
import restaurant.Food;
import restaurant.Order;
import restaurant.Restaurant;

public class TestCmdEditOrder {

	Food f1 = new Food("F001", "CheeseBurger", "20");
	Food f2 = new Food("F002", "Pizza", "30");
	Food f3 = new Food("F003", "Sushi", "10");
	
	String[] addOrder = {"F001", "F002", "F003"};
	Order o = new Order("T001", addOrder);
	
	String orderId;
	
	@Before
	public void setUp() throws Exception {
		//Order must exist before editing order.
		Restaurant.getInstance().addFood(f1);
		Restaurant.getInstance().addFood(f2);
		Restaurant.getInstance().addFood(f3);
		
		Restaurant.getInstance().addOrder(o);
	}
	
	@After
	public void tearDown() {
		Restaurant.getInstance().removeFood(f1);
		Restaurant.getInstance().removeFood(f2);
		Restaurant.getInstance().removeFood(f3);
		
		Restaurant.getInstance().removeOrder(o);
		
		Order od = Restaurant.getInstance().findOrder(orderId);
		Restaurant.getInstance().removeOrder(od);
	}
	
	/*CmdEditOrder format: "editOrder", Order_ID, Food_ID...(unrestricted number of Food_IDs)
	 *Order_ID is selected by user. Food_ID is inputed by user.
	 */
	
	@Test
	public void TestEditOrderCorrect() throws Exception{
		String[] orderStr = {"editOrder", "T001", "F002", "F003"};
		orderId = orderStr[1];
		CmdEditOrder cmd = new CmdEditOrder();
		assertEquals("Order is edited.", cmd.execute(orderStr));
	}

	@Test
	public void TestEditOrderInvalidTableId() throws Exception{
		String[] orderStr = {"editOrder", "T205", "F001", "F002"};
		orderId = orderStr[1];
		CmdEditOrder cmd = new CmdEditOrder();
		assertEquals("Invalid table ID!", cmd.execute(orderStr));
	}

	@Test
	public void TestEditOrderInvalidFoodId() throws Exception{
		String[] orderStr = {"editOrder", "T001", "F008"};
		orderId = orderStr[1];
		CmdEditOrder cmd = new CmdEditOrder();
		assertEquals("Invalid food ID!", cmd.execute(orderStr));
	}

	@Test
	public void TestEditOrderInvalidInput() throws Exception{
		String[] orderStr = {"editOrder", "T001"};
		orderId = orderStr[1];
		CmdEditOrder cmd = new CmdEditOrder();
		assertEquals("Invalid input!", cmd.execute(orderStr));
	}

}
