package testcase;

import static org.junit.Assert.assertEquals;
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
		String[] orderStr = {"addOrder", "T003", "F001", "F002"};
		assertEquals("Order is added.", (new CmdAddOrder()).execute(orderStr));
	}
	
	@Test
	public void TestAddOrderIdDul() throws Exception{
		String[] orderStr = {"addOrder", "T001", "F001", "F002"};
		assertEquals("Order ID has been used.", (new CmdAddOrder()).execute(orderStr));
	}
	
	@Test
	public void TestAddOrderFoodNotValid() throws Exception{
		String[] orderStr = {"addOrder", "T004", "F001", "F350"};
		assertEquals("Invalid food ID!", (new CmdAddOrder()).execute(orderStr));
	}
	
	@Test
	public void TestAddOrderInvInput() throws Exception{
		String[] orderStr = {"addOrder", "F002"};
		assertEquals("Invalid input!", (new CmdAddOrder()).execute(orderStr));
	}

	@Test
	public void TestEditOrderCorrect() throws Exception{
		String[] orderStr = {"editOrder", "T001", "F001", "F002", "F003", "F004", "F005"};
		assertEquals("Order is edited.", (new CmdEditOrder()).execute(orderStr));
	}

	@Test
	public void TestEditOrderTableNotValid() throws Exception{
		String[] orderStr = {"editOrder", "T205", "F001", "F002", "F003"};
		(new CmdEditOrder()).execute(orderStr);
		assertEquals("Invalid table ID!", (new CmdEditOrder()).execute(orderStr));
	}

	@Test
	public void TestEditOrderFoodNotValid() throws Exception{
		String[] orderStr = {"editOrder", "T002", "F001", "F002", "F003", "F420", "F005"};
		assertEquals("Invalid food ID!", (new CmdEditOrder()).execute(orderStr));
	}

	@Test
	public void TestEditOrderInvInput() throws Exception{
		String[] orderStr = {"editOrder", "F005"};
		assertEquals("Invalid input!", (new CmdEditOrder()).execute(orderStr));
	}

	@Test
	public void TestDeleteOrderCorrect() throws Exception{
		String[] orderStr = {"deleteOrder", "T001"};
		assertEquals("Order is deleted.", (new CmdDeleteOrder()).execute(orderStr));
	}

	@Test
	public void TestDeleteOrderTableNotValid() throws Exception{
		String[] orderStr = {"deleteOrder", "T500"};
		assertEquals("Invalid table ID!", (new CmdDeleteOrder()).execute(orderStr));
	}

}
