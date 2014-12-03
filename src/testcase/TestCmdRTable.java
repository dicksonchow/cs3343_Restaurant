package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import restaurant.*;

public class TestCmdRTable {

    @Before
    public void setUp() throws Exception{
        ReservedTable t1 = new ReservedTable("T1");
        ReservedTable t2 = new ReservedTable("T2");
        ReservedTable t3 = new ReservedTable("T3");
        Restaurant.getInstance().addRTable(t1);
        Restaurant.getInstance().addRTable(t2);
        Restaurant.getInstance().addRTable(t3);

    }

    public void tearDown(){}

    @Test
    public void testRTableCorrect() throws Exception{
        String[] RTable = {"T4"};
        assertEquals("Table is reserved.", (new CmdRTable()).execute(RTable));
    }

    @Test
    public void testRTableIdDul() throws Exception{
        String[] RTable = {"T1"};
        assertEquals("Table is unavailable.", (new CmdRTable()).execute(RTable));
    }

    @Test
    public void testRTableNotValid() throws Exception{
        String[] RTable = {"abc"};
        assertEquals("Invalid input!", (new CmdRTable()).execute(RTable));
    }

    @Test
    public void testDeleteRTableCorrect() throws Exception{
        String[] RTable = {"T1"};
        assertEquals("Table reservation is cancelled.", (new CmdDeleteRTable()).execute(RTable));
    }

    @Test
    public void testDeleteRTableNotValid() throws Exception{
        String[] RTable = {"abc"};
        assertEquals("Invalid Table ID!", (new CmdDeleteRTable()).execute(RTable));
    }

    @Test
    public void testEditRtableCorrect() throws Exception{
        String[] RTable = {"T1", "T5"};
        assertEquals("Table reservation is edited.",(new CmdEditRTable()).execute(RTable));
    }

    @Test
    public void testEditRTableIdDul() throws Exception{
        String[] RTable = {"T1", "T2"};
        assertEquals("T2 is unavailable", (new CmdEditRTable()).execute(RTable));
    }

    @Test
    public void testEditRTableNotValid() throws Exception{
        String[] RTable = {"abc", "T5"};
        assertEquals("Invalid Table ID!", (new CmdEditRTable()).execute(RTable));
    }
}
