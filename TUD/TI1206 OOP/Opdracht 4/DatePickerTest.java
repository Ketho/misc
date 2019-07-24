import static org.junit.Assert.*;

import org.junit.Test;

public class DatePickerTest
{
	@Test
	public void testAdd()
	{
		DatePicker dp = new DatePicker();
		Person ps = new Person("Sophia");
		dp.add(ps);
		assertEquals(ps, dp.getPerson().get(0));
	}
	
	@Test
	public void testCommonDatesOnePerson()
	{
		// create Date
		Date dt1 = new Date("18/6/2014");
		Date dt2 = new Date("31/7/2014");
		Date dt3 = new Date("25/11/2014");
		Date dt4 = new Date("20/4/2014");
		
		// create Person
		Person p1 = new Person("Sophia", new DateSet());	
		
		// add Date to Person
		p1.add(dt1);
		p1.add(dt2);
		p1.add(dt3);
		p1.add(dt4);
		
		// create DatePicker
		DatePicker dp = new DatePicker();
		dp.add(p1);
		
		// get intersecting dates
		DateSet intersect = dp.commonDates();
		
		// expected DateSet
		DateSet expected = new DateSet();
		expected.add(dt1);
		expected.add(dt2);
		expected.add(dt3);
		expected.add(dt4);
		
		assertEquals(expected, intersect);
	}
	
	@Test
	public void testCommonDatesThreePersons()
	{
		// create Date
		Date dt1 = new Date("9/6/2014");
		Date dt2 = new Date("29/7/2014");
		Date dt3 = new Date("26/5/2014");
		Date dt4 = new Date("12/6/2014");
		Date dt5 = new Date("31/3/2014");
		Date dt6 = new Date("20/1/2014");
		
		// create Person
		Person p1 = new Person("Sophia", new DateSet());	
		Person p2 = new Person("Sarah", new DateSet());
		Person p3 = new Person("Shana", new DateSet());
		
		// add Date to Person
		p1.add(dt1);
		p1.add(dt2);
			p1.add(dt3);
			p1.add(dt4);
		
		p2.add(dt2);
			p2.add(dt3);
			p2.add(dt4);
		p2.add(dt5);
		
			p3.add(dt3);
			p3.add(dt4);
		p3.add(dt5);
		p3.add(dt6);
		
		// create DatePicker
		DatePicker dp = new DatePicker();
		dp.add(p1);
		dp.add(p2);
		dp.add(p3);
		
		// get intersecting dates
		DateSet intersect = dp.commonDates();
		
		// expected DateSet
		DateSet expected = new DateSet();
			expected.add(dt3);
			expected.add(dt4);
		
		assertEquals(expected, intersect);
	}
	
	@Test
	public void testNoCommonDatesTwoPersons()
	{
		// create Date
		Date dt1 = new Date("11/11/2014");
		Date dt2 = new Date("10/5/2014");
		Date dt3 = new Date("3/8/2014");
		Date dt4 = new Date("7/12/2014");
		
		// create Person, add Date to Person
		Person p1 = new Person("Sophia", new DateSet());	
		p1.add(dt1);
		p1.add(dt2);
		
		Person p2 = new Person("Sarah", new DateSet());	
		p2.add(dt3);
		p2.add(dt4);
		
		// create DatePicker
		DatePicker dp = new DatePicker();
		dp.add(p1);
		dp.add(p2);
		
		// get intersecting dates
		DateSet intersect = dp.commonDates();
		
		// expected DateSet
		DateSet expected = new DateSet();
		
		assertEquals(expected, intersect);
	}
	
	@Test
	public void testToString()
	{
		
		DatePicker dp = new DatePicker();
		
		Person ps1 = new Person("Seira");
		Person ps2 = new Person("Sophia");
		Person ps3 = new Person("Shana");
		
		dp.add(ps1);
		dp.add(ps2);
		dp.add(ps3);
		
		assertEquals("<DatePicker[Seira,Sophia,Shana]>", dp.toString());
	}
	
	@Test
	public void testEquals()
	{
		DatePicker dp1 = new DatePicker();
		DatePicker dp2 = new DatePicker();
		
		Person ps1 = new Person("Shana", new DateSet());
		ps1.add(new Date("17/2/2014"));
		
		Person ps2 = new Person("Shana", new DateSet());
		ps2.add(new Date("17/2/2014"));
		
		dp1.add(ps1);
		dp2.add(ps2);
		
		assertEquals(ps1, ps2);
	}
	
	// the contained Date objects differ
	@Test
	public void testNotEquals()
	{
		DatePicker dp1 = new DatePicker();
		DatePicker dp2 = new DatePicker();
		
		Person ps1 = new Person("Shana", new DateSet());
		ps1.add(new Date("17/2/2014"));
		
		Person ps2 = new Person("Shana", new DateSet());
		ps2.add(new Date("3/7/2014"));
		
		dp1.add(ps1);
		dp2.add(ps2);
		
		assertNotEquals(ps1, ps2);
	}
	
}
