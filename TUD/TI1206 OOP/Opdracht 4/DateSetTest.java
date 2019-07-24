import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class DateSetTest
{
	@Test
	public void testConstructorDateList()
	{
		DateSet ds = new DateSet();
		// check whether the constructor made a new (empy) ArrayList object
		// by looking if the size of the new ArrayList object is actually zero
		assertEquals(0, ds.getDateSet().size());
	}
	
	@ Test
	public void testSetDateSet()
	{
		DateSet ds = new DateSet();
		ArrayList<Date> al = new ArrayList<Date>();
		
		ds.setDateSet(al);
		
		assertEquals(al, ds.getDateSet());
	}
	
	@ Test
	// also includes testing DateSet.get
	public void testAdd()
	{
		DateSet ds = new DateSet();
		Date dt = new Date("17/8/2014");
		
		ds.add(dt);
		
		assertEquals(dt, ds.getDateSet().get(0));
	}
	
	@ Test
	@SuppressWarnings("unused")
	public void testContains()
	{
		DateSet ds = new DateSet();
		Date dt1 = new Date("21/2/2014");
		Date dt2 = new Date("23/11/2014");
		ds.add(dt2);
		
		assertEquals(true, ds.contains(dt2));
	}
	
	@ Test
	public void testIntersection()
	{
		// instantiate datesets
		DateSet ds1 = new DateSet();
		DateSet ds2 = new DateSet();
		DateSet ds_expected = new DateSet();
		
		// instantiate dates
		Date dt1 = new Date("1/7/2014");
		Date dt2 = new Date("6/10/2014");
			Date dt3 = new Date("19/6/2014");
			Date dt4 = new Date("11/11/2014");
		Date dt5 = new Date("26/9/2014");
		Date dt6 = new Date("6/11/2014");
		
		// add dates {1, 2, 3, 4} to dateset 1 
		ds1.add(dt1);
		ds1.add(dt2);
			ds1.add(dt3);
			ds1.add(dt4);
		
		// add dates {3, 4, 5, 6} to dateset 2
			ds2.add(dt3);
			ds2.add(dt4);
		ds2.add(dt5);
		ds2.add(dt6);
		
		// add dates {3, 4} to dateset 3
			ds_expected.add(dt3);
			ds_expected.add(dt4);
		
		// test the intersection in ds1 and ds2
		DateSet intersect = ds1.intersection(ds2);
		
		assertEquals(ds_expected, intersect);
	}
	
	@ Test
	// toString representation example: "<DateSet[9/10/2014,4/7/2014]>"
	public void testToString()
	{
		DateSet ds = new DateSet();
		ds.add(new Date("9/10/2014"));
		ds.add(new Date("4/7/2014"));
		
		assertEquals("<DateSet[9/10/2014,4/7/2014]>", ds.toString());
	}
	
	@ Test
	public void testEquals()
	{
		DateSet ds1 = new DateSet();
		DateSet ds2 = new DateSet();
		
		String[] s = {
			"1/7/2014",
			"6/10/2014",
			"19/6/2014",
			"11/11/2014",
		};
		
		// add some data to both DateSet objects 
		for (int i=0; i<s.length; i++)
		{
			ds1.add(new Date(s[i]));
			ds2.add(new Date(s[i]));
		}
		
		assertEquals(ds1, ds2);
	}
	
	// the objects contain different dates
	@ Test
	public void testNotEquals()
	{
		DateSet ds1 = new DateSet();
		DateSet ds2 = new DateSet();
		
		ds1.add(new Date("20/1/2014"));
		ds1.add(new Date("18/3/2014"));
		
		ds2.add(new Date("20/1/2014"));
		ds2.add(new Date("10/8/2014"));
		
		assertNotEquals(ds1, ds2);
	}
}
