package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.Food;
import restaurant.Manager;
import restaurant.Order;
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
		
	}
	
	@After
	public void tearDown() {
		Restaurant.getInstance().removeFood(f1);
		Restaurant.getInstance().removeFood(f2);
		Restaurant.getInstance().removeFood(f3);
		
		Restaurant.getInstance().removeStaff(s1);
		Restaurant.getInstance().removeStaff(m1);
		Restaurant.getInstance().removeStaff(s3);
		
		Restaurant.getInstance().removeOrder(o1);
		Restaurant.getInstance().removeOrder(o2);
		Restaurant.getInstance().removeOrder(o3);
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
	
	@Test
	public void testRestaurantListStaff() throws Exception 
	{
		String listingHeader = "Staff_ID     Staff_Name   Position     Salary       " + "\n";
		String toString1 = "M001         Jack         Manager      $15000       " + "\n";
		String toString2 = "S001         Mary         Staff        $8000        " + "\n";
		String exp = listingHeader + toString1 + toString2;
		assertEquals(exp, r.listStaff());
	}
	
	@Test
	public void testRestaurantAddStaff() throws Exception 
	{
		s3 = new Staff("S002", "Kate", "Staff", "8000", "123");
		r.addStaff(s3);
		String result = r.getStaffArrayList().toString();
		String toString1 = "M001         Jack         Manager      $15000       ";
		String toString2 = "S001         Mary         Staff        $8000        ";
		String toString3 = "S002         Kate         Staff        $8000        ";
		String exp = "[" + toString1 + ", " + toString2 + ", " + toString3 + "]";
		assertEquals(exp, result);	
	}
	
	@Test
	public void testRestaurantRemoveStaff() throws Exception 
	{
		r.removeStaff(s1);
		String result = r.getStaffArrayList().toString();
		String toString1 = "M001         Jack         Manager      $15000       ";
		String exp = "[" + toString1 + "]";
		assertEquals(exp, result);	
	}
	
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
	
	@Test
	public void testRestaurantGetStaffArrayList() throws Exception 
	{
		String result = r.getStaffArrayList().toString();
		String toString1 = "M001         Jack         Manager      $15000       ";
		String toString2 = "S001         Mary         Staff        $8000        ";
		String exp = "[" + toString1 + ", "+ toString2 + "]";
		assertEquals(exp, result);	
	}	
	
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

}
