package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdRTable;
import restaurant.ReservedTable;

public class TestCmdRTable {

	@Before
	public void setUp() throws Exception {
		//Table T001 has been reserved.
		
		new ReservedTable("T001");
	}
	
	@After
	public void tearDown() {}

	/*CmdRTable format: "rTable", Table_ID
	 *Table_ID is selected by user.
	 */
	
	@Test
	public void testRTableCorrect() throws Exception 
	{
		String[] reserveTable = {"rTable", "T002"};
		CmdRTable cmd = new CmdRTable();
		assertEquals("Table is reserved.", cmd.execute(reserveTable));
	}
	
	@Test
	public void testRTableUnavailableTable() throws Exception 
	{
		String[] reserveTable = {"rTable", "T001"};
		CmdRTable cmd = new CmdRTable();
		assertEquals("Table is unavailable.", cmd.execute(reserveTable));
	}
	
}
