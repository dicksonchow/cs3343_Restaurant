package restaurant;

public class ReservedTable implements Comparable<ReservedTable> {

	private String tid;
	
	public ReservedTable(String tid) {
		this.tid=tid;
		Restaurant.getInstance().addRTable(this);
	}
	
	public String getRTableID() {
		return tid;
	}
	
	@Override
	public int compareTo(ReservedTable another) {
		if (this.tid.equals(another.tid)) return 0;
		else if (this.tid.compareTo(another.tid)>0)return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return String.format("%-15s", tid);
	}
	
	public static String getListingHeader() {
	return String.format("%-15s", "Table_ID(Reserved)");
	}
	
	
}
