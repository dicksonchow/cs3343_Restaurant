package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdListOrder;
import restaurant.Food;
import restaurant.Order;
import restaurant.Restaurant;

public class TestCmdListOrder {
	
	Food f1 = new Food("F001", "CheeseBurger", "20");
	Food f2 = new Food("F002", "Pizza", "30");
	Food f3 = new Food("F003", "Sushi", "5");
	
	String[] addOrder1 = {"F001", "F002", "F003"};
	String[] addOrder2 = {"F002", "F003"};
	Order o1 = new Order("T001", addOrder1);
	Order o2 = new Order("T002", addOrder2);

	@Before
	public void setUp() throws Exception {
		//Order must exist before listing order.
		Restaurant.getInstance().addFood(f1);
		Restaurant.getInstance().addFood(f2);
		Restaurant.getInstance().addFood(f3);

		Restaurant.getInstance().addOrder(o1);
		Restaurant.getInstance().addOrder(o2);
	}
	
	@After
	public void tearDown() {
		Restaurant.getInstance().removeFood(f1);
		Restaurant.getInstance().removeFood(f2);
		Restaurant.getInstance().removeFood(f3);
		
		Restaurant.getInstance().removeOrder(o1);
		Restaurant.getInstance().removeOrder(o2);

	}

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
