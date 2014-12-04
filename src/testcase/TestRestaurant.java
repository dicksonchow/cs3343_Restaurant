package testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.Food;
import restaurant.Ingredient;
import restaurant.Order;
import restaurant.ReservedTable;
import restaurant.Restaurant;
import restaurant.Staff;

public class TestRestaurant {

	private Restaurant r = Restaurant.getInstance();
//	private ArrayList<Food> allFood = new ArrayList<Food>();
//	private ArrayList<Staff> allStaffs;
//	private ArrayList<Order> allOrders;
//	private ArrayList<ReservedTable> allRTables;
//	private ArrayList<Ingredient> allIngredients;
	
	@Before
	public void setUp() throws Exception {	
		new Food("F001", "CheeseBurger", "20");
		new Food("F002", "Hamburger", "30");

		

	}
	
	@After
	public void tearDown() {}
	
//Test Food	
	@Test
	public void testRestaurantListFood() throws Exception 
	{
		String listingHeader = "Food_ID      Food_Name      Price          " + "\n";
		String toString1 = "F001         CheeseBurger   $20            " + "\n";
		String toString2 = "F002         Hamburger      $30            " + "\n";
		String listFood = listingHeader + toString1 + toString2;
		assertEquals(listFood, r.listFood());
	}
	
	@Test
	public void testRestaurantAddFood() throws Exception 
	{
		Food f3 = new Food("F003", "Fish", "40");
		r.addFood(f3);
		String result = r.getFoodArrayList().toString();
		String toString1 = "F001         CheeseBurger   $20            " + ", ";
		String toString2 = "F002         Hamburger      $30            " + ", ";
		String toString3 = "F003         Fish           $40            " + ", ";
		String listFood = "[" + toString1 + toString2 + toString3 + "]";
		assertEquals(listFood, result);
		
	}
}
