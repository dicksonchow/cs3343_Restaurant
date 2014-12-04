package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdListRTable;
import restaurant.ReservedTable;

public class TestCmdListRTable {

	@Before
	public void setUp() throws Exception {
		//Table must be reserved before listing reserved table.
		
		new ReservedTable("T001");
		new ReservedTable("T002");
	}
	
	@After
	public void tearDown() {}

	//CmdListRTable format: "listRTable"
	
	@Test
	public void testListRTable() throws Exception 
	{
		String listingHeader = "Table_ID(Reserved Table) " + "\n";
		String toString1 = "T001                     " + "\n";
		String toString2 = "T002                     " + "\n";
		String listRTbale = listingHeader + toString1 + toString2;
		CmdListRTable cmd = new CmdListRTable();
		assertEquals(listRTbale, cmd.execute());
	}

}
