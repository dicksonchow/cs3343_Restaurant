package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdDeleteRTable;
import restaurant.ReservedTable;

public class TestCmdDeleteRTable {

	@Before
	public void setUp() throws Exception {
		//Table must be reserved before deleting reserved table.
		
		new ReservedTable("T001");
	}
	
	@After
	public void tearDown() {}

	/*CmdDeleteRTable format: "deleteRTable", Table_ID
	 *Table_ID is selected by user.
	 */
	
	@Test
	public void testDeleteRTableCorrect() throws Exception 
	{
		String[] deleteRTable = {"deleteRTable", "T001"};
		CmdDeleteRTable cmd = new CmdDeleteRTable();
		assertEquals("Table reservation is cancelled.", cmd.execute(deleteRTable));
	}
	
	@Test
	public void testDeleteRTableInvalidId() throws Exception 
	{
		String[] deleteRTable = {"deleteRTable", "T005"};
		CmdDeleteRTable cmd = new CmdDeleteRTable();
		assertEquals("Invalid Table ID!", cmd.execute(deleteRTable));
	}

}
