package restaurant;

public class Ingredient implements Comparable<Ingredient> {

	private String iid;
	private String iname;
	private String iquantity;
	private String iprice;
	
	public Ingredient(String iid, String iname,String iquantity, String iprice) {
		this.iid=iid;
		this.iname=iname;
		this.iquantity=iquantity;
		this.iprice=iprice;
		Restaurant.getInstance().addIngredient(this);
	}

	public int getIngredientPrice() {
		int price = Integer.parseInt(iprice);
		return price;
	}
	
	public String getIngredientID() {
		return iid;
	}
	
	@Override
	public int compareTo(Ingredient another) {
		if (this.iid.equals(another.iid)) return 0;
		else if (this.iid.compareTo(another.iid)>0)return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return String.format("%-18s%-18s%-15s%-15s", iid, iname, iquantity, "$" + iprice);
	}
	
	public static String getListingHeader() {
	return String.format("%-18s%-18s%-15s%-15s", "Ingredient_ID", "Ingredient_Name", "Quantity", "Price");
	}
	

}
