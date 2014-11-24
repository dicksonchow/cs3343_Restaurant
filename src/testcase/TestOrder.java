package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.Food;
import restaurant.Order;
import restaurant.Restaurant;

/**
 * Created by root on 11/24/14.
 */
public class TestOrder {

    private Food f1;
    private Food f2;
    private Food f3;
    private Food f4;
    private Food f5;
    private Order o1;
    private Order o2;

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
        Order o2 = new Order("T002", order2);Restaurant.getInstance().addOrder(o1);
        this.o1 = o1;
        this.o2 = o2;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
    }

    @After
    public void TearDown(){
        Restaurant.getInstance().removeFood(f1);
        Restaurant.getInstance().removeFood(f2);
        Restaurant.getInstance().removeFood(f3);
        Restaurant.getInstance().removeFood(f4);
        Restaurant.getInstance().removeFood(f5);
    }

    @Test
    public void TestSetOrder1(){
        String s = o1.setOrder();
        assertEquals("Sushi", s);
    }

    @Test
    public void TestSetOrder2(){
        String s = o2.setOrder();
        assertEquals("CheeseBurger, Sushi, Sandwich, Apple Pie", s);
    }

    @Test
    public void TestTotalAmount_1(){
        int actual = o1.setTotalAmount();
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    public void TestTotalAmount_2(){
        int actual = o2.setTotalAmount();
        int expected = 20 + 20 + 10 + 5;
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetTableId_1(){
        String s = o1.getTableID();
        assertEquals("T001", s);
    }

    @Test
    public void TestGetTableId_2(){
        String s = o2.getTableID();
        assertEquals("T002", s);
    }

    @Test
    public void TestCompareToGreater(){
        int actual = o1.compareTo(o2);
        assertEquals(-1, actual);
    }

    @Test
    public void TestCompareToEqual(){
        int actual = o1.compareTo(o1);
        assertEquals(0, actual);
    }

    @Test
    public void TestCompareToLess(){
        int actual = o2.compareTo(o1);
        assertEquals(1, actual);
    }

    @Test
    public void TestToString_1(){
        String actual = o1.toString();
        String expected = String.format("%-15s%-15s%-50s", "T001", "$20", "Sushi");
        assertEquals(expected, actual);
    }

    @Test
    public void TestToString_2(){
        String actual = o2.toString();
        String expected = String.format("%-15s%-15s%-50s", "T002", "$55", "CheeseBurger, Sushi, Sandwich, Apple Pie");
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetListHeader(){
        String actual = Order.getListingHeader();
        String expected = String.format("%-15s%-15s%-50s", "Table_ID", "Total", "Order");
        assertEquals(expected, actual);
    }
}
