package testcase;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import restaurant.Manager;
import restaurant.Staff;

public class TestStaff {
	
	private Staff s;
	private Manager m;


	@Before
	public void setUp(){
		Staff s = new Staff("S010", "Michael", "Staff", "2000", "abcd1234");
		Manager m = new Manager("M020", "Jack", "Manager", "200000", "54321");
		this.s = s;
		this.m = m;
	}
	
	@Test
	public void StaffGetName(){
		String name = s.getStaffName();
		assertEquals("Michael", name);
	}
	
	@Test
	public void ManagerGetName(){
		String name = m.getStaffName();
		assertEquals("Jack", name);
	}
	
	@Test
	public void StaffGetId(){
		String id = s.getStaffID();
		assertEquals("S010", id);
	}

	@Test
	public void ManagerGetId(){
		String id = m.getStaffID();
		assertEquals("M020", id);
	}
	
	@Test
	public void StaffGetPos(){
		String pos = s.getPosition();
		assertEquals("Staff", pos);
	}

	@Test
	public void ManagerGetPos(){
		String pos = m.getPosition();
		assertEquals("Manager", pos);
	}
	
	@Test
	public void StaffGetSalary(){
		int sal = s.getStaffSalary();
		assertEquals(2000, sal);
	}

	@Test
	public void ManagerGetSalary(){
		int sal = m.getStaffSalary();
		assertEquals(200000, sal);
	}
	
	@Test
	public void StaffGetPasswd(){
		String pw = s.getStaffPassword();
		assertEquals("abcd1234", pw);
	}

	@Test
	public void ManagerGetPasswd(){
		String pw = m.getStaffPassword();
		assertEquals("54321", pw);
	}
	
	@Test
	public void StaffToString(){
		String str = s.toString();
		String toBeCom = String.format("%-15s%-15s%-15s%-15s", "S010", "Michael", "Staff", "$" + "2000");
		assertEquals(toBeCom, str);
	}

	@Test
	public void ManagerToString(){
		String str = m.toString();
		String toBeCom = String.format("%-15s%-15s%-15s%-15s","M020", "Jack", "Manager", "$" + "200000");
		assertEquals(toBeCom, str);
	}
	
	@Test
	public void StaffGetListingHeader(){
		String str = s.toString();
		String toBeCom = String.format("%-15s%-15s%-15s%-15s", "S010", "Michael", "Staff", "$" + "2000");
		assertEquals(toBeCom, str);
	}

	@Test
	public void ManagerGetListingHeader(){
		String str = m.toString();
		String toBeCom = String.format("%-15s%-15s%-15s%-15s","M020", "Jack", "Manager", "$" + "200000");
		assertEquals(toBeCom, str);
	}
	
	@Test
	public void StaffOptionList() throws Exception{
		setOutput();
		s.printOptions();
		String ExpectedOpt = "\n--------------- Options ----------------\n"
				+ "a. List Order\n"
				+ "b. Add Order\n"
				+ "c. Edit Order\n"
				+ "d. Delete Order\n"
				+ "\ne. List Menu\n"
				+ "f. Add Food\n"
				+ "g. Edit Food\n"
				+ "h. Delete Food\n"
				+ "\ni. List Ingredient\n"
				+ "j. Add Ingredient\n"
				+ "k. Edit Ingredient\n"
				+ "l. Delete Ingredient\n"
				+ "\nm. List Reserved Table\n"
				+ "n. Reserve Table\n"
				+ "o. Edit Reserved Table\n"
				+ "p. Delete Reserved Table\n"
				+ "\n(You may enter \"options\" to check the options again.)\n";
		assertEquals(ExpectedOpt, getOutput());
	}
	
	@Test
	public void ManagerOptionList() throws Exception{
		setOutput();
		m.printOptions();
		String ExpectedOpt = "\n--------------- Options ----------------\n"
				+ "a. List Order\n"
				+ "b. Add Order\n"
				+ "c. Edit Order\n"
				+ "d. Delete Order\n"
				+ "\ne. List Menu\n"
				+ "f. Add Food\n"
				+ "g. Edit Food\n"
				+ "h. Delete Food\n"
				+ "\ni. List Ingredient\n"
				+ "j. Add Ingredient\n"
				+ "k. Edit Ingredient\n"
				+ "l. Delete Ingredient\n"
				+ "\nm. List Reserved Table\n"
				+ "n. Reserve Table\n"
				+ "o. Edit Reserved Table\n"
				+ "p. Delete Reserved Table\n"
				+ "\nq. List Staff\n"
				+ "r. Add Staff\n"
				+ "s. Edit Staff\n"
				+ "t. Delete Staff\n"
				+ "\nu. Revenue\n"
				+ "v. Cost\n"
				+ "w. Profit\n"
				+ "\n(You may enter \"options\" to check the options again.)\n";
		assertEquals(ExpectedOpt, getOutput());
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
