package testcase;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.Food;
import restaurant.Ingredient;
import restaurant.Manager;
import restaurant.Order;
import restaurant.ReservedTable;
import restaurant.Restaurant;
import restaurant.Staff;

public class TestRestaurant {

	private Restaurant r = Restaurant.getInstance();
	private Food f1;
	private Food f2;
	private Food f3;
	private Staff s1;
	private Manager m1;
	private Staff s3;
	private Order o1;
	private Order o2;
	private Order o3;
	private ReservedTable t1;
	private ReservedTable t2;
	private ReservedTable t3;
	private Ingredient i1;
	private Ingredient i2;
	private Ingredient i3;
	
	@Before
	public void setUp() throws Exception {	
		f1 = new Food("F001", "CheeseBurger", "20");
		f2 = new Food("F002", "Hamburger", "30");
		r.addFood(f1);
		r.addFood(f2);
			
		s1 = new Staff("S001", "Mary", "Staff", "8000", "123");
		m1 = new Manager("M001", "Jack", "Manager", "15000", "123");
		r.addStaff(s1);
		r.addStaff(m1);
		
		String[] addOrder1 = {"F001", "F002"};
		o1 = new Order("T001", addOrder1);
		String[] addOrder2 = {"F002"};
		o2 = new Order("T002", addOrder2);
		r.addOrder(o1);
		r.addOrder(o2);
		
		t1 = new ReservedTable("T001");
		t2 = new ReservedTable("T002");
		r.addRTable(t1);
		r.addRTable(t2);
		
		i1 = new Ingredient("I001", "Sugar", "10", "20");
		i2 = new Ingredient("I002", "Fish", "10", "30");
		r.addIngredient(i1);
		r.addIngredient(i2);
		
	}
	
	@After
	public void tearDown() {
		r.removeFood(f1);
		r.removeFood(f2);
		r.removeFood(f3);
		
		r.removeStaff(s1);
		r.removeStaff(m1);
		r.removeStaff(s3);
		
		r.removeOrder(o1);
		r.removeOrder(o2);
		r.removeOrder(o3);
		
		r.removeRTable(t1);
		r.removeRTable(t2);
		r.removeRTable(t3);
		
		r.removeIngredient(i1);
		r.removeIngredient(i2);
		r.removeIngredient(i3);

	}
	
//Food	
	
	@Test
	public void testRestaurantListFood() throws Exception 
	{
		String listingHeader = "Food_ID      Food_Name      Price          " + "\n";
		String toString1 = "F001         CheeseBurger   $20            " + "\n";
		String toString2 = "F002         Hamburger      $30            " + "\n";
		String exp = listingHeader + toString1 + toString2;
		assertEquals(exp, r.listFood());
	}
	
	@Test
	public void testRestaurantAddFood() throws Exception 
	{
		f3 = new Food("F003", "Fish", "40");
		r.addFood(f3);
		String result = r.getFoodArrayList().toString();
		String toString1 = "F001         CheeseBurger   $20            ";
		String toString2 = "F002         Hamburger      $30            ";
		String toString3 = "F003         Fish           $40            ";
		String exp = "[" + toString1 + ", " + toString2 + ", " + toString3 + "]";
		assertEquals(exp, result);	
	}
	
	@Test
	public void testRestaurantRemoveFood() throws Exception 
	{
		r.removeFood(f1);
		String result = r.getFoodArrayList().toString();
		String toString2 = "F002         Hamburger      $30            ";
		String exp = "[" + toString2 + "]";
		assertEquals(exp, result);	
	}
	
	@Test
	public void testRestaurantFindFoodCorrect() throws Exception 
	{
		Food food = r.findFood("F001");
		String result = food.toString();
		String exp = "F001         CheeseBurger   $20            ";
		assertEquals(exp, result);	
	}
	
	@Test
	public void testRestaurantFindFoodNull() throws Exception 
	{
		assertEquals(null, r.findFood("F009"));	
	}
	
