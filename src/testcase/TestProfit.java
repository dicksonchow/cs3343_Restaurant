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
public class TestProfit {

    private Ingredient i1;
    private Ingredient i2;
    private Ingredient i3;
    private Food f1;
    private Food f2;
    private Food f3;
    private Food f4;
    private Food f5;
    private Order o1;
    private Order o2;
    private Order o3;

    @Before
    public void setUp() {
        Ingredient i1 = new Ingredient("001", "fish", "10", "20");
        Ingredient i2 = new Ingredient("002", "cheese", "100", "30");
        Ingredient i3 = new Ingredient("003", "sugar", "20", "50");
        Restaurant.getInstance().addIngredient(i1);
        Restaurant.getInstance().addIngredient(i2);
        Restaurant.getInstance().addIngredient(i3);
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;

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
        String[] order1 = {"F001", "F002", "F003"};
        String[] order2 = {"F001", "F003", "F004", "F005"};
        String[] order3 = {"F001", "F002", "F003", "F004", "F005"};
        Order o1 = new Order("T001", order1);
        Order o2 = new Order("T002", order2);
        Order o3 = new Order("T003", order3);
        Restaurant.getInstance().addOrder(o1);
        Restaurant.getInstance().addOrder(o2);
        Restaurant.getInstance().addOrder(o3);
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
    }

    @After
    public void teardown() {
        Restaurant.getInstance().removeIngredient(i1);
        Restaurant.getInstance().removeIngredient(i2);
        Restaurant.getInstance().removeIngredient(i3);
        Restaurant.getInstance().removeFood(f1);
        Restaurant.getInstance().removeFood(f2);
        Restaurant.getInstance().removeFood(f3);
        Restaurant.getInstance().removeFood(f4);
        Restaurant.getInstance().removeFood(f5);
        Restaurant.getInstance().removeOrder(o1);
        Restaurant.getInstance().removeOrder(o2);
        Restaurant.getInstance().removeOrder(o3);
    }

    @Test
    public void TestProfit() {
        int actual = Profit.getInstance().setProfit();
        int expected = 20 + 30 + 20 + 20 + 20 + 10 + 5 + 20 + 30 + 20 + 10 + 5 - (20 + 30 + 50);
        assertEquals(expected, actual);
    }

    @Test
    public void TestToString() {
        String actual = Profit.getInstance().toString();
        int exp_value = 20 + 30 + 20 + 20 + 20 + 10 + 5 + 20 + 30 + 20 + 10 + 5 - (20 + 30 + 50);
        String expected = String.format("%-15s\n", "$" + exp_value);
        assertEquals(expected, actual);
    }

    @Test
    public void TestCmdProfit() throws Exception{
        setOutput();
        (new CmdProfit()).execute();
        int exp_value = 20 + 30 + 20 + 20 + 20 + 10 + 5 + 20 + 30 + 20 + 10 + 5 - (20 + 30 + 50);
        String expected =  String.format("%-15s\n" , "$" + exp_value);
        assertEquals(expected, getOutput());
    }


    PrintStream oldPrintStream;
    ByteArrayOutputStream bos;

    private void setOutput() throws Exception {
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
