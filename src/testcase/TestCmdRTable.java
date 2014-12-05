package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdRTable;
import restaurant.Manager;
import restaurant.ReservedTable;
import restaurant.Restaurant;

public class TestCmdRTable {
	
	ReservedTable t = new ReservedTable("T001");
	
	String RTableId;

	@Before
	public void setUp() throws Exception {
		//Table T001 has been reserved.
		Restaurant.getInstance().addRTable(t);
	}
	
	@After
	public void tearDown() {
		Restaurant.getInstance().removeRTable(t);
		
		ReservedTable td = Restaurant.getInstance().findRTable(RTableId);
		Restaurant.getInstance().removeRTable(td);
	}

	/*CmdRTable format: "rTable", Table_ID
	 *Table_ID is selected by user.
	 */
	
	@Test
	public void testRTableCorrect() throws Exception 
	{
		String[] reserveTable = {"rTable", "T002"};
		RTableId = reserveTable[1];
		CmdRTable cmd = new CmdRTable();
		assertEquals("Table is reserved.", cmd.execute(reserveTable));
	}
	
	@Test
	public void testRTableUnavailableTable() throws Exception 
	{
		String[] reserveTable = {"rTable", "T001"};
		RTableId = reserveTable[1];
		CmdRTable cmd = new CmdRTable();
		assertEquals("Table is unavailable.", cmd.execute(reserveTable));
	}
	
}
