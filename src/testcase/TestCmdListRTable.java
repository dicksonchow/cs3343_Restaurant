package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdListRTable;
import restaurant.ReservedTable;
import restaurant.Restaurant;

public class TestCmdListRTable {

	@Before
	public void setUp() throws Exception {
		//Table must be reserved before listing reserved table.
		
		ReservedTable t1 = new ReservedTable("T001");
		ReservedTable t2 = new ReservedTable("T002");
		Restaurant.getInstance().addRTable(t1);
		Restaurant.getInstance().addRTable(t2);
	}
	
	@After
	public void tearDown() {}

	//CmdListRTable format: "listRTable"
	
//	@Test
//	public void testListRTable() throws Exception 
//	{
//		String listingHeader = "Table_ID(Reserved Table) " + "\n";
//		String toString1 = "T001                     " + "\n";
//		String toString2 = "T002                     " + "\n";
//		String listRTbale = listingHeader + toString1 + toString2;
//		CmdListRTable cmd = new CmdListRTable();
//		assertEquals(listRTbale, cmd.execute());
//	}

}
