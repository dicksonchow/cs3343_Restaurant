package testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import restaurant.Authentication;
import restaurant.CmdAddStaff;

public class TestAuth {

	@Before
	public void setUp() throws Exception {
		String[] addStaffManager = {"addStaff", "M101", "Hello", "Manager", "20", "123"};
		CmdAddStaff cmd1 = new CmdAddStaff();
		cmd1.execute(addStaffManager);
		String[] addStaffNormal = {"addStaff", "S101", "World", "Staff", "50", "123"};
		CmdAddStaff cmd2 = new CmdAddStaff();
		cmd2.execute(addStaffNormal);
	}
	
	public void tearDown() {}
	
	@Test
	public void testValidManagerNotExists(){
		boolean b = Authentication.getInstance().validation("M1000000", "4321");
		assertEquals(b, false);
	}
	
	@Test
	public void testValidPasswordNotCorrectManager(){
		boolean b = Authentication.getInstance().validation("M101", "4321");
		assertEquals(b, false);
	}
	
	@Test
	public void testValidPasswordAllCorrectManager(){
		boolean b = Authentication.getInstance().validation("M101", "123");
		assertEquals(b, true);
	}
	
	@Test
	public void testValidStaffNotExists(){
		boolean b = Authentication.getInstance().validation("S1000000", "4321");
		assertEquals(b, false);
	}
	
	@Test
	public void testValidPasswordNotCorrectStaff(){
		boolean b = Authentication.getInstance().validation("S101", "4321");
		assertEquals(b, false);
	}
	
	@Test
	public void testValidPasswordAllCorrectStaff(){
		boolean b = Authentication.getInstance().validation("S101", "123");
		assertEquals(b, true);
	}
}
