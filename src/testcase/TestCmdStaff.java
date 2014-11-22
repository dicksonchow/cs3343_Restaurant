package testcase;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import restaurant.CmdAddStaff;

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
		setOutput();
		String[] addStaffManager = {"addStaff", "M100", "Michael", "Manager", "20", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		cmd.execute(addStaffManager);
		assertEquals("Staff is added.\n", getOutput());
	}
	
	@Test
	public void testAddStaffNormalCorrect() throws Exception 
	{
		setOutput();
		String[] addStaffNormal = {"addStaff", "S120", "Jackson", "Staff", "50", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		cmd.execute(addStaffNormal);
		assertEquals("Staff is added.\n", getOutput());
	}
	
	@Test
	public void testAddStaffManagerDul() throws Exception 
	{
		setOutput();
		String[] addStaffManager = {"addStaff", "M101", "Hello", "Manager", "20", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		cmd.execute(addStaffManager);
		assertEquals("Staff ID has been used.\n", getOutput());
	}
	
	@Test
	public void testAddStaffNormalDul() throws Exception 
	{
		setOutput();
		String[] addStaffNormal = {"addStaff", "S101", "World", "Staff", "50", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		cmd.execute(addStaffNormal);
		assertEquals("Staff ID has been used.\n", getOutput());
	}
	
	@Test
	public void testAddStaffInvPos() throws Exception 
	{
		setOutput();
		String[] addStaffInvPos = {"addStaff", "M200", "Arron", "asdfasdfasd", "50", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		cmd.execute(addStaffInvPos);
		assertEquals("Invalid position!\n", getOutput());
	}
	
	@Test
	public void testAddStaffInvSal() throws Exception 
	{
		setOutput();
		String[] addStaffInvPos = {"addStaff", "M150", "Arron", "Staff", "asdfasdfsd", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		cmd.execute(addStaffInvPos);
		assertEquals("Invalid salary!\n", getOutput());
	}
	
	@Test
	public void testAddStaffNegSal() throws Exception 
	{
		setOutput();
		String[] addStaffInvPos = {"addStaff", "M150", "Arron", "Staff", "-1000", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		cmd.execute(addStaffInvPos);
		assertEquals("Invalid input!\n", getOutput());
	}
	
	@Test
	public void testAddStaffInvInput() throws Exception 
	{
		setOutput();
		String[] addStaffInvPos = {"addStaff", "Arron", "50", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		cmd.execute(addStaffInvPos);
		assertEquals("Invalid input!\n", getOutput());
	}
	
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;  
	
	private void setOutput() throws Exception
	{
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();  
		System.setOut(new PrintStream(bos)); 
	}
	
	private String getOutput() //throws Exception
	{
		System.setOut(oldPrintStream);
		return bos.toString();
	}
}
