package testcase;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddStaff;
import restaurant.CmdDeleteStaff;
import restaurant.CmdEditStaff;

public class TestCmdStaff {
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
	public void testAddStaffManagerCorrect() throws Exception 
	{
		String[] addStaffManager = {"addStaff", "M100", "Michael", "Manager", "20", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff is added.", cmd.execute(addStaffManager));
	}
	
	@Test
	public void testAddStaffNormalCorrect() throws Exception 
	{
		String[] addStaffNormal = {"addStaff", "S120", "Jackson", "Staff", "50", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff is added.", cmd.execute(addStaffNormal));
	}
	
	@Test
	public void testAddStaffManagerDul() throws Exception 
	{
		String[] addStaffManager = {"addStaff", "M101", "Hello", "Manager", "20", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff ID has been used.", cmd.execute(addStaffManager));
	}
	
	@Test
	public void testAddStaffNormalDul() throws Exception 
	{
		String[] addStaffNormal = {"addStaff", "S101", "World", "Staff", "50", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff ID has been used.", cmd.execute(addStaffNormal));
	}
	
	@Test
	public void testAddStaffInvPos() throws Exception 
	{
		String[] addStaffInvPos = {"addStaff", "M200", "Arron", "asdfasdfasd", "50", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid position!", cmd.execute(addStaffInvPos));
	}
	
	@Test
	public void testAddStaffInvSal() throws Exception 
	{
		String[] addStaffInvPos = {"addStaff", "M150", "Arron", "Staff", "asdfasdfsd", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid salary!", cmd.execute(addStaffInvPos));
	}
	
	@Test
	public void testAddStaffNegSal() throws Exception 
	{
		String[] addStaffInvPos = {"addStaff", "M150", "Arron", "Staff", "-1000", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid input!", cmd.execute(addStaffInvPos));
	}
	
	@Test
	public void testAddStaffInvInput() throws Exception 
	{
		String[] addStaffInvPos = {"addStaff", "Arron", "50", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid input!", cmd.execute(addStaffInvPos));
	}
	
	//editStaff Staff_ID New_Staff_Name New_Staff_Position New_Staff_Salary New_Staff_Password
	
	@Test
	public void testEditStaffCorrect() throws Exception{
		String[] editStaffCorr = {"editStaff","S101","Java","Staff","20","321"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Staff is edited.", cmd.execute(editStaffCorr));
	}
	
	@Test
	public void testEditStaffInvPos() throws Exception{
		String[] editStaffCorr = {"editStaff","S101","Java","asdfasdf","20","321"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid position!", cmd.execute(editStaffCorr));
	}
	
	@Test
	public void testEditStaffNotExists() throws Exception{
		String[] editStaffCorr = {"editStaff","S500","Java","Staff","20","321"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid staff ID!", cmd.execute(editStaffCorr));
	}
	
	@Test
	public void testEditStaffInvInput() throws Exception{
		String[] editStaffCorr = {"editStaff","S500","20","321"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid input!", cmd.execute(editStaffCorr));
	}
	
	@Test
	public void testEditStaffInvSal() throws Exception{
		String[] editStaffCorr = {"editStaff","S500","Java","Staff","asdfsadfdas","321"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid salary!", cmd.execute(editStaffCorr));
	}
	
	@Test
	public void testEditStaffNegSal() throws Exception{
		String[] editStaffCorr = {"editStaff","S500","Java","Staff","-1000","321"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid input!", cmd.execute(editStaffCorr));
	}
	
	@Test
	public void testDeleteStaffCorr() throws Exception{
		String[] deleteStaffCorr = {"deleteStaff","S101"};
		CmdDeleteStaff cmd = new CmdDeleteStaff();
		assertEquals("Staff is deleted.", cmd.execute(deleteStaffCorr));
	}
	
	@Test
	public void testDeleteStaffInvId() throws Exception{
		String[] deleteStaffCorr = {"deleteStaff","S520"};
		CmdDeleteStaff cmd = new CmdDeleteStaff();
		assertEquals("Invalid staff ID!", cmd.execute(deleteStaffCorr));
	}

}
