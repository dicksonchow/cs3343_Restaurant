package testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddStaff;
import restaurant.CmdListStaff;

public class TestCmdListStaff {

	@Before
	public void setUp() throws Exception {
		//Staff must exist before listing Staff.
		
		String[] addStaff1 = {"addStaff", "M001", "Jack", "Manager", "15000", "123"};
		CmdAddStaff cmd1 = new CmdAddStaff();
		cmd1.execute(addStaff1);
		
		String[] addStaff2 = {"addStaff", "S001", "Mary", "Staff", "8000", "123"};
		CmdAddStaff cmd2 = new CmdAddStaff();
		cmd2.execute(addStaff2);
	}
	
	public void tearDown() {}

	//CmdListStaff format: "listStaff"
	
	@Test
	public void testListStaff() throws Exception 
	{
		String listingHeader = "Staff_ID     Staff_Name   Position     Salary       " + "\n";
		String toString1 = "M001         Jack         Manager      $15000       " + "\n";
		String toString2 = "S001         Mary         Staff        $8000        " + "\n";
		String listStaff = listingHeader + toString1 + toString2;
		CmdListStaff cmd = new CmdListStaff();
		assertEquals(listStaff, cmd.execute());
	}

}