	@Test
	public void testRestaurantGetFoodArrayList() throws Exception 
	{
		String result = r.getFoodArrayList().toString();
		String toString1 = "F001         CheeseBurger   $20            ";
		String toString2 = "F002         Hamburger      $30            ";
		String exp = "[" + toString1 + ", " + toString2 + "]";
		assertEquals(exp, result);	
	}
	
//Staff
	
//	@Test
//	public void testRestaurantListStaff() throws Exception 
//	{
//		String listingHeader = "Staff_ID     Staff_Name   Position     Salary       " + "\n";
//		String toString1 = "M001         Jack         Manager      $15000       " + "\n";
//		String toString2 = "S001         Mary         Staff        $8000        " + "\n";
//		String exp = listingHeader + toString1 + toString2;
//		assertEquals(exp, r.listStaff());
//	}
	
//	@Test
//	public void testRestaurantAddStaff() throws Exception 
//	{
//		s3 = new Staff("S002", "Kate", "Staff", "8000", "123");
//		r.addStaff(s3);
//		String result = r.getStaffArrayList().toString();
//		String toString1 = "M001         Jack         Manager      $15000       ";
//		String toString2 = "S001         Mary         Staff        $8000        ";
//		String toString3 = "S002         Kate         Staff        $8000        ";
//		String exp = "[" + toString1 + ", " + toString2 + ", " + toString3 + "]";
//		assertEquals(exp, result);	
//	}
	
//	@Test
//	public void testRestaurantRemoveStaff() throws Exception 
//	{
//		r.removeStaff(s1);
//		String result = r.getStaffArrayList().toString();
//		String toString1 = "M001         Jack         Manager      $15000       ";
//		String exp = "[" + toString1 + "]";
//		assertEquals(exp, result);	
//	}
	
	@Test
	public void testRestaurantFindStaffCorrect() throws Exception 
	{
		Staff staff = r.findStaff("M001");
		String result = staff.toString();
		String exp = "M001         Jack         Manager      $15000       ";
		assertEquals(exp, result);	
	}
	
	@Test
	public void testRestaurantFindStaffNull() throws Exception 
	{
		assertEquals(null, r.findStaff("S009"));	
	}
	
//	@Test
//	public void testRestaurantGetStaffArrayList() throws Exception 
//	{
//		String result = r.getStaffArrayList().toString();
//		String toString1 = "M001         Jack         Manager      $15000       ";
//		String toString2 = "S001         Mary         Staff        $8000        ";
//		String exp = "[" + toString1 + ", "+ toString2 + "]";
//		assertEquals(exp, result);	
//	}	
	
//Order
		
	@Test
	public void testRestaurantListOrder() throws Exception 
	{
		String listingHeader = "Table_ID     Total        Order                                   " + "\n";
		String toString1 = "T001         $50          CheeseBurger, Hamburger                 " + "\n";
		String toString2 = "T002         $30          Hamburger                               " + "\n";
		String exp = listingHeader + toString1 + toString2;
		assertEquals(exp, r.listOrder());
	}
	
	@Test
	public void testRestaurantAddOrder() throws Exception 
	{
		String[] addOrder3 = {"F001"};
		o3 = new Order("T003", addOrder3);
		r.addOrder(o3);
		String result = r.getOrderArrayList().toString();
		String toString1 = "T001         $50          CheeseBurger, Hamburger                 ";
		String toString2 = "T002         $30          Hamburger                               ";
		String toString3 = "T003         $20          CheeseBurger                            ";
		String exp = "[" + toString1 + ", " + toString2 + ", " + toString3 + "]";
		assertEquals(exp, result);	
	}
	
	@Test
	public void testRestaurantRemoveOrder() throws Exception 
	{
		r.removeOrder(o1);
		String result = r.getOrderArrayList().toString();
		String toString2 = "T002         $30          Hamburger                               ";
		String exp = "[" + toString2 + "]";
		assertEquals(exp, result);	
	}
	
	@Test
	public void testRestaurantFindOrderCorrect() throws Exception 
	{
		Order order = r.findOrder("T001");
		String result = order.toString();
		String exp = "T001         $50          CheeseBurger, Hamburger                 ";
		assertEquals(exp, result);	
	}
	
	@Test
	public void testRestaurantFindOrderNull() throws Exception 
	{
		assertEquals(null, r.findOrder("T009"));	
	}
	
	@Test
	public void testRestaurantGetOrderArrayList() throws Exception 
	{
		String result = r.getOrderArrayList().toString();
		String toString1 = "T001         $50          CheeseBurger, Hamburger                 ";
		String toString2 = "T002         $30          Hamburger                               ";
		String exp = "[" + toString1 + ", "+ toString2 + "]";
		assertEquals(exp, result);	
	}	
	
//Reserved Table
	
//	@Test
//	public void testRestaurantListRTable() throws Exception 
//	{
//		String listingHeader = "Table_ID(Reserved Table) " + "\n";
//		String toString1 = "T001                     " + "\n";
//		String toString2 = "T002                     " + "\n";
//		String exp = listingHeader + toString1 + toString2;
//		assertEquals(exp, r.listRTable());
//	}
	
//	@Test
//	public void testRestaurantAddRTable() throws Exception 
//	{
//		t3 = new ReservedTable("T003");
//		r.addRTable(t3);
//		String result = r.getRTableArrayList().toString();
//		String toString1 = "T001                     ";
//		String toString2 = "T002                     ";
//		String toString3 = "T003                     ";
//		String exp = "[" + toString1 + ", " + toString2 + ", " + toString3 + "]";
//		assertEquals(exp, result);	
//	}
	
//	@Test
//	public void testRestaurantRemoveRTable() throws Exception 
//	{
//		r.removeRTable(t1);
//		String result = r.getRTableArrayList().toString();
//		String toString2 = "T002                     ";
//		String exp = "[" + toString2 + "]";
//		assertEquals(exp, result);	
//	}
	
