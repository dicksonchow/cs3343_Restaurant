package restaurant;

public class Food implements Comparable<Food> {

	private String fid;
	private String fname;
	private String fprice;
	
	public Food(String fid, String fname, String fprice) {
		this.fid=fid;
		this.fname=fname;
		this.fprice=fprice;
		Restaurant.getInstance().addFood(this);
	}

	public int getFoodPrice() {
		int price = Integer.parseInt(fprice);
		return price;
	}
	
	public String getFoodName() {
		return fname;
	}
	
	public String getFoodID() {
		return fid;
	}
	
	@Override
	public int compareTo(Food another) {
		if (this.fid.equals(another.fid)) return 0;
		else if (this.fid.compareTo(another.fid)>0)return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return String.format("%-20s%-20s%-15s", fid, fname, "$" + fprice);
	}
	
	public static String getListingHeader() {
	return String.format("%-15s%-15s%-15s", "Food_ID", "Food_Name", "Price");
	}
	
}
