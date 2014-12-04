package testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.*;
import static org.junit.Assert.assertEquals;

public class TestProfit {

    private Ingredient i1;
    private Ingredient i2;
    private Ingredient i3;
    private Food f1;
    private Food f2;
    private Food f3;
    private Order o1;
    private Order o2;

    @Before
    public void setUp() {
        i1 = new Ingredient("I001", "Fish", "10", "20");
        i2 = new Ingredient("I002", "Cheese", "100", "30");
        i3 = new Ingredient("I003", "Sugar", "20", "10");

        f1 = new Food("F001", "CheeseBurger", "20");
        f2 = new Food("F002", "Pizza", "30");
        f3 = new Food("F003", "Sushi", "15");

        String[] order1 = {"F001", "F002", "F003"};
        o1 = new Order("T001", order1);
        String[] order2 = {"F001", "F003"};
        o2 = new Order("T002", order2);        
    }

    @After
    public void teardown() {
        Restaurant.getInstance().removeIngredient(i1);
        Restaurant.getInstance().removeIngredient(i2);
        Restaurant.getInstance().removeIngredient(i3);
        Restaurant.getInstance().removeFood(f1);
        Restaurant.getInstance().removeFood(f2);
        Restaurant.getInstance().removeFood(f3);
        Restaurant.getInstance().removeOrder(o1);
        Restaurant.getInstance().removeOrder(o2);
    }

    @Test
    public void TestProfitSetProfit() {
        int actual = Profit.getInstance().setProfit();
        int expectedCost = 20 + 30 + 10;
        int expectedRevenue = (20 + 30 + 15) + (20 + 15);
        int expectedResult = expectedRevenue - expectedCost;
        assertEquals(expectedResult, actual);
    }

    @Test
    public void TestProfitToString() {
        /*Cost = 20 + 30 + 10 = 60
         *Revenue = (20 + 30 + 15) + (20 + 15) = 100
         *Profit = 100 - 60 = 40
    	 */
    
        String expectedResult = "$40            " + "\n";
        String actual = Profit.getInstance().toString();
        assertEquals(expectedResult, actual);
    }

}
