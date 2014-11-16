package restaurant;

public class Profit {
	
	private int profit;

	public int setProfit() {
		profit = 0;
		return profit = Revenue.setRevenue() - Cost.setCost();
	}
	
	public String toString() {
		setProfit();
		return String.format("%-15s", "$" + profit);
	}

}
