package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.Food;
import restaurant.Order;
import restaurant.Restaurant;

public class TestOrder {

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
        
        String[] order1 = {"F002"};
        o1 = new Order("T001", order1);
        String[] order2 = {"F001", "F002", "F003"};
        o2 = new Order("T002", order2);
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
    public void TestOrderSetOrder1(){
        String s = o1.setOrder();
        assertEquals("Pizza", s);
    }

    @Test
    public void TestOrderSetOrder2(){
        String s = o2.setOrder();
        assertEquals("CheeseBurger, Pizza, Sushi", s);
    }

    @Test
    public void TestOrderSetTotalAmount1(){
        int actual = o1.setTotalAmount();
        assertEquals(30, actual);
    }

    @Test
    public void TestOrderSetTotalAmount2(){
    	//Total = 20 + 30 + 15
    	
        int actual = o2.setTotalAmount();
        assertEquals(65, actual);
    }

    @Test
    public void TestOrderGetTableId1(){
        String s = o1.getTableID();
        assertEquals("T001", s);
    }

    @Test
    public void TestOrderGetTableId2(){
        String s = o2.getTableID();
        assertEquals("T002", s);
    }

    @Test
    public void TestOrderCompareToGreater(){
        int actual = o1.compareTo(o2);
        assertEquals(-1, actual);
    }

    @Test
    public void TestOrderCompareToEqual(){
        int actual = o1.compareTo(o1);
        assertEquals(0, actual);
    }

    @Test
    public void TestOrderCompareToLess(){
        int actual = o2.compareTo(o1);
        assertEquals(1, actual);
    }

    @Test
    public void TestOrderToString1(){
        String actual = o1.toString();
        String expected = "T001         $30          Pizza                                   ";
        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderToString2(){
        String actual = o2.toString();
        String expected = "T002         $65          CheeseBurger, Pizza, Sushi              ";
        assertEquals(expected, actual);
    }

    @Test
    public void TestOrderGetListHeader(){
        String actual = Order.getListingHeader();
        String expected = "Table_ID     Total        Order                                   ";
        assertEquals(expected, actual);
    }
}