	@Test
	public void testRestaurantFindRTableCorrect() throws Exception 
	{
		ReservedTable table = r.findRTable("T001");
		String result = table.toString();
		String exp = "T001                     ";
		assertEquals(exp, result);	
	}
	
	@Test
	public void testRestaurantFindRTableNull() throws Exception 
	{
		assertEquals(null, r.findRTable("T009"));	
	}
	
//	@Test
//	public void testRestaurantGetRTableArrayList() throws Exception 
//	{
//		String result = r.getRTableArrayList().toString();
//		String toString1 = "T001                     ";
//		String toString2 = "T002                     ";
//		String exp = "[" + toString1 + ", "+ toString2 + "]";
//		assertEquals(exp, result);	
//	}
	
//Ingredient
	
//	@Test
//	public void testRestaurantListIngredient() throws Exception 
//	{
//		String listingHeader = "Ingredient_ID  Ingredient_Name   Quantity     Price        " + "\n";
//		String toString1 = "I001           Sugar             10           $20          " + "\n";
//		String toString2 = "I002           Fish              10           $30          " + "\n";
//		String exp = listingHeader + toString1 + toString2;
//		assertEquals(exp, r.listIngredient());
//	}
	
//	@Test
//	public void testRestaurantAddIngredient() throws Exception 
//	{
//		i3 = new Ingredient("I003", "Cheese", "10", "40");
//		r.addIngredient(i3);
//		String result = r.getIngredientArrayList().toString();
//		String toString1 = "I001           Sugar             10           $20          ";
//		String toString2 = "I002           Fish              10           $30          ";
//		String toString3 = "I003           Cheese            10           $40          ";
//		String exp = "[" + toString1 + ", " + toString2 + ", " + toString3 + "]";
//		assertEquals(exp, result);	
//	}
	
//	@Test
//	public void testRestaurantRemoveIngredient() throws Exception 
//	{
//		r.removeIngredient(i1);
//		String result = r.getIngredientArrayList().toString();
//		String toString2 = "I002           Fish              10           $30          ";
//		String exp = "[" + toString2 + "]";
//		assertEquals(exp, result);	
//	}
	
//	@Test
//	public void testRestaurantFindIngredientCorrect() throws Exception 
//	{
//		Ingredient ingredient = r.findIngredient("I001");
//		String result = ingredient.toString();
//		String exp = "I001           Sugar             10           $20          ";
//		assertEquals(exp, result);	
//	}
	
	@Test
	public void testRestaurantFindIngredientNull() throws Exception 
	{
		assertEquals(null, r.findIngredient("I009"));	
	}
	
//	@Test
//	public void testRestaurantGetIngredientArrayList() throws Exception 
//	{
//		String result = r.getIngredientArrayList().toString();
//		String toString1 = "I001           Sugar             10           $20          ";
//		String toString2 = "I002           Fish              10           $30          ";
//		String exp = "[" + toString1 + ", "+ toString2 + "]";
//		assertEquals(exp, result);	
//	}
	
//Revenue
	
//	@Test
//	public void testRestaurantPrintRevenue() throws Exception 
//	{
//		setOutput();
//		r.printRevenue();
//		//Revenue = 20 + 30 + 30 = 80 (total amount of all orders)
//		
//		String exp = "$80            " + "\n";
//		assertEquals(exp, getOutput());
//	}

//Cost
	
//	@Test
//	public void testRestaurantPrintCost() throws Exception 
//	{
//		setOutput();
//		r.printCost();
//		//Cost = 20 + 30 = 50 (total amount of all ingredient)
//		
//		String exp = "$50            " + "\n";
//		assertEquals(exp, getOutput());
//	}

//Profit
	
//	@Test
//	public void testRestaurantPrintProfit() throws Exception 
//	{
//		setOutput();
//		r.printProfit();
//		//Profit = 80 - 50 = 30 (Revenue - Cost)
//		
//		String exp = "$30            " + "\n";
//		assertEquals(exp, getOutput());
//	}
	

	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;  

	private void setOutput() throws Exception
	{
	oldPrintStream = System.out;
	bos = new ByteArrayOutputStream();  
	System.setOut(new PrintStream(bos)); 
	}

	private String getOutput()
	{
	System.setOut(oldPrintStream);
	return bos.toString();
	}
	
}
