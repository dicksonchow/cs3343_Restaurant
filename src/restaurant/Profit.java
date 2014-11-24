package restaurant;

public class Profit {
	
	//private int profit;
	private static Profit instance = new Profit();

	public static Profit getInstance() {
		return instance;
	}

	public int setProfit() {
		return Revenue.getInstance().setRevenue() - Cost.getInstance().setCost(); //Before Cost.setCost()
	}
	
	public String toString() {
		int profit = setProfit();
		return String.format("%-15s\n", "$" + profit);
	}

}
