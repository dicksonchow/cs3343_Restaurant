package restaurant;

public class Order implements Comparable<Order> {

	private String tableId;
	private int totalAmount;	
	private String[] foodId;
	private String order;
	private Restaurant restaurant = Restaurant.getInstance();
	
	public Order(String tableId, String[] foodId) {
		this.tableId=tableId;
		this.foodId=foodId;
		//restaurant.addOrder(this);
	}

	public String setOrder() throws NullPointerException {
		order = ""; //order here is a string
		
		for(int i = 0; i<foodId.length; i++) {	
			try {
				if (i == foodId.length - 1)
					order = order + restaurant.findFood(foodId[i]).getFoodName();
				else
					order = order + restaurant.findFood(foodId[i]).getFoodName() +", ";
			}
			catch (NullPointerException e) {
				order = order + "";
			}
		}
		
		/*try {
			order = order + restaurant.findFood(foodId[foodId.length-1]).getFoodName();
		}
		catch(NullPointerException e) {
			order = order.substring(0, order.length()-2);
		}*/
		return order;		
	}
	
	public int setTotalAmount() throws NullPointerException {
		totalAmount = 0;
		
		for(int i=0; i<foodId.length; i++) {
			try {
				totalAmount += restaurant.findFood(foodId[i]).getFoodPrice();
			}
			catch(NullPointerException e) {
				totalAmount += 0;
			}
		}
		return totalAmount;
	}
	
	public int getTotalAmount() {
		return totalAmount;
	}
	
	public String getTableID() {
		return tableId;
	}
		
	@Override
	public int compareTo(Order another) {
		if (this.tableId.equals(another.tableId)) return 0;
		else if (this.tableId.compareTo(another.tableId)>0)return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		setOrder();
		setTotalAmount();
		return String.format("%-15s%-15s%-50s", tableId,  "$" +totalAmount, order);
	}
	
	public static String getListingHeader() {
	return String.format("%-15s%-15s%-50s", "Table_ID", "Total", "Order");
	}
	
}
