package restaurant;

public class Order implements Comparable<Order> {

	private String tableId;
	private int totalAmount;	
	private String[] cmdParts;
	private String order;
	private Restaurant restaurant = Restaurant.getInstance();
	
	public Order(String[] cmdParts) {
		this.tableId=cmdParts[1];
		this.cmdParts=cmdParts;
		restaurant.addOrder(this);
	}

	public String setOrder() throws NullPointerException {
		order = "";
		
		for(int i=2; i<(cmdParts.length-1); i++) {	
			try {
				order = order + restaurant.findFood(cmdParts[i]).getFoodName() +", ";
			}
			catch (NullPointerException e) {
				order = order + "";
			}
		}
		
		try {
			order = order + restaurant.findFood(cmdParts[(cmdParts.length-1)]).getFoodName();
		}
		catch(NullPointerException e) {
			order = order.substring(0, order.length()-2);
		}
		return order;		
	}
	
	public int setTotalAmount() throws NullPointerException {
		totalAmount = 0;
		
		for(int i=2; i<cmdParts.length; i++) {
			try {
			totalAmount += restaurant.findFood(cmdParts[i]).getFoodPrice();
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
