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
	public String listFood() {
		String listingHeader = Food.getListingHeader() + "\n";
		String toString ="";
		for (Food f: allFood) {
			toString += f.toString() + "\n";
		}
		return listingHeader + toString;
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
	
	public ArrayList<Food> getFoodArrayList() {
		return allFood;
	}

	
//Staff
	public String listStaff() {
		String listingHeader = Staff.getListingHeader() + "\n";
		String toString ="";
		for (Staff s: allStaffs) {
			toString += s.toString() + "\n";
		}
		return listingHeader + toString;
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
	public String listOrder() {
		String listingHeader = Order.getListingHeader() + "\n";
		String toString ="";
		for (Order o: allOrders) {
			toString += o.toString() + "\n";
		}
		return listingHeader + toString;
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
	public String listRTable() {
		String listingHeader = ReservedTable.getListingHeader() + "\n";
		String toString ="";
		for (ReservedTable t: allRTables) {
			toString += t.toString() + "\n";
		}
		return listingHeader + toString;
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
	public String listIngredient() {
		String listingHeader = Ingredient.getListingHeader() + "\n";
		String toString ="";
		for (Ingredient i: allIngredients) {
			toString += i.toString() + "\n";
		}
		return listingHeader + toString;
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