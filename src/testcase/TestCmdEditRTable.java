package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdEditRTable;
import restaurant.ReservedTable;
import restaurant.Restaurant;

public class TestCmdEditRTable {

	@Before
	public void setUp() throws Exception {
		//Table must be reserved before editing reserved table.
		
		ReservedTable t1 = new ReservedTable("T001");
		ReservedTable t2 = new ReservedTable("T002");
		ReservedTable t3 = new ReservedTable("T003");
		Restaurant.getInstance().addRTable(t1);
		Restaurant.getInstance().addRTable(t2);
		Restaurant.getInstance().addRTable(t3);
	}
	
	@After
	public void tearDown() {}

	/*CmdEditRTable format: "editRTable", Table_ID, New_Table_ID
	 *Table_ID and New_Table_ID are selected by user.
	 */
	
	@Test
	public void testEditRTableCorrect() throws Exception 
	{
		String[] editRTable = {"editRTable", "T001", "T005"};
		CmdEditRTable cmd = new CmdEditRTable();
		assertEquals("Table reservation is edited.", cmd.execute(editRTable));
	}
	
	@Test
	public void testEditRTableInvalidId() throws Exception 
	{
		String[] editRTable = {"editRTable", "T008", "T009"};
		CmdEditRTable cmd = new CmdEditRTable();
		assertEquals("Invalid Table ID!", cmd.execute(editRTable));
	}
	
	@Test
	public void testEditRTableUnavailableTable() throws Exception 
	{
		String[] editRTable = {"editRTable", "T002", "T003"};
		CmdEditRTable cmd = new CmdEditRTable();
		assertEquals("T003 is unavailable.", cmd.execute(editRTable));
	}

}
