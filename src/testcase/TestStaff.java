package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.Manager;
import restaurant.Restaurant;
import restaurant.Staff;

public class TestStaff {
	
	private Staff s;
	private Manager m;


	@Before
	public void setUp(){
		s = new Staff("S001", "Michael", "Staff", "2000", "abcd1234");
		m = new Manager("M001", "Jack", "Manager", "200000", "54321");
		Restaurant.getInstance().addStaff(s);
		Restaurant.getInstance().addStaff(m);
	}
	
	@After
	public void teardown(){}
	
	@Test
	public void testStaffGetStaffName(){
		String name = s.getStaffName();
		assertEquals("Michael", name);
	}
	
	@Test
	public void testStaffGetManagerName(){
		String name = m.getStaffName();
		assertEquals("Jack", name);
	}
	
	@Test
	public void testStaffGetStaffId(){
		String id = s.getStaffID();
		assertEquals("S001", id);
	}

	@Test
	public void testStaffGetManagerId(){
		String id = m.getStaffID();
		assertEquals("M001", id);
	}
	
	@Test
	public void testStaffGetStaffPosition(){
		String pos = s.getPosition();
		assertEquals("Staff", pos);
	}

	@Test
	public void testStaffGetManagerPosition(){
		String pos = m.getPosition();
		assertEquals("Manager", pos);
	}
	
	@Test
	public void testStaffGetStaffSalary(){
		int sal = s.getStaffSalary();
		assertEquals(2000, sal);
	}

	@Test
	public void testStaffGetManagerSalary(){
		int sal = m.getStaffSalary();
		assertEquals(200000, sal);
	}
	
	@Test
	public void testStaffGetStaffPasswd(){
		String pw = s.getStaffPassword();
		assertEquals("abcd1234", pw);
	}

	@Test
	public void testStaffGetManagerPasswd(){
		String pw = m.getStaffPassword();
		assertEquals("54321", pw);
	}
	
	@Test
	public void testStaffToStringStaff(){
		String str = s.toString();
		String expectedResult = "S001         Michael      Staff        $2000        ";
		assertEquals(expectedResult, str);
	}

	@Test
	public void testStaffToStringManager(){
		String str = m.toString();
		String expectedResult = "M001         Jack         Manager      $200000      ";
		assertEquals(expectedResult, str);
	}
	
	@Test
	public void testStaffGetListingHeaderStaff(){
		String str = s.toString();
		String expectedResult = "S001         Michael      Staff        $2000        ";
		assertEquals(expectedResult, str);
	}

	@Test
	public void testStaffGetListingHeaderManager(){
		String str = m.toString();
		String expectedResult = "M001         Jack         Manager      $200000      ";
		assertEquals(expectedResult, str);
	}
	
    @Test
    public void TestStaffCompareToSmaller(){
        int actual = m.compareTo(s);
        assertEquals(-1, actual);
    }

    @Test
    public void TestStaffCompareToEqual(){
        int actual = m.compareTo(m);
        assertEquals(0, actual);
    }

    @Test
    public void TestStaffCompareToGreater(){
        int actual = s.compareTo(m);
        assertEquals(1, actual);
    }


}
