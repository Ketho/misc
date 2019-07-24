import static org.junit.Assert.*;
import org.junit.Test;

public class DateTest
{
	@Test
	public void testConstructorDate()
	{
		Date dt = new Date("30/8/2014");
		//assertEquals(expected, actual);
		assertEquals("30/8/2014", dt.getDate());
	}
	
	@Test
	// also includes testing Date.GetDate
	public void testSetDate()
	{
		Date dt = new Date("21/2/2014");
		// now change to different date 
		dt.setDate("24/6/2014");
		assertEquals("24/6/2014", dt.getDate());
	}
	
	@Test
	public void test_toString()
	{
		Date dt = new Date("17/8/2014");
		assertEquals("17/8/2014", dt.toString());
	}
	
	@Test
	public void testEquals()
	{
		Date dt1 = new Date("22/7/2014");
		Date dt2 = new Date("22/7/2014");
		assertEquals(dt1, dt2);
	}
	
	@Test
	public void testNotEquals()
	{
		Date dt1 = new Date("22/7/2014");
		Date dt2 = new Date("14/1/201");
		assertNotEquals(dt1, dt2);
	}
}
