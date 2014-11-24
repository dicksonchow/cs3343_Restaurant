package testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by root on 11/24/14.
 */
public class TestRevenue {

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
        Order o2 = new Order("T002", order2);
        Restaurant.getInstance().addOrder(o1);
        Restaurant.getInstance().addOrder(o2);
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
        Restaurant.getInstance().removeOrder(o1);
        Restaurant.getInstance().removeOrder(o2);
    }

    @Test
    public void TestRevenue(){
        int actual = Revenue.getInstance().setRevenue();
        int expected = 20 + 20 +20 + 10 + 5;
        assertEquals(expected, actual);
    }

    @Test
    public void TestToString(){
        String actual = Revenue.getInstance().toString();
        int ex_amount = 20 + 20 +20 + 10 + 5;
        String expected =  String.format("%-15s" , "$" + ex_amount);
        assertEquals(expected, actual);
    }

    @Test
    public void testCmdRevenue() throws Exception{
        setOutput();
        (new CmdRevenue()).execute();
        int ex_amount = 20 + 20 +20 + 10 + 5;
        String expected =  String.format("%-15s" , "$" + ex_amount);
        assertEquals(expected, getOutput());
    }

    PrintStream oldPrintStream;
    ByteArrayOutputStream bos;

    private void setOutput() throws Exception
    {
        oldPrintStream = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
    }

    private String getOutput() //throws Exception
    {
        System.setOut(oldPrintStream);
        return bos.toString();
    }
}
