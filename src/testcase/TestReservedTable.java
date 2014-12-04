package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.ReservedTable;
import restaurant.Restaurant;

public class TestReservedTable {

	private ReservedTable t1;

	@Before
	public void setUp(){
		t1 = new ReservedTable("T001");
		Restaurant.getInstance().addRTable(t1);
	}
	
	@After
	public void teardown(){}
	
	@Test
	public void testRTableGetRTableId(){
		String id = t1.getRTableID();
		assertEquals("T001", id);
	}	
	
	@Test
	public void testRTableCompareToSmaller(){
		ReservedTable t2 = new ReservedTable("T002");
		int result = t1.compareTo(t2);
		assertEquals(-1,result);
	}
	
	@Test
	public void testRTableCompareToEqual(){
		ReservedTable t2 = new ReservedTable("T002");
		int result = t2.compareTo(t2);
		assertEquals(0, result);
	}
	
	@Test
	public void testRTableCompareToGreater(){
		ReservedTable t2 = new ReservedTable("T002");
		int result = t2.compareTo(t1);
		assertEquals(1, result);
	}
	
	@Test
	public void testRTableToString(){
		String toString = t1.toString();
		String exp = "T001                     ";
		assertEquals(exp, toString);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRTableListingHeading(){
		String toString = t1.getListingHeader();
		String exp = "Table_ID(Reserved Table) ";
		assertEquals(exp, toString);
	}
}
