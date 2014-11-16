package restaurant;

import java.util.ArrayList;
import java.util.Collections;

public class Restaurant {

	private ArrayList<Food> allFood;
	private ArrayList<Staff> allStaffs;
	private ArrayList<Order> allOrders;
	private ArrayList<ReservedTable> allRTables;
	private ArrayList<Ingredient> allIngredients;
	private Revenue r;
	private Cost c;
	private Profit p;
	private static Restaurant instance = new Restaurant();

	private Restaurant() {
		allFood = new ArrayList<Food>();
		allStaffs = new ArrayList<Staff>();		
		allOrders = new ArrayList<Order>();
		allRTables = new ArrayList<ReservedTable>();
		allIngredients = new ArrayList<Ingredient>(); 
		r = new Revenue();
		c = new Cost();
		p = new Profit();
	}

	public static Restaurant getInstance() {
		return instance;
	}
	
//Food
	public void listFood() {
		System.out.println(Food.getListingHeader());
		for (Food f: allFood)
			System.out.println(f.toString());
	}

	public void addFood(Food f) {	
		allFood.add(f);
		Collections.sort(allFood);
	}

	public void removeFood(Food f) {
		allFood.remove(f);
	}

	public Food findFood(String fid) {	
		for(Food f: allFood){
			if(f.getFoodID().equals(fid)){
				return f;
			}
		}
		return null;
	}
	
//Staff
	public void listStaff() {
		System.out.println(Staff.getListingHeader());
		for (Staff s: allStaffs)
			System.out.println(s.toString());
	}

	public void addStaff(Staff s) {	
		allStaffs.add(s);
		Collections.sort(allStaffs);
	}

	public void removeStaff(Staff s) {
		allStaffs.remove(s);
	}

	public Staff findStaff(String sid) {	
		for(Staff s: allStaffs){
			if(s.getStaffID().equals(sid)){
				return s;
			}
		}
		return null;
	}
	
	public ArrayList<Staff> getStaffArrayList() {
		return allStaffs;
	}
	
//Order
	public void listOrder() {
		System.out.println(Order.getListingHeader());
		for (Order o: allOrders)
			System.out.println(o.toString());
	}

	public void addOrder(Order o) {	
		allOrders.add(o);
		Collections.sort(allOrders);
	}

	public void removeOrder(Order o) {
		allOrders.remove(o);
	}

	public Order findOrder(String oid) {	
		for(Order o: allOrders){
			if(o.getTableID().equals(oid)){
				return o;
			}
		}
		return null;
	}	
	
	public ArrayList<Order> getOrderArrayList() {
		return allOrders;
	}
	
//Reserved Table	
	public void listRTable() {
		System.out.println(ReservedTable.getListingHeader());
		for (ReservedTable t: allRTables)
			System.out.println(t.toString());
	}
	
	public void addRTable(ReservedTable t) {	
		allRTables.add(t);
		Collections.sort(allRTables);
	}

	public void removeRTable(ReservedTable t) {
		allRTables.remove(t);
	}

	public ReservedTable findRTable(String tid) {	
		for(ReservedTable t: allRTables){
			if(t.getRTableID().equals(tid)){
				return t;
			}
		}
		return null;
	}
	
//Ingredient
	public void listIngredient() {
		System.out.println(Ingredient.getListingHeader());
		for (Ingredient i: allIngredients)
			System.out.println(i.toString());
	}

	public void addIngredient(Ingredient i) {	
		allIngredients.add(i);
		Collections.sort(allIngredients);
	}

	public void removeIngredient(Ingredient i) {
		allIngredients.remove(i);
	}

	public Ingredient findIngredient(String iid) {	
		for(Ingredient i: allIngredients){
			if(i.getIngredientID().equals(iid)){
				return i;
			}
		}
		return null;
	}
	
	public ArrayList<Ingredient> getIngredientArrayList() {
		return allIngredients;
	}
	

//Revenue
	public void printRevenue() {
		System.out.println(r.toString());		
	}
		
//Cost
	public void printCost() {
		System.out.println(c.toString());		
	}
	
//Profit
	public void printProfit() {
		System.out.println(p.toString());		
	}
	
}