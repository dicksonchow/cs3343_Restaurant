package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdRevenue;
import restaurant.Food;
import restaurant.Order;
import restaurant.Restaurant;

public class TestCmdRevenue {

    private Food f1;
    private Food f2;
    private Food f3;
    private Order o1;
    private Order o2;

    @Before
    public void setUp() throws Exception {
        f1 = new Food("F001", "CheeseBurger", "20");
        f2 = new Food("F002", "Pizza", "30");
        f3 = new Food("F003", "Sushi", "15");
		Restaurant.getInstance().addFood(f1);
		Restaurant.getInstance().addFood(f2);
		Restaurant.getInstance().addFood(f3);

        String[] order1 = {"F001", "F002", "F003"};
        o1 = new Order("T001", order1);
        String[] order2 = {"F001", "F003"};
        o2 = new Order("T002", order2);   
		Restaurant.getInstance().addOrder(o1);
		Restaurant.getInstance().addOrder(o2);
    }
	
    @After
    public void TearDown(){
        Restaurant.getInstance().removeFood(f1);
        Restaurant.getInstance().removeFood(f2);
        Restaurant.getInstance().removeFood(f3);
        Restaurant.getInstance().removeOrder(o1);
        Restaurant.getInstance().removeOrder(o2);
    }
    
    @Test
    public void testCmdRevenue() throws Exception{
    	//Revenue = 20 + 30 + 15 + 20 + 15 = 100
    	
        String expected = "$100           " + "\n";
    	CmdRevenue cmd = new CmdRevenue();
    	assertEquals(expected, cmd.execute());
    }

}
